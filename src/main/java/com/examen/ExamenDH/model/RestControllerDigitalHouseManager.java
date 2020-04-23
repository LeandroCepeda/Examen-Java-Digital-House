package com.examen.ExamenDH.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/crearCurso")
	public ResponseEntity crearCurso(@RequestBody Curso curso) {
		try {
			digitalHouseManager.altaCurso(curso.getNombre(), curso.getCodigoCurso(), curso.getCupoMaximoAlumnos());
			return ResponseEntity.status(HttpStatus.OK).body("Curso creado con exito");
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error.\"}");
						
		}
	}
	
	/**
	 * En este metodo armaría le pasaría un objeto JSON con la información del codigo del curso, y los codigos de ambos profesores
	 * o pasaría directamente los 3 objetos, en el caso que en el futuro se modifiquen las reglas de negocio.
	 * Luego definiría correctamente un Servicio, que trate esa información y le pase unicamente la info necesaria
	 * al manager en este caso.
	 * @param object
	 * @return
	 */
	@PostMapping("/asignarProfesor")
	public ResponseEntity asignarProfesor(@RequestBody Object object) {
		try {
			digitalHouseManager.asignarProfesores(codigoCurso, codigoProfesorTitular, codigoProfesorAdjunto);
			return ResponseEntity.status(HttpStatus.OK).body("Curso creado con exito");
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error.\"}");
						
		}
	}
	
	
	@PostMapping("/altaAlumno")
	public ResponseEntity altaAlumno(@RequestBody Alumno alumno) {
		try {
			digitalHouseManager.altaAlumno(alumno.getNombre(), alumno.getApellido(), alumno.getCodigoAlumno());
			return ResponseEntity.status(HttpStatus.OK).body("Alumno dado de alta con exito");
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error.\"}");
						
		}
	}
	
	/**
	 * Mismo caso que el metodo asignarProfesor(), armaría un JSON que contenga ambos objetos, 
	 * y el servicio sería el encargado de obtener la info necesaria de esos objetos y pasarle la 
	 * misma al manager.
	 * @param alumno
	 * @param curso
	 * @return
	 */
	@PostMapping("/inscribirAlumno")
	public ResponseEntity inscribirAlumno(@RequestBody Alumno alumno, @RequestBody Curso curso) {
		try {
			digitalHouseManager.inscribirAlumno(alumno.getCodigoAlumno(), curso.getCodigoCurso());
			return ResponseEntity.status(HttpStatus.OK).body("Alumno dado de alta con exito");
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error.\"}");			
		}
	}
	
	@PostMapping("/bajaProfesor")
	public ResponseEntity bajaProfesor(@RequestBody Profesor profesor) {
		try {
			digitalHouseManager.bajaProfesor(profesor.getCodigoProfesor());
			return ResponseEntity.status(HttpStatus.OK).body("Profesor dado de baja con exito");
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error.\"}");			
		}
	}
	
	@GetMapping("/{nombre}")
	public ResponseEntity detalleAlumno(@PathVariable String nombre) {
		try {
			Alumno alumnoSolicitado = null;
			for (Alumno alumno : digitalHouseManager.getAlumnos()) {
				if(alumno.getNombre() == nombre) {
					alumnoSolicitado = alumno;
				}
			}
			return ResponseEntity.status(HttpStatus.OK).body(alumnoSolicitado);
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error.\"}");			
		}
	}
	
	@GetMapping("/actualizarAlumno")
	public ResponseEntity actualizarAlumno(@RequestBody Alumno alumno) {
		try {
			Alumno alumnoModificado = digitalHouseManager.actualizaAlumno(alumno);
			return ResponseEntity.status(HttpStatus.OK).body(alumnoModificado);
			}
			
		catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error.\"}");			
		}
	}
	
	
	//PARTE K
	/*Para que un alumno pueda consultar a que cursos esta inscripto, agregaría una relación de Alumnos a Cursos.
	 * Es decir agregaría como atributo de la clase Alumno, una List<Curso> que indica los cursos a los cuales
	 * está inscripto*/
	
	
	
	
	
	
	
	
	
	
	

}