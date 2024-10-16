package com.shalsh.tp3.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shalsh.tp3.model.Estudiante;
import com.shalsh.tp3.services.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private EstudianteService es;
	
	@PostMapping
	public ResponseEntity<Estudiante> agregarEstudiante(@RequestBody Estudiante e) {
		return es.add(e);
	}
	
	@PostMapping("/{id}")
	@PutMapping("/{id}")
	public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable("id") String id, @RequestBody Estudiante e){
		return es.add(e, id);
	}
	
	@GetMapping
	public ResponseEntity<List<Estudiante>> obtenerTodos(@RequestParam Map<String, String> params){
		return es.findAll(params);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estudiante> obtenerUno(@PathVariable("id") String id){
		return es.findOne(id);
	}
	
	@GetMapping("/dni")
	public ResponseEntity<Estudiante> obtenerUnoByDNI(@RequestParam Map<String, String> params){
		return es.findOneByDNI(params);
	}
}
