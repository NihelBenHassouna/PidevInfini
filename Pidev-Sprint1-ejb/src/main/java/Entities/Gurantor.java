package Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Gurantor")
public class Gurantor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id") 
	private int  id;
	@Column(name="cin")
	private int cin;
	@Column(name="job")
	private String job;
	public int getCin() {
		return cin;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	@Column(name="FirstName")
	private String FirstName;
	@Column(name="LastName")
	private String LastName;
	@Column(name="Email")
	private String Email;
	@Column(name="PhoneNumber")
	private String phoneNumber;
	@Column(name="Salary")
	private float Salary;
	@Column(name="Gender")
	private String Gender;
	@Column(name="Gurantor_HomeAdress")
	private String HomeAdress;
	@Column(name="Gurantor_WorkAdress")
	private String WorkAdress;

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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public float getSalary() {
		return Salary;
	}
	public void setSalary(float salary) {
		Salary = salary;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getHomeAdress() {
		return HomeAdress;
	}
	public void setHomeAdress(String homeAdress) {
		HomeAdress = homeAdress;
	}
	public String getWorkAdress() {
		return WorkAdress;
	}
	public void setWorkAdress(String workAdress) {
		WorkAdress = workAdress;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Gurantor(String firstName, String lastName, String email, String phoneNumber, float salary, String gender,
			String homeAdress, String workAdress) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		this.phoneNumber = phoneNumber;
		Salary = salary;
		Gender = gender;
		HomeAdress = homeAdress;
		WorkAdress = workAdress;
	}
	public Gurantor() {
		super();
	}
	@Override
	public String toString() {
		return "Gurantor [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email
				+ ", phoneNumber=" + phoneNumber + ", Salary=" + Salary + ", Gender=" + Gender + ", HomeAdress="
				+ HomeAdress + ", WorkAdress=" + WorkAdress + "]";
	}

	
	
}
