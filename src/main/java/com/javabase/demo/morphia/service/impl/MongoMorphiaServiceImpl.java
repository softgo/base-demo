package com.javabase.demo.morphia.service.impl;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.base.utils.page.PageView;
import com.javabase.demo.morphia.dao.MongoMorphiaDao;
import com.javabase.demo.morphia.entity.MongoMorphia;
import com.javabase.demo.morphia.service.MongoMorphiaService;

@Service("mongoMorphiaService")
public class MongoMorphiaServiceImpl implements MongoMorphiaService{

    @Autowired
    private MongoMorphiaDao mongoMorphiaDao;

	public MongoMorphia findObjById(ObjectId pk) {
		return mongoMorphiaDao.findObjById(pk);
	}

	public MongoMorphia findObjByName(String proKey, String proValue) {
		return mongoMorphiaDao.findObjByName(proKey, proValue);
	}

	public MongoMorphia findObjByProps(Map<String, Object> params) {
		return mongoMorphiaDao.findObjByProps(params);
	}

	public List<MongoMorphia> findObjList(PageView pageView, Map<String, Object> params) {
		return mongoMorphiaDao.findObjList(pageView, params);
	}

	public PageView findObjPage(PageView pageView, Map<String, Object> params) {
		return mongoMorphiaDao.findObjPage(pageView, params);
	}

	public List<MongoMorphia> findObjAll() {
		return mongoMorphiaDao.findObjAll();
	}

	public List<MongoMorphia> findObjAllByPros(Map<String, Object> params) {
		return mongoMorphiaDao.findObjAllByPros(params);
	}

	public int addObjOne(MongoMorphia t) {
		return mongoMorphiaDao.addObjOne(t);
	}

	public boolean addObjAll(List<MongoMorphia> ts) {
		return mongoMorphiaDao.addObjAll(ts);
	}

	public int updateObjOne(ObjectId pk, Map<String, Object> params) {
		return mongoMorphiaDao.updateObjOne(pk, params);
	}

	public UpdateResults updateObjOneByResult(Query<MongoMorphia> query, UpdateOperations<MongoMorphia> ops) {
		return mongoMorphiaDao.updateObjOneByResult(query, ops);
	}

	public boolean updateObjAll(List<ObjectId> pks, List<Map<String, Object>> ts) {
		return mongoMorphiaDao.updateObjAll(pks, ts);
	}

	public int deleteByObjId(ObjectId pk) {
		return mongoMorphiaDao.deleteByObjId(pk);
	}

	public boolean deleteObjAll(List<ObjectId> pks) {
		return mongoMorphiaDao.deleteObjAll(pks);
	}

	public long getObjsCount() {
		return mongoMorphiaDao.getObjsCount();
	}

	public long getObjsByProsCount(Map<String, Object> params) {
		return mongoMorphiaDao.getObjsByProsCount(params);
	}

}
