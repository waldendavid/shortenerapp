package pl.karol.shortenerapp.repository;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class UrlRepositoryImpl implements UrlRepository {

	private RedisTemplate<String, String> redisTemplate;

	private HashOperations hashOperations;

	public UrlRepositoryImpl(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;

		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(String LongUrl) {
		hashOperations.put("shortUrl", "shortUrl" , LongUrl);
	}

	@Override
	public String readById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
