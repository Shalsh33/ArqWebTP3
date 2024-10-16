package com.shalsh.tp3.services;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shalsh.tp3.model.Estudiante_Carrera;
import com.shalsh.tp3.repository.CarreraRepository;
import com.shalsh.tp3.repository.EstudianteRepository;
import com.shalsh.tp3.repository.Estudiante_CarreraRepository;
import com.shalsh.tp3.utils.DTO_Matriculacion;

@Service
public class Estudiante_CarreraService {

	@Autowired
	Estudiante_CarreraRepository ecr;
	@Autowired
	EstudianteRepository er;
	@Autowired
	CarreraRepository cr;
	
	public ResponseEntity<Estudiante_Carrera> add(int estudiante, int carrera) {
		
		try {
			Estudiante_Carrera ec = new Estudiante_Carrera();
			ec.setEstudiante(er.findById(estudiante).get());
			ec.setCarrera(cr.findById(carrera).get());
			ec = ecr.save(ec);
			return new ResponseEntity<>(ec,HttpStatus.CREATED);
		} catch (IllegalArgumentException | NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
	}
	
	public ResponseEntity<Estudiante_Carrera> add(int estudiante, int carrera, int antiguedad) {
		
		try {
			Estudiante_Carrera ec = new Estudiante_Carrera();
			ec.setEstudiante(er.findById(estudiante).get());
			ec.setCarrera(cr.findById(carrera).get());
			ec.setAntiguedad(antiguedad);
			ec = ecr.save(ec);
			return new ResponseEntity<>(ec,HttpStatus.CREATED);
		} catch (IllegalArgumentException | NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
	}
	
	public ResponseEntity<Estudiante_Carrera> add(DTO_Matriculacion m) {
		
		if (m.getAntiguedad() > 0)
			return this.add(m.getEstudiante(), m.getCarrera(), m.getAntiguedad());
		return this.add(m.getEstudiante(),m.getCarrera());
				
	}
	
	public ResponseEntity<List<Estudiante_Carrera>> getAll(Map<String,String> params){
		
		try {
			return new ResponseEntity<>(ecr.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
