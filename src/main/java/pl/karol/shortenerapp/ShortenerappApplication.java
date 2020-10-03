package pl.karol.shortenerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import pl.karol.shortenerapp.model.UrlBox;

@SpringBootApplication
public class ShortenerappApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, UrlBox> redisTemplate() {
		RedisTemplate<String, UrlBox> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

	public static void main(String[] args) {
		SpringApplication.run(ShortenerappApplication.class, args);
	}

}
