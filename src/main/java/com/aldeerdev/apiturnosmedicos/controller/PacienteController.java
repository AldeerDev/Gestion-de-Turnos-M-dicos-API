package com.aldeerdev.apiturnosmedicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aldeerdev.apiturnosmedicos.model.Paciente;
import com.aldeerdev.apiturnosmedicos.service.PacienteService;

@RestController
public class PacienteController {

	@Autowired
	private PacienteService service;
	
	@PostMapping("/pacientes")
	public Paciente crearPaciente(@RequestBody Paciente paciente) {
		return service.crearPaciente(paciente);
	}
}
