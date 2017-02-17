package com.javabase.demo.morphia.test;

import com.application.base.core.BaseJunit4Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.application.base.utils.common.JSONUtils;
import com.application.base.utils.page.Common;
import com.application.base.utils.page.PageView;
import com.javabase.demo.morphia.entity.MongoMorphia;
import com.javabase.demo.morphia.service.MongoMorphiaService;

public class MongoMorphiaTest  extends BaseJunit4Test{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MongoMorphiaService mongoMorphiaService;

	@Test
	public void findContainAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		String[] tags = new String[] { "Google"};
		params.put("tags_@contain", tags); // contain 包涵操作
		List<MongoMorphia> allList = mongoMorphiaService.findObjAllByPros(params);
		logger.info("查询所有的记录");
		for (MongoMorphia mongoMorphia : allList) {
			logger.info(JSONUtils.toJson(mongoMorphia));
		}
	}
	
	@Test
	public void findInAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		Set<String> set = new HashSet<String>();
		set.add("Google");
		set.add("Baidu");
		set.add("Sougo");
		params.put("tags_@in", set); // in 包涵操作
		List<MongoMorphia> allList = mongoMorphiaService.findObjAllByPros(params);
		logger.info("查询所有的记录");
		for (MongoMorphia mongoMorphia : allList) {
			logger.info(JSONUtils.toJson(mongoMorphia));
		}
	}
	
	@Test
	public void findLikeAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("title_@like", "教程"); //
		List<MongoMorphia> allList = mongoMorphiaService.findObjAllByPros(params);
		logger.info("查询所有的记录");
		for (MongoMorphia mongoMorphia : allList) {
			logger.info(JSONUtils.toJson(mongoMorphia));
		}
	}
	
	
	@Test
	public void findAll() {
		List<MongoMorphia> datas = this.mongoMorphiaService.findObjAll();
		for (int i = 0; i < datas.size(); i++) {
			logger.info(datas.get(i).getLikes()+"<=====....=====>"+datas.get(i).getTitle());
		}
		logger.info("查询完成.");
	}
	
	@Test
	public void deleteOne() {
		this.mongoMorphiaService.deleteByObjId(new  ObjectId("57ba5f36e883ec394e8e291b"));
		logger.info("修改完成.");
	}

	@Test
	public void updateOne() {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("title", "Mongo 教程");
		params.put("description", "Mongo 是一个全新的数据库");
		this.mongoMorphiaService.updateObjOne(new ObjectId("585b41b36feb21a773a208b8"), params);
		logger.info("修改完成.");
	}

	@Test
	public void addOne() {
		MongoMorphia obj = new MongoMorphia();
		obj.setTitle("Baidu 教程");
		obj.setDescription("Baidu 是一个全新的数据库");
		obj.setBy("Baidu 教程");
		obj.setUrl("www.Baidu.com");
		String[] tags = new String[]{"Google","Baidu","Sougo"};
		obj.setTags(tags);
		obj.setLikes(200);
		this.mongoMorphiaService.addObjOne(obj);
		logger.info("添加完成.");
	}

	public PageView findPage(String pageNow, String pageSize) {
		PageView pageView = null;
		if ((Common.isEmpty(pageNow)) && (Common.isEmpty(pageSize))) {
			pageView = new PageView(1);
		}
		else if ((!Common.isEmpty(pageNow)) && (Common.isEmpty(pageSize))) {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		else if ((Common.isEmpty(pageNow)) && (!Common.isEmpty(pageSize))) {
			pageView = new PageView(1, Integer.parseInt(pageSize));
		}
		else {
			pageView = new PageView(Integer.parseInt(pageNow), Integer.parseInt(pageSize));
		}
		return pageView;
	}
}
