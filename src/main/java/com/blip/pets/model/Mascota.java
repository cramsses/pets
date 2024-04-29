package com.blip.pets.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mascota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private Integer edad;
	private String sexo;
	private Float peso;
	
	@ManyToOne
	@JoinColumn(name="ESPECIE_FK")
	private Especie especie;

	@ManyToOne
	@JoinColumn(name="PERSONA_FK")
	private Persona persona;

	
	

}
