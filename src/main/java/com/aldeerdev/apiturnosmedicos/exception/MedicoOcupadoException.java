package com.aldeerdev.apiturnosmedicos.exception;

public class MedicoOcupadoException extends RuntimeException{

	public MedicoOcupadoException() {
		super("El médico ya tiene un turno en esa fecha y hora");
	}
}
