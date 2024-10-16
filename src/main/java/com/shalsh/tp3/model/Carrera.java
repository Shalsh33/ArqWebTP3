package com.shalsh.tp3.model;

import jakarta.persistence.*;

@Entity
@Table(name="carrera")
public class Carrera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
	private int id;
	
	@Column(name = "nombres", nullable = false, length = 50)
	private String nombre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Carrera [id=" + id + ", nombre=" + nombre + "]";
	}
	
}

