package com.udemy.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.domain.Person;
import com.udemy.services.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{
	private static final Log LOG=LogFactory.getLog(ExampleServiceImpl.class);
	@Override
	public List<Person> getListPeople() {
		List<Person> people= new ArrayList<Person>();
		
		people.add(new Person("John", 23));
		people.add(new Person("Mike", 30));
		people.add(new Person("Eva", 40));
		people.add(new Person("Peter", 19));
		LOG.info("Hello from services");
		return people;
	}
}
