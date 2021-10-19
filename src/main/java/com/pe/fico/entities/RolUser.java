package pe.com.fico.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//ORM mapeo relacion de objetos a traves de anotaciones
@Entity
@Table(name = "RolUser")
public class RolUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRolUser;

	@Column(name = "nameRolUser", length = 45, nullable = false)
	private String nameRolUser;

	// contrs-sin parametros
	public RolUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	// contrs-con parametros
	public RolUser(int idRolUser, String nameRolUser) {
		super();
		this.idRolUser = idRolUser;
		this.nameRolUser = nameRolUser;
	}

	// get and sett
	public int getIdRolUser() {
		return idRolUser;
	}

	public void setIdRolUser(int idRolUser) {
		this.idRolUser = idRolUser;
	}

	public String getNameRolUser() {
		return nameRolUser;
	}

	public void setNameRolUser(String nameRolUser) {
		this.nameRolUser = nameRolUser;
	}
	
}