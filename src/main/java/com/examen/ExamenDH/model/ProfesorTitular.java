package com.examen.ExamenDH.model;

public class ProfesorTitular extends Profesor {

	private String especialidad;
	
	

	public ProfesorTitular(String nombre, String apellido, Integer codigoProfesor, String especialidad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.codigoProfesor = codigoProfesor;
		this.especialidad = especialidad;
		this.antiguedad = 0;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	
	
	
}
