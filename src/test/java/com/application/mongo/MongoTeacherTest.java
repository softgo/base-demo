package com.application.mongo;

import java.util.Date;
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
import com.javabase.demo.entity.mongo.MongoTeacher;
import com.javabase.demo.service.mongo.MongoTeacherService;

public class MongoTeacherTest  extends BaseJunit4Test {
	
	private Logger logger = LoggerFactory.getLogger(MongoTeacherTest.class.getName());
	
	@Autowired
	private MongoTeacherService mongoTeacherService;

	@Test
	public void findPage() {
	    PageView pageView = findPage("1","10");  
	    Map<String, Object> params =  new HashMap<String, Object>();
	    PageView datas = this.mongoTeacherService.findObjsByPage(pageView, params);
	    logger.info(JSONUtils.toJson(datas));
	    logger.info("查询完成.");
	}
	
	@Test
	public void findAll() {
		List<MongoTeacher> datas = this.mongoTeacherService.findObjAll();
		for (int i = 0; i < datas.size(); i++) {
			logger.info("name="+datas.get(i).getTeahcerName()+",major ="+datas.get(i).getTeahcerMajor());
		}
		logger.info("查询完成.");
	}

	
	@Test
	public void deleteOne() {
		this.mongoTeacherService.deleteByObjId("57ba5f36e883ec394e8e291b");
		System.out.println("删除完成.");
	}

	@Test
	public void updateOne() {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("teahcerName", "李四");
		params.put("teahcerMajor", "数学");
		params.put("teacherAge", "28");
		this.mongoTeacherService.updateObjOne(params, "5857b9206feb219c6d8af916");
		logger.info("修改完成.");
	}

	@Test
	public void addOne() {
		MongoTeacher obj = new MongoTeacher();
		obj.setTeahcerName("test3");
		obj.setTeacherAge(33);
		obj.setTeahcerMajor("英语");
		obj.setGraduateTime(new Date());
		obj.setDescription("他是个好老师.");
		obj.setStudents(new String[]{"7","8","9"});
		this.mongoTeacherService.addObjOne(obj);
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
