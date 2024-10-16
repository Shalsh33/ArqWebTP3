package com.shalsh.tp3.utils;

public class DTO_Matriculacion {

	private int estudiante;
	private int carrera;
	private int antiguedad;
	private boolean graduado;
	
	
	public DTO_Matriculacion() {
		super();
	}
	public DTO_Matriculacion(int estudiante, int carrera, int antiguedad, boolean graduado) {
		super();
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.antiguedad = antiguedad;
		this.graduado = graduado;
	}
	public int getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(int estudiante) {
		this.estudiante = estudiante;
	}
	public int getCarrera() {
		return carrera;
	}
	public void setCarrera(int carrera) {
		this.carrera = carrera;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public boolean isGraduado() {
		return graduado;
	}
	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}
	
	
	
}
