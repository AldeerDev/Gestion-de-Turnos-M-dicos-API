package com.aldeerdev.apiturnosmedicos.exception;


public class TurnoEnElPasadoException extends RuntimeException{

	public TurnoEnElPasadoException() {
		super("Fecha pasada");
	}
}
