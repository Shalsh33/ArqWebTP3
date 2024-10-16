package com.shalsh.tp3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shalsh.tp3.model.Estudiante_Carrera;
import com.shalsh.tp3.utils.ECId;

@Repository
public interface Estudiante_CarreraRepository extends JpaRepository<Estudiante_Carrera, ECId> {

}
