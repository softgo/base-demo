package com.javabase.demo.service.mongo.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javabase.demo.entity.mongo.MongoTeacher;
import com.javabase.demo.dao.mongo.MongoTeacherDao;
import com.javabase.demo.service.mongo.MongoTeacherService;
import com.application.base.utils.page.PageView;

/**
 * 接口定义实现
 * @author bruce
 */
@Service("mongoTeacherService")
public class MongoTeacherServiceImpl implements MongoTeacherService {

	@Autowired
	private MongoTeacherDao mongoTeacherDao;

	public MongoTeacher findObjById(Object id) {
		return mongoTeacherDao.findObjById(id);
	}

	public MongoTeacher findObjByName(String proKey, String proValue) {
		return mongoTeacherDao.findObjByName(proKey, proValue);
	}

	public MongoTeacher findObjByProps(Map<String, Object> params) {
		return mongoTeacherDao.findObjByProps(params);
	}

	public List<MongoTeacher> findObjList(Map<String, Object> params) {
		return mongoTeacherDao.findObjList(params);
	}

	public PageView findObjsByPage(PageView pageView, Map<String, Object> params) {
		return mongoTeacherDao.findObjsByPage(pageView, params);
	}

	public List<MongoTeacher> findObjAll() {
		return mongoTeacherDao.findObjAll();
	}

	public boolean addObjOne(MongoTeacher obj) {
		return mongoTeacherDao.addObjOne(obj);
	}

	public boolean addObjAll(List<MongoTeacher> ts) {
		return mongoTeacherDao.addObjAll(ts);
	}

	public int updateObjOne(Map<String, Object> params, Object id) {
		return mongoTeacherDao.updateObjOne(params, id);
	}

	public boolean updateObjAll(List<Map<String, Object>> ts, List<Object> ids) {
		return mongoTeacherDao.updateObjAll(ts, ids);
	}

	public boolean deleteByObjId(Object id) {
		return mongoTeacherDao.deleteByObjId(id);
	}

	public boolean deleteAll(List<MongoTeacher> ts) {
		return mongoTeacherDao.deleteAll(ts);
	}

	public long getObjsCount() {
		return mongoTeacherDao.getObjsCount();
	}

	public long getObjsByProsCount(Map<String, Object> params) {
		return mongoTeacherDao.getObjsByProsCount(params);
	}

	public MongoTeacher findObjByProps(MongoTeacher t) {
		return mongoTeacherDao.findObjByProps(t);
	}

	public List<MongoTeacher> findObjList(MongoTeacher t) {
		return mongoTeacherDao.findObjList(t);
	}

	public PageView findObjsByPage(PageView pageView, MongoTeacher t) {
		return mongoTeacherDao.findObjsByPage(pageView, t);
	}

	public int updateObjOne(MongoTeacher t, Object id) {
		return mongoTeacherDao.updateObjOne(t, id);
	}

	public long getObjsByProsCount(MongoTeacher t) {
		return mongoTeacherDao.getObjsByProsCount(t);
	}

}
