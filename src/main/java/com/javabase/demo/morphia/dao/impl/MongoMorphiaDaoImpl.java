package com.javabase.demo.morphia.dao.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.javabase.demo.morphia.BaseMorphiaDAO;
import com.javabase.demo.morphia.dao.MongoMorphiaDao;
import com.javabase.demo.morphia.entity.MongoMorphia;


@Service("mongoMorphiaDao")
public class MongoMorphiaDaoImpl extends BaseMorphiaDAO<MongoMorphia, ObjectId> implements MongoMorphiaDao{

}
