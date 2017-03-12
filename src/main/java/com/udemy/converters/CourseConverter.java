package com.udemy.converters;

import org.springframework.stereotype.Component;

import com.udemy.domain.Course;
import com.udemy.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {
	//Entity ---> Model
	public CourseModel entityToModel(Course course){
		CourseModel res=new CourseModel();
		res.setName(course.getName());
		res.setDescription(course.getDescription());
		res.setHours(course.getHours());
		res.setPrice(course.getPrice());
		return res;
		
	}
	//Model ---> Entity
	public Course modelToEntity(CourseModel course){
		Course res=new Course();
		res.setName(course.getName());
		res.setDescription(course.getDescription());
		res.setHours(course.getHours());
		res.setPrice(course.getPrice());
		return res;
	}
	
}
