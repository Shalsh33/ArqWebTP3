package com.shalsh.tp3.model;

import jakarta.persistence.*;

@Entity
@Table(name="estudiante")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
	private int libreta;
	
	@Column(nullable = false)
	private int dni;
	
	@Column(name = "nombres", nullable = false, length = 50)
	private String nombres;
	
	@Column(name = "apellido", nullable = false, length = 50)
	private String apellido;
	
	@Column(nullable = false)
	private int edad;
	
	@Column
	private String ciudad;
	
	@Column(nullable = false)
	private char genero;


	@Override
	public String toString() {
		return "Estudiante [libreta=" + libreta + ", dni=" + dni + ", nombres=" + nombres + ", apellido=" + apellido
				+ ", edad=" + edad + ", ciudad=" + ciudad + ", genero=" + genero + "]";
	}

	public int getLibreta() {
		return libreta;
	}

	public void setLibreta(int libreta) {
		this.libreta = libreta;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
}