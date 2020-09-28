package pl.karol.shortenerapp.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.karol.shortenerapp.model.UrlBox;
import pl.karol.shortenerapp.repository.UrlRepository;

@Service
public class UrlServiceImpl {

	public static final int ID_SIZE = 6;
	public Map<String, String> urlMap = new HashMap<>();

	@Autowired
	UrlRepository urlRepository;

	// TODO check if method should be public
	public String getLongUrl(String shortUrl) {
		UrlBox urlBox = urlRepository.readById(shortUrl);
		return urlBox.getLongUrl();
	}

	public String getShortUrl(String longUrl) {
		for (Entry<String, String> entry : urlMap.entrySet()) {
			if (longUrl.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;

	}

	public String makeBoxUrl(String longUrl) {
		// TODO check if LongUrl is in DB
		String shortUrl = generateShortUrl();
		urlRepository.save(new UrlBox(shortUrl, longUrl));
		return shortUrl;
	}

	public void addUrl(String longUrl) {
		// TODO check if LongUrl is in DB
		urlRepository.save(new UrlBox(generateShortUrl(), longUrl));
	}

	private String generateShortUrl() {
		Random random = new Random();
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder innerUrl = new StringBuilder();
		for (int i = 0; i < ID_SIZE; i++) {
			innerUrl.append(chars.charAt(random.nextInt(chars.length())));
		}
		if (urlMap.containsKey(innerUrl.toString())) {
			generateShortUrl();
		}
		return innerUrl.toString();
	}



}
