package pl.karol.shortenerapp.repository;

public interface UrlRepository {

	void save(String LongUrl);

	String readById(String id);

}
