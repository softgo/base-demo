package com.javabase.demo.dao.mongo;

import com.javabase.demo.entity.mongo.MongoData;

import java.util.List;
import java.util.Map;

import com.application.base.mongo.spring.api.MongoBaseService;

/**
 * 集合类的顶级Dao接口
 */
public interface MongoDataDao extends MongoBaseService<MongoData> {

	public List<MongoData> findContainAll(Map<String, Object> params);
	
	public List<MongoData> findInAll(Map<String, Object> params);
	
	public List<MongoData> findLikeAll(Map<String, Object> params);
	
}
