package com.javabase.demo.service.mongo;

import com.javabase.demo.entity.mongo.MongoData;

import java.util.List;
import java.util.Map;

import com.application.base.mongo.spring.api.MongoBaseService;

/**
 * service 的接口定义(实际使用中可以自行添加)
 * @author bruce
 */
public interface MongoDataService extends MongoBaseService<MongoData> {

	public List<MongoData> findContainAll(Map<String, Object> params);
	
	public List<MongoData> findInAll(Map<String, Object> params);
	
	public List<MongoData> findLikeAll(Map<String, Object> params);
	
}
