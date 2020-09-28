package pl.karol.shortenerapp.repository;

import pl.karol.shortenerapp.model.UrlBox;

public interface UrlRepository {

	void save(UrlBox urlBox);

	UrlBox readById(String id);

}
