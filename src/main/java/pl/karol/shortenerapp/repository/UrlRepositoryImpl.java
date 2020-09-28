package pl.karol.shortenerapp.repository;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import pl.karol.shortenerapp.model.UrlBox;

public class UrlRepositoryImpl implements UrlRepository {

	private RedisTemplate<String, String> redisTemplate;

	private HashOperations hashOperations;

	public UrlRepositoryImpl(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;

		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(UrlBox urlBox) {
		//TODO

	}

	@Override
	public UrlBox readById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
