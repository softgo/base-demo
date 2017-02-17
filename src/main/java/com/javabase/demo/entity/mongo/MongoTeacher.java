package com.javabase.demo.entity.mongo;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 实体bean
 * 
 */
@Document(collection="mongo_teacher")
public class MongoTeacher implements Serializable {

	private static final long serialVersionUID = 1L;	@Id	private ObjectId _id;//   _id	private String teahcerName;//   teahcerName	private int teacherAge;//   teacherAge	private String teahcerMajor;//   teahcerMajor	private Date graduateTime;//   graduateTime	private String description;//   description
	private String[] students; // students
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getTeahcerName() {
		return teahcerName;
	}
	public void setTeahcerName(String teahcerName) {
		this.teahcerName = teahcerName;
	}
	public int getTeacherAge() {
		return teacherAge;
	}
	public void setTeacherAge(int teacherAge) {
		this.teacherAge = teacherAge;
	}
	public String getTeahcerMajor() {
		return teahcerMajor;
	}
	public void setTeahcerMajor(String teahcerMajor) {
		this.teahcerMajor = teahcerMajor;
	}
	public Date getGraduateTime() {
		return graduateTime;
	}
	public void setGraduateTime(Date graduateTime) {
		this.graduateTime = graduateTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String[] getStudents() {
		return students;
	}
	public void setStudents(String[] students) {
		this.students = students;
	}
	
	
}

