package com.shalsh.tp3.dto;

import java.io.Serializable;

public class DTO_Estudiante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int libreta;
	private String nombre;
	private String apellido;
	private int year;
	
	public DTO_Estudiante(int libreta, String nombre, String apellido, int year) {
		this.libreta = libreta;
		this.nombre = nombre;
		this.apellido = apellido;
		this.year = year;
	}
	
	public DTO_Estudiante(int libreta, String nombre, String apellido) {
		this.libreta = libreta;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public int getLibreta() {
		return libreta;
	}
	public void setLibreta(int libreta) {
		this.libreta = libreta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "DTO_Estudiante [libreta=" + libreta + ", nombre=" + nombre + ", apellido=" + apellido + ", year=" + year
				+ "]";
	}
	
	
	
}
