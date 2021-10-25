package com.pe.fico.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Institution")
public class Institution {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInstitution;
	
	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre del producto no puede contener simbolos")
	@Pattern(regexp = "[^0-9]+", message = "El nombre del producto no puede contener un número")
	@Column(name = "nameInstitution", length = 40, nullable = false)
	private String nameInstitution;

	@Pattern(regexp = "[^!\"#$%&'()*+,-./:;<=>?@^_`{|}~]+", message = "El nombre del producto no puede contener simbolos")
	@Pattern(regexp = "[^0-9]+", message = "El nombre del producto no puede contener un número")
	@Column(name = "typeInstitution", length = 40, nullable = false)
	private String typeInstitution;
	
	@Pattern(regexp = "[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)", message = "Formato url sin http://")
	@Column(name = "urlInstitution", length = 30, nullable = false)
	private String urlInstitution;
	

	public Institution() {
		super();
	}

	public Institution(int CInstitution, String DInstitution, String DTypeInstitution, String DUrlInstitution) {
		super();
		this.idInstitution = CInstitution;
		this.nameInstitution = DInstitution;
		this.typeInstitution = DTypeInstitution;
		this.urlInstitution = DUrlInstitution;
	}

	public int getCInstitution() {
		return idInstitution;
	}

	public void setCInstitution(int cInstitution) {
		idInstitution = cInstitution;
	}

	public String getDInstitution() {
		return nameInstitution;
	}

	public void setDInstitution(String dInstitution) {
		nameInstitution = dInstitution;
	}

	public String getDTypeInstitution() {
		return typeInstitution;
	}

	public void setDTypeInstitution(String dTypeInstitution) {
		typeInstitution = dTypeInstitution;
	}

	public String getDUrlInstitution() {
		return urlInstitution;
	}

	public void setDUrlInstitution(String dUrlInstitution) {
		urlInstitution = dUrlInstitution;
	}
}
