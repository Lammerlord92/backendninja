package com.udemy.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.domain.Course;
import com.udemy.domain.QCourse;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
	//Q<entidad>
	private QCourse qCourse =QCourse.course;
	
	//Se necesita un EM. Es un objeto que gestiona la persistencia de la aplicación
	@PersistenceContext //Este objeto se encuentra en el contexto de la persistencia de la aplicación
	private EntityManager em;
	
	public Course find(boolean exist){
		JPAQuery<Course> query=new JPAQuery<Course>(em);
		
		Predicate predicate1=qCourse.description.endsWith("OP");
		BooleanBuilder predicateBuilder=new BooleanBuilder(predicate1);
		
		if(exist){
			Predicate predicate2= qCourse.id.eq(23);
			predicateBuilder.and(predicate2);
		}else{
			Predicate predicate3= qCourse.name.endsWith("OP");
			predicateBuilder.or(predicate3);
		}
		//Sacamos de la base de datos el curso con id=23
		//Course course1=query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
		//Sacamos de la base de datos los cursos que duren entre 20 y 50 horas
		//List<Course> courses=query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
		return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
		
	}
}
