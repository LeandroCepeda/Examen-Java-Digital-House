package com.examen.ExamenDH.model;

public abstract class Profesor {
	
	protected String nombre;
	
	protected String apellido;
	
	protected Integer antiguedad;
	
	protected Integer codigoProfesor;

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

	public Integer getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}

	public Integer getCodigoProfesor() {
		return codigoProfesor;
	}

	public void setCodigoProfesor(Integer codigoProfesor) {
		this.codigoProfesor = codigoProfesor;
	}
	
	public boolean equals(Object object) {
		Profesor profesor = (Profesor) object;
		return this.getCodigoProfesor() == profesor.getCodigoProfesor();
	}

}
