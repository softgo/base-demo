package com.javabase.demo.morphia.service;

import org.bson.types.ObjectId;

import com.application.base.mongo.morphia.MonGoBaseDao;
import com.javabase.demo.morphia.entity.MongoMorphia;

public interface MongoMorphiaService extends MonGoBaseDao<MongoMorphia,ObjectId> {
   
}
