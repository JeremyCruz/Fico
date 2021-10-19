package pe.com.fico.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "Users")
public class User implements Serializable {

	private static final long serialVersionUID =1L;
	
	@Id
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@MapsId
	@JoinColumn(name ="id", nullable=true)
	private Customer customer;
	

	@Column(name = "nameUser", length =30, nullable=false )
	private String nameUser;
	
	@Column(name = "paswordUser", length =80, nullable=false )
	private String paswordUser;
		
	@Column(name = "stateUser", length =1, nullable=false )
	private String state;

	public int getIdUserCenter() {
		return id;
	}

	public void setIdUserCenter(int idUserCenter) {
		this.id = idUserCenter;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPaswordUser() {
		return paswordUser;
	}

	public void setPaswordUser(String paswordUser) {
		this.paswordUser = paswordUser;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
		
}