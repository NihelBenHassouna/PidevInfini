package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Agency")
public class Agency implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="Agency_ID") 
	private int  id;
	@Column(name="Agency_Adress")
	private String adress;
	@Column(name="Agency_Email")
	private String email;
	@Column(name="Agency_phone")
	private String phone;
	@Column(name="Agency_Name")
	private String name;
	@Column(name="Creation_Date")
	private Date Creation ;
	@Column(name="Information")
	private String Information ;
	@ManyToOne
	private Admin admin;
	@OneToMany(mappedBy="agency", cascade = {CascadeType.ALL})
	private List<User> users = new ArrayList<>();
	public Admin getAdmin() {
		return admin;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreation() {
		return Creation;
	}
	public void setCreation(Date creation) {
		Creation = creation;
	}
	public Agency(String adress, String email, String phone, String name, Date creation, String information) {
		this.adress = adress;
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.Creation = creation;
		this.Information = information;
	}
	public String getInformation() {
		return Information;
	}
	public void setInformation(String information) {
		Information = information;
	}
	public Agency() {
		super();
	}
	@Override
	public String toString() {
		return "Agency [id=" + id + ", adress=" + adress + ", email=" + email + ", phone=" + phone + ", name=" + name
				+ ", Creation=" + Creation + ", Information=" + Information + "]";
	}
	
	public void addAUser(User user){
		user.setAgency(this);
		this.users.add(user);
	}


	

}
