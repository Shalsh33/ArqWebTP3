package com.shalsh.tp3.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shalsh.tp3.model.Estudiante_Carrera;
import com.shalsh.tp3.services.Estudiante_CarreraService;
import com.shalsh.tp3.utils.DTO_Matriculacion;

@RestController
@RequestMapping("/matriculaciones")
public class Estudiante_CarreraController {

	@Autowired
	Estudiante_CarreraService ecs;
	
	@PostMapping
	public ResponseEntity<Estudiante_Carrera> add(@RequestBody DTO_Matriculacion ec){
		return ecs.add(ec);
	}
	
	@GetMapping
	public ResponseEntity<List<Estudiante_Carrera>> getAll(@RequestParam Map<String, String> params){
		return ecs.getAll(params);
	}
	
}
