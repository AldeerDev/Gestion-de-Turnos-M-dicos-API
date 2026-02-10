package com.aldeerdev.apiturnosmedicos.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldeerdev.apiturnosmedicos.exception.TurnoEnElPasadoException;
import com.aldeerdev.apiturnosmedicos.model.Medico;
import com.aldeerdev.apiturnosmedicos.model.Paciente;
import com.aldeerdev.apiturnosmedicos.model.Turno;
import com.aldeerdev.apiturnosmedicos.model.enums.EstadoTurno;
import com.aldeerdev.apiturnosmedicos.repository.TurnoRepository;

@Service
public class TurnoService {
	
	
	@Autowired
	private TurnoRepository turnoRep;
	
	@Autowired
	private PacienteService pacienteServ;
	
	@Autowired
	private MedicoService medicoServ;

	public Turno crearTurno(Long idPaciente, Long idMedico, Turno turno) {
		Paciente paciente = pacienteServ.obtenerPacientePorId(idPaciente);
		Medico medico = medicoServ.obtenerMedicoPorId(idMedico);
		if (turno.getFecha().isBefore(LocalDate.now())) {
			throw new TurnoEnElPasadoException();
		}
		turno.setPaciente(paciente);
		turno.setMedico(medico);
		turno.setEstado(EstadoTurno.CONFIRMADO);
		return turnoRep.save(turno);
	}
}
