package com.aldeerdev.apiturnosmedicos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldeerdev.apiturnosmedicos.exception.MedicoOcupadoException;
import com.aldeerdev.apiturnosmedicos.exception.PacienteOcupadoException;
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

		// valida si la fecha del turno no es pasada
		if (turno.getFecha().isBefore(LocalDate.now())) {
			throw new TurnoEnElPasadoException();
		}

		List<Turno> turnos = turnoRep.findAll();

		// validar si el paciente tiene un turno pendiente el la fecha y hora
		boolean pacienteOcupado = turnos.stream().filter(t -> t.getPaciente().getId().equals(paciente.getId()))
				.filter(t -> t.getFecha().equals(turno.getFecha())).anyMatch(t -> t.getHora().equals(turno.getHora()));

		if (pacienteOcupado) {
			throw new PacienteOcupadoException();
		}

		// valida disponibilidad del medico en fecha y hora
		boolean medicoOcupado = turnos.stream().filter(t -> t.getMedico().getId().equals(medico.getId()))
				.filter(t -> t.getFecha().equals(turno.getFecha())).anyMatch(t -> t.getHora().equals(turno.getHora()));

		if (medicoOcupado) {
			throw new MedicoOcupadoException();
		}

		turno.setPaciente(paciente);
		turno.setMedico(medico);
		turno.setEstado(EstadoTurno.CONFIRMADO);
		return turnoRep.save(turno);
	}
}
