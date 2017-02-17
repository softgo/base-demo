package com.javabase.demo.service.mongo.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javabase.demo.entity.mongo.MongoStudent;
import com.javabase.demo.dao.mongo.MongoStudentDao;
import com.javabase.demo.service.mongo.MongoStudentService;
import com.application.base.utils.page.PageView;

/**
 * 接口定义实现
 * @author bruce
 */
@Service("mongoStudentService")
public class MongoStudentServiceImpl implements MongoStudentService {

	@Autowired
	private MongoStudentDao mongoStudentDao;

	public MongoStudent findObjById(Object id) {
		return mongoStudentDao.findObjById(id);
	}

	public MongoStudent findObjByName(String proKey, String proValue) {
		return mongoStudentDao.findObjByName(proKey, proValue);
	}

	public MongoStudent findObjByProps(Map<String, Object> params) {
		return mongoStudentDao.findObjByProps(params);
	}

	public List<MongoStudent> findObjList(Map<String, Object> params) {
		return mongoStudentDao.findObjList(params);
	}

	public PageView findObjsByPage(PageView pageView, Map<String, Object> params) {
		return mongoStudentDao.findObjsByPage(pageView, params);
	}

	public List<MongoStudent> findObjAll() {
		return mongoStudentDao.findObjAll();
	}

	public boolean addObjOne(MongoStudent obj) {
		return mongoStudentDao.addObjOne(obj);
	}

	public boolean addObjAll(List<MongoStudent> ts) {
		return mongoStudentDao.addObjAll(ts);
	}

	public int updateObjOne(Map<String, Object> params, Object id) {
		return mongoStudentDao.updateObjOne(params, id);
	}

	public boolean updateObjAll(List<Map<String, Object>> ts, List<Object> ids) {
		return mongoStudentDao.updateObjAll(ts, ids);
	}

	public boolean deleteByObjId(Object id) {
		return mongoStudentDao.deleteByObjId(id);
	}

	public boolean deleteAll(List<MongoStudent> ts) {
		return mongoStudentDao.deleteAll(ts);
	}

	public long getObjsCount() {
		return mongoStudentDao.getObjsCount();
	}

	public long getObjsByProsCount(Map<String, Object> params) {
		return mongoStudentDao.getObjsByProsCount(params);
	}

	public MongoStudent findObjByProps(MongoStudent t) {
		return mongoStudentDao.findObjByProps(t);
	}

	public List<MongoStudent> findObjList(MongoStudent t) {
		return mongoStudentDao.findObjList(t);
	}

	public PageView findObjsByPage(PageView pageView, MongoStudent t) {
		return mongoStudentDao.findObjsByPage(pageView, t);
	}

	public int updateObjOne(MongoStudent t, Object id) {
		return mongoStudentDao.updateObjOne(t, id);
	}

	public long getObjsByProsCount(MongoStudent t) {
		return mongoStudentDao.getObjsByProsCount(t);
	}

}
