package com.application.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.application.base.core.BaseJunit4Test;
import com.application.base.core.datasource.impl.cache.MutilDefaultCacheReadAndWriteDataSessionFactory;
import com.application.base.redis.api.RedisSession;

public class RedisTest extends BaseJunit4Test {

	@Autowired
	private MutilDefaultCacheReadAndWriteDataSessionFactory factory;

	@Test
	private void redis() {
		
		RedisSession redisSession = factory.getCacheReadDataSession().getRedisSession();
		
		for (int i = 0; i < 10; i++) {
			redisSession.publish("AAA", "往里放信息"+i);
		}
		
	}
}
