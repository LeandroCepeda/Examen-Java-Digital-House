package com.examen.ExamenDH.model;

public class ProfesorAdjunto extends Profesor {
	
	private Integer cantidadHorasConsulta;
	
	public ProfesorAdjunto(String nombre, String apellido, Integer codigoProfesor, Integer cantidadDeHorasConsulta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.codigoProfesor = codigoProfesor;
		this.cantidadHorasConsulta = cantidadDeHorasConsulta;
		this.antiguedad = 0;
	}

	public Integer getCantidadHorasConsulta() {
		return cantidadHorasConsulta;
	}

	public void setCantidadHorasConsulta(Integer cantidadHorasConsulta) {
		this.cantidadHorasConsulta = cantidadHorasConsulta;
	}
	
	

	
}
