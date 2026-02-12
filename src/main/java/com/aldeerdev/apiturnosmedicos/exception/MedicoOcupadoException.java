package com.aldeerdev.apiturnosmedicos.exception;

public class MedicoOcupadoException extends RuntimeException {

	public MedicoOcupadoException() {
		super("El medico ya tiene turno en ese horario.");
	}
}
