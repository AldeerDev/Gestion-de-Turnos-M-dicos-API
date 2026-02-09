package com.aldeerdev.apiturnosmedicos.exception;

public class MedicoNotFoundException extends RuntimeException {

	public MedicoNotFoundException(Long id) {
		super("Médico no encontrado con id: " + id);
	}
}
