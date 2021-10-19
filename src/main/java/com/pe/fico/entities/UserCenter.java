package pe.com.fico.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "UserCenter")
public class UserCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUserCenter;
	
	@Column(name = "nameUserCenter", length =45, nullable=false )
	private String nameUserCenter;
	
	@Column(name = "adressUserCenter", length =45, nullable=false )
	private String adressUserCenter;
	
	@Column(name = "emailUserCenter", length =45, nullable=false )
	private String emailUserCenter;
	
	@Column(name = "dniUserCenter", length =8, nullable=false )
	private int dniUserCenter;
	
	@Column(name = "edadUserCenter", length =2, nullable=false )
	private int edadUserCenter;
	
	@Column(name = "ciudadUserCenter", length =45, nullable=true )
	private String ciudadUserCenter;
	
	@Column(name = "espUserCenter", length =8, nullable=true )
	private String espUserCenter;
	
	@Column(name = "salarioUserCenter", length =5, nullable=true )
	private int salarioUserCenter;
	
	@Column(name = "ptsUserCenter", length =1 , nullable=true )
	private int ptsUserCenter;
	
	@ManyToOne
	@JoinColumn(name = "idRolUser", nullable= false)
	private RolUser rolUser;
	
	
	
	
	// constructor
	public UserCenter() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructor con parámetros
	public UserCenter(int idUserCenter, String nameUserCenter, String adressUserCenter, String emailUserCenter, int dniUserCenter, int edadUserCenter,
			String ciudadUserCenter, String espUserCenter, int salarioUserCenter,   RolUser rolUser) {
		super();
		this.idUserCenter = idUserCenter;
		this.nameUserCenter = nameUserCenter;
		this.adressUserCenter = adressUserCenter;
		this.emailUserCenter = emailUserCenter;
		this.dniUserCenter = dniUserCenter;
		this.edadUserCenter = edadUserCenter;
		this.ciudadUserCenter = ciudadUserCenter;
		this.espUserCenter = espUserCenter;
		this.salarioUserCenter = salarioUserCenter;
		this.ptsUserCenter = 5;
		this.rolUser = rolUser;
		
	}

	
	// getters and setters
	public int getIdUserCenter() {
		return idUserCenter;
	}

	public void setIdUserCenter(int idUserCenter) {
		this.idUserCenter = idUserCenter;
	}

	public String getNameUserCenter() {
		return nameUserCenter;
	}

	public void setNameUserCenter(String nameUserCenter) {
		this.nameUserCenter = nameUserCenter;
	}

	public String getAdressUserCenter() {
		return adressUserCenter;
	}

	public void setAdressUserCenter(String adressUserCenter) {
		this.adressUserCenter = adressUserCenter;
	}

	public String getEmailUserCenter() {
		return emailUserCenter;
	}

	public void setEmailUserCenter(String emailUserCenter) {
		this.emailUserCenter = emailUserCenter;
	}

	public int getDniUserCenter() {
		return dniUserCenter;
	}

	public void setDniUserCenter(int dniUserCenter) {
		this.dniUserCenter = dniUserCenter;
	}

	public int getEdadUserCenter() {
		return edadUserCenter;
	}

	public void setEdadUserCenter(int edadUserCenter) {
		this.edadUserCenter = edadUserCenter;
	}

	public String getCiudadUserCenter() {
		return ciudadUserCenter;
	}

	public void setCiudadUserCenter(String ciudadUserCenter) {
		this.ciudadUserCenter = ciudadUserCenter;
	}

	public String getEspUserCenter() {
		return espUserCenter;
	}

	public void setEspUserCenter(String espUserCenter) {
		this.espUserCenter = espUserCenter;
	}

	public int getSalarioUserCenter() {
		return salarioUserCenter;
	}

	public void setSalarioUserCenter(int salarioUserCenter) {
		this.salarioUserCenter = salarioUserCenter;
	}

	public int getPtsUserCenter() {
		return ptsUserCenter;
	}

	public void setPtsUserCenter(int ptsUserCenter) {
		this.ptsUserCenter = ptsUserCenter;
	}

	public RolUser getRolUser() {
		return rolUser;
	}

	public void setRolUser(RolUser rolUser) {
		this.rolUser = rolUser;
	}
	
}