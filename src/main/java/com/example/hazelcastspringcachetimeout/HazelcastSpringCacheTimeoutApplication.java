package com.example.hazelcastspringcachetimeout;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableCaching
public class HazelcastSpringCacheTimeoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(HazelcastSpringCacheTimeoutApplication.class, args);
	}

	@Bean
	HazelcastInstance hazelcastInstance() {
		Config config = new Config();
		config.getGroupConfig().setName("cache-test");
		return Hazelcast.newHazelcastInstance(config);
	}
}
