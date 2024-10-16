package com.shalsh.tp3.dto;

import java.io.Serializable;
import java.util.List;

import com.shalsh.tp3.model.Carrera;


public class DTO_Carrera implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Carrera c;
	private List<DTO_Estudiante> estudiantes;
	
	public DTO_Carrera(Carrera c) {
		this.c = c;
	}
	
	public String getNombre() {
		return c.getNombre();
	}
	public void setNombre(String nombre) {
		c.setNombre(nombre);
	}
	public Carrera getCarrera() {
		return c;
	}
	public List<DTO_Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(List<DTO_Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public String toString() {
		return "DTO_Carrera [c=" + c + ", estudiantes=" + estudiantes + "]";
	}
	
	
	
	
}
