package com.examen.ExamenDH.model;

import java.util.Date;

public class Inscripcion {
	
	private Alumno alumno;
	
	private Curso curso;
	
	private Date fechaInscripcion;

	public Inscripcion(Alumno alumno, Curso curso) {
		this.alumno = alumno;
		this.curso = curso;
		this.fechaInscripcion = new Date();
	}

	@Override
	public String toString() {
		return "Inscripcion [alumno=" + alumno + ", curso=" + curso + ", fechaInscripcion=" + fechaInscripcion + "]";
	}
	
	
	
	
	
	

}
