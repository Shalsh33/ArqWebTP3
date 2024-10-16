package com.shalsh.tp3.services;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shalsh.tp3.dto.DTO_Carrera;
import com.shalsh.tp3.model.Carrera;
import com.shalsh.tp3.repository.CarreraRepository;
import com.shalsh.tp3.repository.EstudianteRepository;

@Service
public class CarreraService {

	@Autowired
	private CarreraRepository cr;
	@Autowired
	private EstudianteRepository er;
	
	public ResponseEntity<Carrera> findOne(String id) {
		
		try {
			Optional<Carrera> res = cr.findById(Integer.valueOf(id));
			return new ResponseEntity<>(res.get(),HttpStatus.OK);
		}  catch (IllegalArgumentException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (NoSuchElementException ex){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<Carrera> findOneByName(Map<String,String> args){
		
		try {
			Carrera res = cr.findByNombre(args.get("nombre"));
			if (res != null)
				return new ResponseEntity<>(res,HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}  catch (IllegalArgumentException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<Carrera> add(Carrera c) {
		try {
			Carrera res = cr.save(c);
			return new ResponseEntity<>(res,HttpStatus.CREATED);
		} catch (IllegalArgumentException | OptimisticLockingFailureException exc) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	public ResponseEntity<Carrera> add(Carrera c, String id) {
		try {
			if( ! cr.findById(Integer.valueOf(id)).isEmpty()) {
				c.setId(Integer.valueOf(id));
				Carrera res = cr.save(c);
				return new ResponseEntity<>(res,HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (IllegalArgumentException | OptimisticLockingFailureException exc) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	public ResponseEntity<List<Carrera>> getAll() {
		
		try {
			List<Carrera> res = cr.findAll();
			return new ResponseEntity<>(res,HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<List<Carrera>> getAllOrderByMatricula() {
		
		try {
			List<Carrera> res = cr.findAllOrderByMatricula();
			return new ResponseEntity<>(res,HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<List<DTO_Carrera>> reporteCarreras(){
		
		try {
			List<DTO_Carrera> res = cr.findCarrerasReporte();
			for(DTO_Carrera c : res) {
				c.setEstudiantes(er.findDTOReporte(c.getCarrera()));
			}
			return new ResponseEntity<>(res,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	public ResponseEntity<List<Carrera>> findAll(Map<String, String> params) {
		if(params != null && ! params.isEmpty()) {
			if(params.containsKey("matricula")) {
				return this.getAllOrderByMatricula();
			}
		}
		return getAll();
	}
	
}
