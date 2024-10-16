package com.shalsh.tp3.utils;

import java.io.Serializable;
import java.util.Objects;

import com.shalsh.tp3.model.Carrera;
import com.shalsh.tp3.model.Estudiante;

import jakarta.persistence.Embeddable;

@Embeddable
public class ECId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Estudiante estudiante;
	
	private Carrera carrera;
	
	public ECId() {
		
	}

	public ECId(Estudiante estudiante, Carrera carrera) {
		this.estudiante = estudiante;
		this.carrera = carrera;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carrera, estudiante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ECId other = (ECId) obj;
		return Objects.equals(carrera.getId(), other.carrera.getId()) && Objects.equals(estudiante.getLibreta(), other.estudiante.getLibreta());
	}

	
	
}
