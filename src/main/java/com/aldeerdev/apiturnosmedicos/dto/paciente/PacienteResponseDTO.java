package com.aldeerdev.apiturnosmedicos.dto.paciente;

import java.time.LocalDate;

public class PacienteResponseDTO {

	private Long id;
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private LocalDate fechaNacimiento;
	private Boolean activo;

	public PacienteResponseDTO(Long id, String nombre, String apellido, String dni, String email,
			LocalDate fechaNacimiento, Boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.activo = activo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}
