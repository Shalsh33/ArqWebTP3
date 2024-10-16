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

import com.shalsh.tp3.model.Estudiante;
import com.shalsh.tp3.repository.EstudianteRepository;
import com.shalsh.tp3.utils.CriterioEstudiante;

@Service
public class EstudianteService {

	@Autowired
	private EstudianteRepository er;
	
	public ResponseEntity<List<Estudiante>> findAll(Map<String, String> params) {
		//Si recibo parametros get
		if(params != null && ! params.isEmpty()) {
			//mapeo cada petición (el "peso" de los parámetros está puesto al azar)
			if (params.containsKey("criterio")) {
				return findAllOrderBy(params.get("criterio"));
			}
			if (params.containsKey("genero")) {
				return findAllByGenero(params.get("genero").charAt(0));
			}
			if(params.containsKey("carrera")) {
				if(params.containsKey("ciudad")) {
					return findAllByCarrera(params.get("carrera"),params.get("ciudad"));
				}
				return findAllByCarrera(params.get("carrera"));
			}
		}
		//Salida default (sin parámetros o con parámetros que no corresponden a los soportados)
		return getAll();
	}
	
	public ResponseEntity<Estudiante> add(Estudiante e) {
		try {
			Estudiante res = er.save(e);
			return new ResponseEntity<>(res,HttpStatus.CREATED);
		} catch (IllegalArgumentException | OptimisticLockingFailureException exc) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	public ResponseEntity<Estudiante> add(Estudiante e, String id) {
		try {
			if( ! er.findById(Integer.valueOf(id)).isEmpty()) {
				e.setLibreta(Integer.valueOf(id));
				Estudiante res = er.save(e);
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
	
	public ResponseEntity<List<Estudiante>> getAll() {
		
		try {
			List<Estudiante> res = er.findAll();
			return new ResponseEntity<>(res,HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<List<Estudiante>> findAllOrderBy(String criterio) {
		
		try {
			//revisar
			List<Estudiante> res = er.findAllOrderBy(CriterioEstudiante.valueOf(criterio.toUpperCase()));
			return new ResponseEntity<>(res,HttpStatus.OK);
		} catch(IllegalArgumentException ex) {
			return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<List<Estudiante>> findAllByGenero(char genero) {
		
		try {
			List<Estudiante> res = er.findAllByGenero(genero);
			return new ResponseEntity<>(res,HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<List<Estudiante>> findAllByCarrera(String carrera) {
		
		try {
			List<Estudiante> res = er.findAllByCarrera(carrera);
			return new ResponseEntity<>(res,HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<List<Estudiante>> findAllByCarrera(String carrera, String ciudad) {
		
		try {
			List<Estudiante> res = er.findAllByCarreraCiudad(carrera,ciudad);
			return new ResponseEntity<>(res,HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<Estudiante> findOne(String libreta){
		
		try {
			Optional<Estudiante> res = er.findById(Integer.valueOf(libreta));
			return new ResponseEntity<>(res.get(),HttpStatus.OK);	
		} catch (IllegalArgumentException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (NoSuchElementException ex){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//Tira error cuando hay DNIs duplicados. Hay que añadir una comprobación de integridad para hacer el DNI único
	public ResponseEntity<Estudiante> findOneByDNI(Map<String, String> params){
		
		try {
			Estudiante res = er.findOneByDNI(Integer.valueOf(params.get("dni")));
			if (res != null)
				return new ResponseEntity<>(res,HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (IllegalArgumentException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
