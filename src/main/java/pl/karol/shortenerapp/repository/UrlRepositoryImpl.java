package pl.karol.shortenerapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import pl.karol.shortenerapp.model.UrlBox;

@Repository
public class UrlRepositoryImpl implements UrlRepository {

	@Autowired
	private RedisTemplate redisTemplate;

	private HashOperations hashOperations;

	public UrlRepositoryImpl(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(UrlBox urlBox) {
		hashOperations.put("URLBOX", urlBox.getShortUrl(), urlBox);

	}

	@Override
	public UrlBox readById(String id) {
		return (UrlBox) hashOperations.get("URLBOX", id);
	}

}
