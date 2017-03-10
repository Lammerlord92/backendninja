package com.udemy.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.domain.Course;

@Repository("courseJPARepository")     //Nombre de repositorio
public interface CourseJPARepository extends JpaRepository<Course, Serializable>{ //Se hace refencia a la entidad Course
	//Genera una query que busca por el atributo indicado findBy<<nombreAtributo>>
	public abstract Course findByPrice(int price);
	//Nos monta una query buscando por precio y nombre
	public abstract Course findByPriceAndName(int price,String name);
	//Busca todos los cursos y los ordena por horas
	public abstract List<Course> findByNameOrderByHours(String name);
}
