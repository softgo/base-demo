package com.javabase.demo.morphia.dao;

import org.bson.types.ObjectId;

import com.application.base.mongo.morphia.MonGoBaseDao;
import com.javabase.demo.morphia.entity.MongoMorphia;

public interface MongoMorphiaDao extends MonGoBaseDao<MongoMorphia,ObjectId>{
	
}
