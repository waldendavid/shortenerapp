package pl.karol.shortenerapp.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl {

	public static final int ID_SIZE = 6;
	public Map<String, String> urlMap = new HashMap<>();

	// TODO check if method should be public
	public String getLongUrl(String longUrl) {
		if (!IsLongUrl(longUrl)) {
			addUrl(longUrl);
		}

		return urlMap.get(longUrl);
	}

	public String getShortUrl(String longUrl) { // TODO containsValue tutaj można zrobić
		for (Entry<String, String> entry : urlMap.entrySet()) {
			if (longUrl.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;

	}

	public void addUrl(String longUrl) {
		if (!IsLongUrl(longUrl)) {
			urlMap.put(generateShortUrl(), longUrl);
		}
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

	private boolean IsLongUrl(String longUrl) {
		return urlMap.containsValue(longUrl);
	}

}
