package com.javabase.demo.service.mongo.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javabase.demo.entity.mongo.MongoData;
import com.javabase.demo.dao.mongo.MongoDataDao;
import com.javabase.demo.service.mongo.MongoDataService;
import com.application.base.utils.page.PageView;

/**
 * 接口定义实现
 * @author bruce
 */
@Service("mongoDataService")
public class MongoDataServiceImpl implements MongoDataService {

	@Autowired
	private MongoDataDao mongoDataDao;

	public MongoData findObjById(Object id) {
		return mongoDataDao.findObjById(id);
	}

	public MongoData findObjByName(String proKey, String proValue) {
		return mongoDataDao.findObjByName(proKey, proValue);
	}

	public MongoData findObjByProps(Map<String, Object> params) {
		return mongoDataDao.findObjByProps(params);
	}

	public List<MongoData> findObjList(Map<String, Object> params) {
		return mongoDataDao.findObjList(params);
	}

	public PageView findObjsByPage(PageView pageView, Map<String, Object> params) {
		return mongoDataDao.findObjsByPage(pageView, params);
	}

	public List<MongoData> findObjAll() {
		return mongoDataDao.findObjAll();
	}

	public boolean addObjOne(MongoData obj) {
		return mongoDataDao.addObjOne(obj);
	}

	public boolean addObjAll(List<MongoData> ts) {
		return mongoDataDao.addObjAll(ts);
	}

	public int updateObjOne(Map<String, Object> params, Object id) {
		return mongoDataDao.updateObjOne(params, id);
	}

	public boolean updateObjAll(List<Map<String, Object>> ts, List<Object> ids) {
		return mongoDataDao.updateObjAll(ts, ids);
	}

	public boolean deleteByObjId(Object id) {
		return mongoDataDao.deleteByObjId(id);
	}

	public boolean deleteAll(List<MongoData> ts) {
		return mongoDataDao.deleteAll(ts);
	}

	public long getObjsCount() {
		return mongoDataDao.getObjsCount();
	}

	public long getObjsByProsCount(Map<String, Object> params) {
		return mongoDataDao.getObjsByProsCount(params);
	}

	public MongoData findObjByProps(MongoData t) {
		return mongoDataDao.findObjByProps(t);
	}

	public List<MongoData> findObjList(MongoData t) {
		return mongoDataDao.findObjList(t);
	}

	public PageView findObjsByPage(PageView pageView, MongoData t) {
		return mongoDataDao.findObjsByPage(pageView, t);
	}

	public int updateObjOne(MongoData t, Object id) {
		return mongoDataDao.updateObjOne(t, id);
	}

	public long getObjsByProsCount(MongoData t) {
		return mongoDataDao.getObjsByProsCount(t);
	}

	public List<MongoData> findContainAll(Map<String, Object> params){
		return mongoDataDao.findContainAll(params);
	}
	
	public List<MongoData> findInAll(Map<String, Object> params){
		return mongoDataDao.findInAll(params);
	}
	
	public List<MongoData> findLikeAll(Map<String, Object> params){
		return mongoDataDao.findLikeAll(params);
	}
}
