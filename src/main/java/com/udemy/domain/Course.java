package com.udemy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course") // No hace falta si la clase se llama igual que la tabla
public class Course {
	//-------------- Atributos -------------
	@Id // Es una id
	@GeneratedValue // hibernate genera el valor automáticamente
	@Column(name = "id") // Nombre de la columna de la BD
	private int id;// Si fuera algo así como idCourse se transformaría en
					// id_course usando hibernate, pudiendo crear conflictos

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private int price;

	@Column(name = "hours")
	private int hours;

	
	//-------------- Constructores -------------
	// Constructor usado por defecto, no hace falta ponerlo si no ponemos otro
	public Course() {
	};

	public Course(int id, String name, String description, int price, int hours) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.hours = hours;
	}

	//-------------- Gets & Sets -------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

}
