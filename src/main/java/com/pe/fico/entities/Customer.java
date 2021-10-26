package com.pe.fico.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdCustomer;
	
	@Column(name = "photoCustomer", nullable = false)
	private String photoCustomer;
	
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre no puede contener caracteres especiales")
	@Pattern(regexp = "[^0-9]+", message = "El nombre no puede contener un número")
	@Column(name = "nameCustomer", length = 45, nullable = false)
	private String nameCustomer;
	
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El numero de DNI no puede contener caracteres especiales")
	@Pattern(regexp = "[^A-Z]+", message = "El numero de DNI no puede contener letras")
	@Pattern(regexp = "[^a-z]+", message = "El numero de DNI no puede contener letras")
	@Column(name = "dniCustomer", length = 45, nullable = false)
	private String dniCustomer;
	
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "La edad no puede contener caracteres especiales")
	@Pattern(regexp = "[^A-Z]+", message = "La edad no puede contener letras")
	@Pattern(regexp = "[^a-z]+", message = "La edad no puede contener letras")
	@Column(name = "ageCustomer", length = 45, nullable = false)
	private String ageCustomer;
	
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre del producto no puede contener caracteres especiales")
	@Pattern(regexp = "[^0-9]+", message = "El nombre del producto no puede contener un número")
	@Column(name = "cityCustomer", length = 45, nullable = false)
	private String cityCustomer;
	
	@ManyToOne
	@JoinColumn(name = "idRol", nullable = false)
	private Rol rol;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int idCustomer, String photoCustomer, String nameCustomer, String dniCustomer, String ageCustomer,
			String cityCustomer, Rol rol) {
		super();
		IdCustomer = idCustomer;
		this.photoCustomer = photoCustomer;
		this.nameCustomer = nameCustomer;
		this.dniCustomer = dniCustomer;
		this.ageCustomer = ageCustomer;
		this.cityCustomer = cityCustomer;
		this.rol = rol;
	}

	public int getIdCustomer() {
		return IdCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		IdCustomer = idCustomer;
	}

	public String getPhotoCustomer() {
		return photoCustomer;
	}

	public void setPhotoCustomer(String photoCustomer) {
		this.photoCustomer = photoCustomer;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getDniCustomer() {
		return dniCustomer;
	}

	public void setDniCustomer(String dniCustomer) {
		this.dniCustomer = dniCustomer;
	}

	public String getAgeCustomer() {
		return ageCustomer;
	}

	public void setAgeCustomer(String ageCustomer) {
		this.ageCustomer = ageCustomer;
	}

	public String getCityCustomer() {
		return cityCustomer;
	}

	public void setCityCustomer(String cityCustomer) {
		this.cityCustomer = cityCustomer;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
}
