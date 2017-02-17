package com.javabase.demo.service.mongo.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javabase.demo.entity.mongo.MongoScore;
import com.javabase.demo.dao.mongo.MongoScoreDao;
import com.javabase.demo.service.mongo.MongoScoreService;
import com.application.base.utils.page.PageView;

/**
 * 接口定义实现
 * @author bruce
 */
@Service("mongoScoreService")
public class MongoScoreServiceImpl implements MongoScoreService {

	@Autowired
	private MongoScoreDao mongoScoreDao;

	public MongoScore findObjById(Object id) {
		return mongoScoreDao.findObjById(id);
	}

	public MongoScore findObjByName(String proKey, String proValue) {
		return mongoScoreDao.findObjByName(proKey, proValue);
	}

	public MongoScore findObjByProps(Map<String, Object> params) {
		return mongoScoreDao.findObjByProps(params);
	}

	public List<MongoScore> findObjList(Map<String, Object> params) {
		return mongoScoreDao.findObjList(params);
	}

	public PageView findObjsByPage(PageView pageView, Map<String, Object> params) {
		return mongoScoreDao.findObjsByPage(pageView, params);
	}

	public List<MongoScore> findObjAll() {
		return mongoScoreDao.findObjAll();
	}

	public boolean addObjOne(MongoScore obj) {
		return mongoScoreDao.addObjOne(obj);
	}

	public boolean addObjAll(List<MongoScore> ts) {
		return mongoScoreDao.addObjAll(ts);
	}

	public int updateObjOne(Map<String, Object> params, Object id) {
		return mongoScoreDao.updateObjOne(params, id);
	}

	public boolean updateObjAll(List<Map<String, Object>> ts, List<Object> ids) {
		return mongoScoreDao.updateObjAll(ts, ids);
	}

	public boolean deleteByObjId(Object id) {
		return mongoScoreDao.deleteByObjId(id);
	}

	public boolean deleteAll(List<MongoScore> ts) {
		return mongoScoreDao.deleteAll(ts);
	}

	public long getObjsCount() {
		return mongoScoreDao.getObjsCount();
	}

	public long getObjsByProsCount(Map<String, Object> params) {
		return mongoScoreDao.getObjsByProsCount(params);
	}

	public MongoScore findObjByProps(MongoScore t) {
		return mongoScoreDao.findObjByProps(t);
	}

	public List<MongoScore> findObjList(MongoScore t) {
		return mongoScoreDao.findObjList(t);
	}

	public PageView findObjsByPage(PageView pageView, MongoScore t) {
		return mongoScoreDao.findObjsByPage(pageView, t);
	}

	public int updateObjOne(MongoScore t, Object id) {
		return mongoScoreDao.updateObjOne(t, id);
	}

	public long getObjsByProsCount(MongoScore t) {
		return mongoScoreDao.getObjsByProsCount(t);
	}

}
