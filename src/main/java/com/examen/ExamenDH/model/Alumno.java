package com.examen.ExamenDH.model;

public class Alumno {
	private String nombre;
	
	private String apellido;
	
	private Integer codigoAlumno;
	

	public Alumno(String nombre, String apellido, Integer codigoAlumno) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.codigoAlumno = codigoAlumno;
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


	public Integer getCodigoAlumno() {
		return codigoAlumno;
	}


	public void setCodigoAlumno(Integer codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}
	
	public boolean equals(Alumno alumno) {
		return this.getCodigoAlumno() == alumno.getCodigoAlumno();
	}
	
	

}
