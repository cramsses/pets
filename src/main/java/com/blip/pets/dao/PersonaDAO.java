package com.blip.pets.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blip.pets.model.Persona;

public interface PersonaDAO extends JpaRepository<Persona, Integer> {

}
