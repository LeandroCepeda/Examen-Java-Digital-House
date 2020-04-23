package com.examen.ExamenDH.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerDigitalHouseManager {

	@Autowired
	private DigitalHouseManager digitalHouseManager;
	
	
	@PostMapping("/crearTitular")
	public ResponseEntity crearTitular(@RequestBody ProfesorTitular profesorTitular) {
		try {
			digitalHouseManager.altaProfesorTitular(profesorTitular.getNombre(), profesorTitular.getApellido(),profesorTitular.getCodigoProfesor(), profesorTitular.getEspecialidad());
			return ResponseEntity.status(HttpStatus.OK).body("Titular creado con exito");
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error.\"}");
						
		}
	
	}
	
	@PostMapping("/crearAdjunto")
	public ResponseEntity crearAdjunto(@RequestBody ProfesorAdjunto profesorAdjunto) {
		try {
			digitalHouseManager.altaProfesorAdjunto(profesorAdjunto.getNombre(), profesorAdjunto.getApellido(), profesorAdjunto.getCodigoProfesor(), profesorAdjunto.getCantidadHorasConsulta());
			return ResponseEntity.status(HttpStatus.OK).body("Adjunto creado con exito");
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error.\"}");
						
		}
	
	}
	
	

}