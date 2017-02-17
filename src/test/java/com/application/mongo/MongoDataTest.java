package com.application.mongo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.application.base.core.BaseJunit4Test;
import com.application.base.utils.common.JSONUtils;
import com.application.base.utils.page.Common;
import com.application.base.utils.page.PageView;
import com.javabase.demo.entity.mongo.MongoData;
import com.javabase.demo.morphia.entity.MongoMorphia;
import com.javabase.demo.morphia.service.MongoMorphiaService;
import com.javabase.demo.service.mongo.MongoDataService;

public class MongoDataTest  extends BaseJunit4Test {
	
	private Logger logger = LoggerFactory.getLogger(MongoDataTest.class.getName());
	
	@Autowired
	private MongoMorphiaService  mongoMorphiaService;
	@Autowired
	private MongoDataService mongoDataService;
	
	@Test
	public void saveAll() {
		List<MongoMorphia> existsList = mongoMorphiaService.findObjAll();
		List<MongoData> allList = new ArrayList<MongoData>(); 
		for (MongoMorphia mongoMorphia : existsList) {
			MongoData data = new MongoData();
			BeanUtils.copyProperties(mongoMorphia, data);
			data.set_id(null);
			allList.add(data);
		}
		mongoDataService.addObjAll(allList);
		logger.info("添加所有记录成功");
	}
	
	
	@Test
	public void findInAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("by", "Google"); // in 包涵操作
		List<MongoData> allList = mongoDataService.findInAll(params);
		logger.info("查询所有的记录,共size="+allList.size());
		for (MongoData mongoData : allList) {
			logger.info(JSONUtils.toJson(mongoData));
		}
	}
	
	@Test
	public void findLikeAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("by", "^.*Google.*$"); // in 包涵操作
		List<MongoData> allList = mongoDataService.findLikeAll(params);
		logger.info("查询所有的记录,共size="+allList.size());
		for (MongoData mongoData : allList) {
			logger.info(JSONUtils.toJson(mongoData));
		}
	}
	
	@Test
	public void findAll() {
		List<MongoData> datas = this.mongoDataService.findObjAll();
		for (int i = 0; i < datas.size(); i++) {
			logger.info(datas.get(i).getLikes()+"<=====....=====>"+datas.get(i).getTitle());
		}
		logger.info("查询完成.");
	}
	
	@Test
	public void deleteOne() {
		this.mongoDataService.deleteByObjId("585b41b36feb21a773a208b8");
		logger.info("删除完成.");
	}

	@Test
	public void updateOne() {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("title", "Mongo 教程");
		params.put("description", "Mongo 是一个全新的数据库");
		this.mongoDataService.updateObjOne(params,"585b41b36feb21a773a208b8");
		logger.info("修改完成.");
	}

	@Test
	public void addOne() {
		MongoData obj = new MongoData();
		obj.setTitle("Baidu 教程");
		obj.setDescription("Baidu 是一个全新的数据库");
		obj.setBy("Baidu 教程");
		obj.setUrl("www.Baidu.com");
		String[] tags = new String[]{"Google","Baidu","Sougo"};
		obj.setTags(tags);
		obj.setLikes(200);
		this.mongoDataService.addObjOne(obj);
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
