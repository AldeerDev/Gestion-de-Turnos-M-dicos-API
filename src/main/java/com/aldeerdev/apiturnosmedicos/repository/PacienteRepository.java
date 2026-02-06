package com.aldeerdev.apiturnosmedicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aldeerdev.apiturnosmedicos.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
