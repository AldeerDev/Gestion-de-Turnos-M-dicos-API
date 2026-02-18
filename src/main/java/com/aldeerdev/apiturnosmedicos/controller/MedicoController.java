package com.aldeerdev.apiturnosmedicos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aldeerdev.apiturnosmedicos.dto.medico.MedicoRequestDTO;
import com.aldeerdev.apiturnosmedicos.dto.medico.MedicoResponseDTO;
import com.aldeerdev.apiturnosmedicos.service.MedicoService;

@RestController
public class MedicoController {

	@Autowired
	private MedicoService service;

	@GetMapping("/medicos/especialidad/{especialidad}")
	public List<MedicoResponseDTO> listarMedicosPorEspecialidad(@PathVariable String especialidad) {
		return service.listarMedicosPorEspecialidad(especialidad);
	}
	
	@GetMapping("/medicos/{id}")
	public MedicoResponseDTO obtenerMedicoPorId(@PathVariable Long id) {
		return service.obtenerMedicoPorId(id);
	}

	@PostMapping("/medicos")
	public MedicoResponseDTO crearMedico(@RequestBody MedicoRequestDTO dto) {
		return service.crearMedico(dto);
	}
	
	@PutMapping("/medicos/{id}")
	public MedicoResponseDTO actualizarMedico(@PathVariable Long id, @RequestBody MedicoRequestDTO dto) {
		return service.actualizarMedico(id, dto);
	}
	
	@DeleteMapping("/medicos/{id}")
	public String eliminarMedico(@PathVariable Long id) {
		service.eliminarMedico(id);
		return "Eliminacion exitosa!";
	}

}
