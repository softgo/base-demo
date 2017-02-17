package com.javabase.demo.dao.mongo.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.application.base.mongo.spring.api.BaseQueryService;
import com.application.base.utils.page.PageView;
import com.javabase.demo.dao.mongo.MongoTeacherDao;
import com.javabase.demo.entity.mongo.MongoTeacher;
import com.mongodb.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * 接口实现.
 * @author bruce
 */
@Service("mongoTeacherDao")
public class MongoTeacherDaoImpl extends BaseQueryService<MongoTeacher> implements MongoTeacherDao{
	
	private Logger logger = LoggerFactory.getLogger(MongoTeacherDaoImpl.class.getName());

		
	@Autowired
	private MongoTemplate mongoTemplateRead;
	@Autowired
	private MongoTemplate mongoTemplateWrite;
		

	@SuppressWarnings("rawtypes")
	public Class getClassName() {
		return MongoTeacher.class;
	}

	@SuppressWarnings("unchecked")
	public MongoTeacher findObjById(Object id) {
		try {
		  		  
			 return (MongoTeacher) this.mongoTemplateRead.findById(id, getClassName());
		  		  
		}
		catch (Exception e) {
			this.logger.error("添加一个对象到mongodb中去失败,error=" + e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public MongoTeacher findObjByName(String proKey, String proValue) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where(proKey).is(proValue));
		  		  
		  	return (MongoTeacher) this.mongoTemplateRead.findOne(query, getClassName());
		  		  
		}
		catch (Exception e) {
			this.logger.error("通过key=" + proKey + ",value=" + proValue + "查找一个Document对象失败.");
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public MongoTeacher findObjByProps(MongoTeacher t) {
		try {
			Query query = buildBaseQuery(t, "eq", null);
		  		  
		  	return (MongoTeacher) this.mongoTemplateRead.findOne(query, getClassName());
		  		  
		}
		catch (Exception e) {
			this.logger.error("通过属性查找对象失败,", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public MongoTeacher findObjByProps(Map<String, Object> params) {
		try {
			Query query = buildBaseQuery(params, "eq", null);
		  		  
		  	return (MongoTeacher) this.mongoTemplateRead.find(query, getClassName());
		  		  
		}
		catch (Exception e) {
			this.logger.error("通过属性查找对象失败,", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<MongoTeacher> findObjList(MongoTeacher t) {
		try {
			Query query = buildBaseQuery(t, "eq", null);
		  		  
		  	return  this.mongoTemplateRead.find(query, getClassName());
		  		  
		}
		catch (Exception e) {
			this.logger.error("查找List对象失败了", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<MongoTeacher> findObjList(Map<String, Object> params) {
		try {
			Query query = buildBaseQuery(params, "eq", null);
		  		  
		  	return  this.mongoTemplateRead.find(query, getClassName());
		  		  
		}
		catch (Exception e) {
			this.logger.error("通过属性查找List失败了", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public PageView findObjsByPage(PageView pageView, MongoTeacher t) {
		try {
			int pageNow = pageView.getPageNow();
			int startIndex = 0;
			int pageSize = pageView.getPageSize();
			if (pageNow == 1) startIndex = 0;
			else {
				startIndex = (pageNow - 1) * pageView.getPageSize();
			}
			Query query = buildBaseQuery(t, "eq", null);
			query.skip(startIndex);
			query.limit(pageSize);
			List<MongoTeacher> list = null;
		  		  
		  	list = this.mongoTemplateRead.find(query, getClassName());
		  		  
			pageView.setRecords(list);
			pageView.setRowCount(getObjsByProsCount(t));
			return pageView;
			
		}
		catch (Exception e) {
			this.logger.error("分页查找对象失败了", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public PageView findObjsByPage(PageView pageView, Map<String, Object> params) {
		try {
			int pageNow = pageView.getPageNow();
			int startIndex = 0;
			int pageSize = pageView.getPageSize();
			if (pageNow == 1) startIndex = 0;
			else {
				startIndex = (pageNow - 1) * pageView.getPageSize();
			}
			Query query = buildBaseQuery(params, "eq", null);
			query.skip(startIndex);
			query.limit(pageSize);
			List<MongoTeacher> list = null;
		  		  
		  	list = this.mongoTemplateRead.find(query, getClassName());
		  		  
			pageView.setRecords(list);
			pageView.setRowCount(getObjsByProsCount(params));
			return pageView;
		}
		catch (Exception e) {
			this.logger.error("分页查找对象失败了", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<MongoTeacher> findObjAll() {
		try {
			Query query = new Query();
		  		  
		  	return  this.mongoTemplateRead.find(query, getClassName());
		  		  
		}
		catch (Exception e) {
			this.logger.error("查找所有失败了", e);
			return null;
		}
	}
	
	public boolean addObjOne(MongoTeacher obj) {
		try {
		  		  
		  	this.mongoTemplateWrite.insert(obj);
		  		  
			return true;
		}
		catch (Exception e) {
			this.logger.error("保存对象失败了", e);
			return false;
		}
	}

	public boolean addObjAll(List<MongoTeacher> ts) {
		try {
		  		  
		  	this.mongoTemplateWrite.insertAll(ts);
		  		  
			return true;
		}
		catch (Exception e) {
			this.logger.error("添加所有失败了", e);
			return false;
		}
	}

	public int updateObjOne(MongoTeacher t, Object id) {
		try {
			Query query = new Query(new Criteria("_id").is(id));
			Update update = buildBaseUpdate(t);
			WriteResult result = null;
		  		  
		  	result = this.mongoTemplateWrite.updateFirst(query, update, getClassName());
		  		  
			if (result != null) {
				return 1;
			}
			return -1;
		}
		catch (Exception e) {
			this.logger.error("修改对象失败了", e);
			return -1;
		}
	}

	public int updateObjOne(Map<String, Object> params, Object id) {
		try {
			Query query = new Query(new Criteria("_id").is(id));
			Update update = buildBaseUpdate(params);
			WriteResult result = null;
		  		  
		  	result = this.mongoTemplateWrite.updateFirst(query, update, getClassName());
		  		  
			if (result != null) {
				return 1;
			}
			return -1;
		}
		catch (Exception e) {
			this.logger.error("修改对象失败了", e);
			return -1;
		}
	}

	public boolean updateObjAll(List<Map<String, Object>> ts, List<Object> ids) {
		try {
			boolean result = true;
			int i = 0;
			for (int  j = 0; i < ids.size(); j++) {
				Object id = ids.get(i);
				Map<String, Object> param = ts.get(j);
				updateObjOne(param, id);
				i++;
			}
			return result;
		}
		catch (Exception e) {
			this.logger.error("修改所有对象失败了", e);
			return false;
		}
	}

	public boolean deleteByObjId(Object id) {
		try {
			Query query = new Query(new Criteria("_id").is(id));
		  		  
		  	this.mongoTemplateWrite.remove(query, getClassName());
		  		  
			return true;
		}
		catch (Exception e) {
			this.logger.error("删除对象失败了,id=" + id);
			return false;
		}
	}

	public boolean deleteAll(List<MongoTeacher> ts) {
		try {
			for (MongoTeacher t : ts) {
				Object id = t.get_id();
				deleteByObjId(id);
			}
			return true;
		}
		catch (Exception e) {
			this.logger.error("删除所有失败了", e);
			return false;
		}
	}

	public long getObjsCount() {
		try {
		  		  
		  	return this.mongoTemplateWrite.count(new Query(), getClassName());
		  		  
		}
		catch (Exception e) {
			this.logger.error("查找所有记录失败了", e);
			return 0L;
		}
	}

	public long getObjsByProsCount(MongoTeacher t) {
		try {
			Query query = buildBaseQuery(t, "eq", null);
		  		  
		  	return this.mongoTemplateWrite.count(query, getClassName());
		  		  
		}
		catch (Exception e) {
			this.logger.error("通过属性查找对象失败了", e);
			return 0L;
		}
	}

	public long getObjsByProsCount(Map<String, Object> params) {
		try {
			Query query = buildBaseQuery(params, "eq", null);
		  		  
		  	return this.mongoTemplateWrite.count(query, getClassName());
		  		  
		}
		catch (Exception e) {
			this.logger.error("通过属性查找对象失败了", e);
			return 0L;
		}
	}
}
