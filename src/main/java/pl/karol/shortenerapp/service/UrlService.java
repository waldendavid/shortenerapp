package pl.karol.shortenerapp.service;

public interface UrlService {

	
	public String getLongUrl(String shortUrl);
	public String makeBoxUrl(String longUrl);
}
