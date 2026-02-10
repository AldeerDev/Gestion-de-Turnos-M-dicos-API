package com.aldeerdev.apiturnosmedicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aldeerdev.apiturnosmedicos.model.Turno;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {

}
