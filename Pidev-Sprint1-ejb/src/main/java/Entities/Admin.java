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
	protected String Login;
	@Column(name="Admin_Password")
	protected String Password;
	@OneToMany(mappedBy="admin", cascade = {CascadeType.ALL})
	private List<Agency> agencies = new ArrayList<>();
	public Admin() {
		super();
	}
	public List<Agency> getAgencies() {
		return agencies;
	}
	public void setAgencies(List<Agency> agencies) {
		this.agencies = agencies;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", agencies=" + agencies
				+ "]";
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
	public Admin(String firstName, String lastName) {
		super();
		FirstName = firstName;
		LastName = lastName;
	}
	
	public void addAgency(Agency agency){
		agency.setAdmin(this);
		this.agencies.add(agency);
	}
}
