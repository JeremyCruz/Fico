package com.pe.fico.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Rol")
public class Rol{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;

	@Pattern	(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre del Rol no puede contener un caracter especial")
	@Pattern	(regexp = "[^0-9]+", message = "El nombre del Rol no puede contener un número")
	@Column(name = "typeRol", length = 45, nullable = false)
	private String typeRol;

	public Rol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rol(int idRol, String typeRol) {
		super();
		this.idRol = idRol;
		this.typeRol = typeRol;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getTypeRol() {
		return typeRol;
	}

	public void setTypeRol(String typeRol) {
		this.typeRol = typeRol;
	}

}