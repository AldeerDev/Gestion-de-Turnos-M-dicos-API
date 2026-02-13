package com.aldeerdev.apiturnosmedicos.exception;

public class MedicoInactivoException extends RuntimeException {

	public MedicoInactivoException() {
		super("Medico se encuentra inactivo");
	}
}
