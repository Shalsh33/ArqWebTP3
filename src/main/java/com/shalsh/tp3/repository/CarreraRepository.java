package com.shalsh.tp3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shalsh.tp3.dto.DTO_Carrera;
import com.shalsh.tp3.model.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

	@Query(value = "SELECT c FROM Carrera c JOIN Estudiante_Carrera ec "
			+ "ON c = ec.carrera GROUP BY c.id "
			+ "ORDER BY COUNT(ec) DESC ")
	List<Carrera> findAllOrderByMatricula();
	
	@Query(value = "SELECT c FROM Carrera c WHERE c.nombre = :nombre")
	Carrera findByNombre(@Param("nombre") String nombre);

	@Query(value = "SELECT new com.shalsh.tp3.dto.DTO_Carrera(c) FROM Carrera c ORDER BY nombre ASC")
	List<DTO_Carrera> findCarrerasReporte();
}
