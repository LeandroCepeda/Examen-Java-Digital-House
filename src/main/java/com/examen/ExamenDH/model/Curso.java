package com.examen.ExamenDH.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	
	private String nombre;
	
	private Integer codigoCurso;
	
	private ProfesorTitular profesorTitular;
	
	private ProfesorAdjunto profesorAdjunto;
	
	private Integer cupoMaximoAlumnos;
	
	private List<Alumno> alumnosInscriptos = new ArrayList<>();
	
	
	public Curso() {
		
	}
	

	public Curso(String nombre, Integer codigoCurso, Integer cupoMaximoAlumnos) {
		this.nombre = nombre;
		this.codigoCurso = codigoCurso;
		this.cupoMaximoAlumnos = cupoMaximoAlumnos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(Integer codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	
	public boolean equals(Curso curso) {
		return this.getCodigoCurso() == curso.getCodigoCurso();
	}

	public ProfesorTitular getProfesorTitular() {
		return profesorTitular;
	}

	public void setProfesorTitular(ProfesorTitular profesorTitular) {
		this.profesorTitular = profesorTitular;
	}

	public ProfesorAdjunto getProfesorAdjunto() {
		return profesorAdjunto;
	}

	public void setProfesorAdjunto(ProfesorAdjunto profesorAdjunto) {
		this.profesorAdjunto = profesorAdjunto;
	}

	public Integer getCupoMaximoAlumnos() {
		return cupoMaximoAlumnos;
	}

	public void setCupoMaximoAlumnos(Integer cupoMaximoAlumnos) {
		this.cupoMaximoAlumnos = cupoMaximoAlumnos;
	}

	public List<Alumno> getAlumnosInscriptos() {
		return alumnosInscriptos;
	}

	public void setAlumnosInscriptos(List<Alumno> alumnosInscriptos) {
		this.alumnosInscriptos = alumnosInscriptos;
	}
	
	public boolean agregarUnAlumno(Alumno unAlumno) {
		if(this.getCupoMaximoAlumnos() > this.getAlumnosInscriptos().size()) {
			this.getAlumnosInscriptos().add(unAlumno);
			return true;
		}else {
			return false;
		}
	}
	
	public void eliminarAlumno(Alumno unAlumno) {
		this.getAlumnosInscriptos().remove(unAlumno);
	}
	
	

}
