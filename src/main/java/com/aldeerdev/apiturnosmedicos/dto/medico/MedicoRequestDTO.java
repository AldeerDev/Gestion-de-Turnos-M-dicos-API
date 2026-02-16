package com.aldeerdev.apiturnosmedicos.dto.medico;

public class MedicoRequestDTO {

	private String nombre;
	private String apellido;
	private String especialidad;
	private String matricula;

	public MedicoRequestDTO(String nombre, String apellido, String especialidad, String matricula) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
