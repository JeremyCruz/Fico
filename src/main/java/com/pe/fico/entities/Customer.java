package pe.com.fico.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClient;

	@Column(name = "nameClient", length = 80, nullable = false)
	private String name;

	@Column(name = "dniClient", length = 8, nullable = false)
	private String dni;
	
	@Column(name = "ageClient", nullable = false)
	private int ageClient;

	@Column(name = "cityClient", length = 40, nullable = false)
	private String cityClient;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
	private User user;

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient= idClient;
	}

	public int getAgeClient() {
		return ageClient;
	}

	public void setAgeClient(int ageClient) {
		this.ageClient = ageClient;
	}

	public String getCityClient() {
		return cityClient;
	}

	public void setCityClient(String cityClient) {
		this.cityClient = cityClient;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	

}
