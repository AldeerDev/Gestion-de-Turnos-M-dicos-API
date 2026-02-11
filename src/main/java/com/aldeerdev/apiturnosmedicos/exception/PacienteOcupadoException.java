package com.aldeerdev.apiturnosmedicos.exception;

public class PacienteOcupadoException extends RuntimeException{

	public PacienteOcupadoException() {
		super("El paciente ya tiene un turno en la fecha y hora");
	}
}
