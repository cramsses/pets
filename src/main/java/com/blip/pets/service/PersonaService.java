package com.blip.pets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blip.pets.dao.PersonaDAO;
import com.blip.pets.model.Persona;

@Service
public class PersonaService {
	
	@Autowired
	private PersonaDAO dao;

	
	//CREATE
	public Persona create(Persona entity) {
		return dao.save(entity);
	}
	
	//RETRIEVE
	public List<Persona> getAll(){
		return dao.findAll();
	}
	
	
	//UPDATE
	public Persona update(Persona entity) {
		//FIND
		Optional<Persona> existingEntity = dao.findById(entity.getId());
		
		if(existingEntity.isPresent()) {
			return dao.save(entity);
		}else {
			return null;
		}
	}
		
	//DELETE
	public boolean delete(Integer id) {
		boolean deleted=false;
		try {
			dao.deleteById(id);
			deleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleted;
		
	}
	
	
	
}
