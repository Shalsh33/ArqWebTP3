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

import com.shalsh.tp3.dto.DTO_Carrera;
import com.shalsh.tp3.model.Carrera;
import com.shalsh.tp3.services.CarreraService;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

	@Autowired
	private CarreraService cs;
	
	@PostMapping
	public ResponseEntity<Carrera> agregarCarrera(@RequestBody Carrera c) {
		return cs.add(c);
	}
	
	@PostMapping("/{id}")
	@PutMapping("/{id}")
	public ResponseEntity<Carrera> actualizarCarrera(@PathVariable String id, @RequestBody Carrera c){
		return cs.add(c, id);
	}
	
	@GetMapping
	public ResponseEntity<List<Carrera>> obtenerTodas(@RequestParam Map<String, String> params){
		return cs.findAll(params);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carrera> obtenerUna(@PathVariable String id){
		return cs.findOne(id);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Carrera> obtenerUnaPorNombre(@RequestParam Map<String, String> params){
		return cs.findOneByName(params);
	}
	
	@GetMapping("/reporte")
	public ResponseEntity<List<DTO_Carrera>> reporte(){
		return cs.reporteCarreras();
	}
	
}
