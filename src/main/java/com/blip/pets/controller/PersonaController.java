package com.blip.pets.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blip.pets.model.Persona;
import com.blip.pets.service.PersonaService;

@RestController
@RequestMapping("api/persona")
public class PersonaController {

	
	@Autowired
	PersonaService service;
	
	
	@PostMapping("/create")
	public ResponseEntity<Persona> create(@RequestBody Persona p) {

		try {
			Persona entity = service
					.create(new Persona(0,p.getNombre(), p.getSexo(), p.getCorreo(), p.getTelefono(),p.getDomicilio()));

			return new ResponseEntity<>(entity, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/retrieve")
	private ResponseEntity<List<Persona>> getAll() {
		try {
			List<Persona> personas = new ArrayList<Persona>();

			personas = service.getAll();

			if (personas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(personas, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PutMapping("/update")
	public ResponseEntity<Persona> updateProfesor(@RequestBody Persona p) {

		try {
			Persona entity = service.update(p);
			if (entity == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(entity, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Persona> delete(@PathVariable("id") Integer id) {

		try {
			if(service.delete(id)) {
				//Deleted
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
}
