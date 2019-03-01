package com.test.cache.testspringcache;

import com.test.cache.testspringcache.struct.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TestSpringCacheApplication {

	public static void main(String[] args) {
		Test.list.add(1);
		Test.list.add(2);
		Test.list.add(3);
		Test.list.add(4);
		Test.list.add(5);
		SpringApplication.run(TestSpringCacheApplication.class, args);
	}

}
