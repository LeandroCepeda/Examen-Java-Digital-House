package com.examen.ExamenDH.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DigitalHouseManager {
	
	private List<Alumno> alumnos = new ArrayList<>();
	
	private List<Profesor> profesores = new ArrayList<>();
	
	private List<Curso> cursos = new ArrayList<>();
	
	private List<Inscripcion> inscripciones = new ArrayList<>();

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}
	
	
	public void altaCurso(String nombre, Integer codigoCurso, Integer cupoMaximoDeAlumnos) {
		Curso curso = new Curso(nombre, codigoCurso, cupoMaximoDeAlumnos);
		this.getCursos().add(curso);
	}
	
	
	public void bajaCurso(Integer codigoCurso) {
		for (Curso curso : cursos) {
			if(curso.getCodigoCurso() == codigoCurso) {
				this.getCursos().remove(curso);
			}
		}
	}
	
	
	public void altaProfesorAdjunto(String nombre, String apellido, Integer codigoProfesor, Integer cantidadDeHoras) {
		ProfesorAdjunto profesorAdjunto = new ProfesorAdjunto(nombre, apellido, codigoProfesor, cantidadDeHoras);
		this.getProfesores().add(profesorAdjunto);	
	}
	
	public void altaProfesorTitular(String nombre, String apellido, Integer codigoProfesor, String especialidad) {
		ProfesorTitular profesorTitular = new ProfesorTitular(nombre, apellido, codigoProfesor, especialidad);
		this.getProfesores().add(profesorTitular);
	}
	
	public void bajaProfesor(Integer codigoProfesor) {
		for (Profesor profesor : profesores) {
			if(profesor.getCodigoProfesor() == codigoProfesor) {
				this.getProfesores().remove(profesor);
			}
		}
	}
	
	public void altaAlumno(String nombre, String apellido, Integer codigoAlumno) {
		Alumno alumno = new Alumno(nombre, apellido, codigoAlumno);
		this.getAlumnos().add(alumno);
	}
	
	
	public void inscribirAlumno(Integer codigoAlumno, Integer codigoCurso) {
		Curso cursoAInscribir = null;
		Alumno alumnoAInscribir = null;
		
		for (Curso curso : cursos) {
			if(curso.getCodigoCurso() == codigoCurso) {
				cursoAInscribir = curso;
			}
		}
		
		for (Alumno alumno : alumnos) {
			if(alumno.getCodigoAlumno() == codigoAlumno) {
				alumnoAInscribir = alumno;
			}
		}
		
		if(cursoAInscribir.agregarUnAlumno(alumnoAInscribir)) {
			Inscripcion inscripcion = new Inscripcion(alumnoAInscribir, cursoAInscribir);
			this.getInscripciones().add(inscripcion);
			System.out.println(inscripcion.toString());
		}else {
			System.out.println("No se ha podido inscribir porque no hay cupos para el curso solicitado");
			
		}
	}
	
	public void asignarProfesores(Integer codigoCurso, Integer codigoProfesorTitular, Integer codigoProfesorAdjunto) {
		Curso curso = null;
		
		for (Curso c : cursos) {
			if(curso.getCodigoCurso() == codigoCurso) {
				curso = c;
			}
		}
				
		if(curso == null) {
			System.out.println("El curso no existe");
		}else {
			for (Profesor profesor : profesores) {
				if(profesor.getCodigoProfesor() == codigoProfesorTitular) {
					curso.setProfesorTitular((ProfesorTitular) profesor);
				}
				if(profesor.getCodigoProfesor() == codigoProfesorAdjunto) {
					curso.setProfesorAdjunto((ProfesorAdjunto) profesor);
				}
			}	
		}
		
		
		
		
		
	}
	
	
	
	

}
