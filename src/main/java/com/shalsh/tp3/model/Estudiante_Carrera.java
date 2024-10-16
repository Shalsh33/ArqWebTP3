package com.shalsh.tp3.model;

import com.shalsh.tp3.utils.ECId;

import jakarta.persistence.*;

@Entity
@Table(name="estudiante_carrera")
@IdClass(ECId.class)
public class Estudiante_Carrera {

	@Id
	@ManyToOne
	@JoinColumn(name="id_estudiante", foreignKey = @ForeignKey(name= "FK_estudiante",foreignKeyDefinition = "FOREIGN KEY (`id_estudiante`) REFERENCES `estudiante` (`libreta`) ON DELETE CASCADE ON UPDATE CASCADE",value = ConstraintMode.CONSTRAINT))
	private Estudiante estudiante;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_carrera", foreignKey = @ForeignKey(name= "FK_carrera", foreignKeyDefinition= "FOREIGN KEY(`id_carrera`) REFERENCES `carrera` (`id`) ON DELETE CASCADE ON UPDATE CASCADE",value = ConstraintMode.CONSTRAINT))
	private Carrera carrera;
	
	@Column
	private int antiguedad;
	
	@Column
	private boolean graduado;

	
	
	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
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

	@Override
	public String toString() {
		return "Estudiante_Carrera [estudiante=" + estudiante + ", carrera=" + carrera + ", antiguedad="
				+ antiguedad + ", graduado=" + graduado + "]";
	}
	
	
	
}