package com.application.mongo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.application.base.core.BaseJunit4Test;
import com.application.base.utils.common.JSONUtils;
import com.application.base.utils.page.Common;
import com.application.base.utils.page.PageView;
import com.javabase.demo.entity.mongo.MongoStudent;
import com.javabase.demo.service.mongo.MongoStudentService;
import com.javabase.demo.service.mongo.MongoTeacherService;

public class MongoStudentTest  extends BaseJunit4Test {
	
	private Logger logger = LoggerFactory.getLogger(MongoStudentTest.class.getName());
	
	@Autowired
	private MongoStudentService mongoStudentService;
	@Autowired
	private MongoTeacherService  mongoTeacherService;
	
	@Test
	public void findPage() {
	    PageView pageView = findPage("1","10");  
	    Map<String, Object> params =  new HashMap<String, Object>();
	    PageView datas = this.mongoStudentService.findObjsByPage(pageView, params);
	    logger.info(JSONUtils.toJson(datas));
	    logger.info("查询完成.");
	}
	
	@Test
	public void findAll() {
		List<MongoStudent> datas = this.mongoStudentService.findObjAll();
		for (int i = 0; i < datas.size(); i++) {
			logger.info("name="+datas.get(i).getStudentName()+",teachers ="+datas.get(i).getTeachers());
		}
		logger.info("查询完成.");
	}
	
	
	@Test
	public void deleteOne() {
		this.mongoStudentService.deleteByObjId("57ba5f36e883ec394e8e291b");
		System.out.println("删除完成.");
	}

	@Test
	public void updateOne() {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("teahcerName", "李四");
		this.mongoStudentService.updateObjOne(params, "58578d6c6feb219b2bc02215");
		logger.info("修改完成.");
	}

	@Test
	public void addOne() {
		MongoStudent obj = new MongoStudent();
		obj.setStudentName("test3");
		obj.setStudentAge(19);
		obj.setClassName("高四");
		obj.setDescription("他学习很刻苦.");
		obj.setTeachers(mongoTeacherService.findObjAll());
		this.mongoStudentService.addObjOne(obj);
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
