package com.udemy.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.domain.Course;
import com.udemy.repositories.CourseJPARepository;
import com.udemy.services.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService{
	@Autowired
	@Qualifier("courseJPARepository")
	private CourseJPARepository courseJPARepository;
	
	private static final Log LOG =LogFactory.getLog(CourseServiceImpl.class);

	
	@Override
	public List<Course> findAll() {
		LOG.info("Call: "+"listAllCourses()");
		return courseJPARepository.findAll();
	}

	@Override
	public Course getCourse(int id) {
		Course res=courseJPARepository.findOne(id);
		return res;
	}

	@Override
	public Course saveCourse(Course course) {
		LOG.info("Call: "+"saveCourse()");
		return courseJPARepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		courseJPARepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		return courseJPARepository.save(course);
	}

}
