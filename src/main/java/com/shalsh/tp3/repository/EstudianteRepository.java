package com.shalsh.tp3.repository;

import org.springframework.stereotype.Repository;

import com.shalsh.tp3.dto.DTO_Estudiante;
import com.shalsh.tp3.model.Carrera;
import com.shalsh.tp3.model.Estudiante;
import com.shalsh.tp3.utils.CriterioEstudiante;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Integer> {

	@Query(value = "SELECT e FROM Estudiante e ORDER BY :criterio")
    List<Estudiante> findAllOrderBy(@Param("criterio") CriterioEstudiante criterio);
	
	@Query(value = "SELECT e FROM Estudiante e WHERE e.genero = :genero")
    List<Estudiante> findAllByGenero(@Param("genero") char genero);
	
	@Query(value = "SELECT e FROM Estudiante e WHERE e.dni = :dni")
	Estudiante findOneByDNI(@Param("dni") Integer dni);
	
	@Query(value = "SELECT e FROM Estudiante e WHERE e.ciudad = :ciudad AND e IN (SELECT ec.estudiante FROM Estudiante_Carrera ec WHERE ec.carrera IN (SELECT c FROM Carrera c WHERE c.nombre = :carrera) )")
	List<Estudiante> findAllByCarreraCiudad(@Param("carrera") String carrera, @Param("ciudad") String ciudad);
	
	@Query(value = "SELECT e FROM Estudiante e WHERE e IN (SELECT ec.estudiante FROM Estudiante_Carrera ec WHERE ec.carrera IN (SELECT c FROM Carrera c WHERE c.nombre = :carrera) )")
	List<Estudiante> findAllByCarrera(@Param("carrera") String carrera);

	@Query(value = "SELECT new com.shalsh.tp3.dto.DTO_Estudiante(e.libreta, e.nombres, e.apellido, ec.antiguedad) "
			+ "FROM Estudiante e JOIN Estudiante_Carrera ec ON e = ec.estudiante "
			+ "WHERE ec.carrera = :carrera "
			+ "ORDER BY ec.antiguedad DESC")
	List<DTO_Estudiante> findDTOReporte(@Param("carrera") Carrera c);
}
