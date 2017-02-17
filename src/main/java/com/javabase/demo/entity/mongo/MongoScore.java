package com.javabase.demo.entity.mongo;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 实体bean
 * 
 */
@Document(collection="mongo_score")
public class MongoScore implements Serializable {

	private static final long serialVersionUID = 1L;	@Id	private ObjectId _id;//   _id	private String scoreName;//   scoreName	private int scoreNum;//   scoreNum	private String majorName;//   majorName	private String description;//   description	private List<MongoTeacher> teachers;//   teachers	private List<MongoStudent> students;//   students
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getScoreName() {
		return scoreName;
	}
	public void setScoreName(String scoreName) {
		this.scoreName = scoreName;
	}
	public int getScoreNum() {
		return scoreNum;
	}
	public void setScoreNum(int scoreNum) {
		this.scoreNum = scoreNum;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<MongoTeacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<MongoTeacher> teachers) {
		this.teachers = teachers;
	}
	public List<MongoStudent> getStudents() {
		return students;
	}
	public void setStudents(List<MongoStudent> students) {
		this.students = students;
	}}

