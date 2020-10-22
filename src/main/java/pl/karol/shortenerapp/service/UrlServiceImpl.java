package pl.karol.shortenerapp.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.karol.shortenerapp.model.UrlBox;
import pl.karol.shortenerapp.repository.UrlRepository;

@Service
public class UrlServiceImpl implements UrlService {

	public static final int ID_SIZE = 6;

	@Autowired
	UrlRepository urlRepository;

	// TODO check if method should be public
	public String getLongUrl(String shortUrl) {
		UrlBox urlBox = urlRepository.readById(shortUrl);
		return urlBox.getLongUrl();
	}

	public String makeBoxUrl(String longUrl) {
		String shortUrl = generateShortUrl();
		urlRepository.save(new UrlBox(shortUrl, longUrl));
		return shortUrl;
	}

	private String generateShortUrl() {
		Random random = new Random();
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder innerUrl = new StringBuilder();
		for (int i = 0; i < ID_SIZE; i++) {
			innerUrl.append(chars.charAt(random.nextInt(chars.length())));
		} // check if shortUrl is in DB
		UrlBox urlBox = urlRepository.readById(innerUrl.toString());
		if (urlBox == null) {
			generateShortUrl();
		}
		return innerUrl.toString();
	}

}
