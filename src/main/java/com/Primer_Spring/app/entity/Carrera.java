package com.Primer_Spring.app.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Carreras")
public class Carrera implements Serializable {

	private static final long serialVersionUID = -3758221199180713810L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id_carrera;

private String nombre;

private int cantidad_annyos;

	public Long getId_carrera() {
	return id_carrera;
}

public void setId_carrera(Long id_carrera) {
	this.id_carrera = id_carrera;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getCantidad_annyos() {
	return cantidad_annyos;
}

public void setCantidad_annyos(int cantidad_annyos) {
	this.cantidad_annyos = cantidad_annyos;
}

	public Carrera() {
		// TODO Auto-generated constructor stub
	}

}
