package com.example.hazelcastspringcachetimeout;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HazelcastSpringCacheTimeoutApplicationTests {

	@Autowired
	DummyCacheService  dummyCacheService;

	@Test
	public void cacheTest() {
		String val = dummyCacheService.getValue(1);
		Assert.assertEquals(val, "1");
	}

}
