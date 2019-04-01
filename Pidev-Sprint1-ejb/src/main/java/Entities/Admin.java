package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id") 
	private int  id;
	@Column(name="First_Name") 
	private String FirstName;
	@Column(name="Last_Name") 
	private String LastName;
	@Column(name="Admin_Login")
	private String login;
	@Column(name="Admin_Password")
	protected String password;
	@OneToMany(mappedBy="admin", cascade = {CascadeType.ALL})
	private List<Agency> agencies = new ArrayList<>();
	public Admin() {
		
	}
	public List<Agency> getAgencies() {
		return agencies;
	}
	public void setAgencies(List<Agency> agencies) {
		this.agencies = agencies;
	}


	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Login=" + login
				+ ", Password=" + password ;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	
	
}
