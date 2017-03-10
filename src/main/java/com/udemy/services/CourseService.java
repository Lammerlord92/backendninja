package com.udemy.services;

import java.util.List;

import com.udemy.domain.Course;

public interface CourseService {
	public abstract List<Course> findAll();
	public abstract Course createCourse(Course course);
	public abstract int removeCourse(int id);
	public abstract Course updateCourse(Course course);
}