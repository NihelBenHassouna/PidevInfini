package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	    name="UserType"
	
	    )
public abstract class  User implements Serializable {
  
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="User_ID") 
	protected int  id;
	@Column(name="User_Cin")
	protected String Cin;
	@Column(name="FirstName")
	protected String FirstName;
	@Column(name="LastName")
	protected String LastName;
	@Column(name="User_Email")
	protected String Email;
	@Column(name="User_Phone")
	protected String phone;
	@Column(name="User_Salary")
	protected Double Salary;
	@Column(name="User_Gender")
	protected String Gender;
	@Column(name="User_Login")
	protected String Login;
	@Column(name="User_Password")
	protected String Password;
	@Column(name="User_ConfirmedPassword")
	protected String ConfirmedPassword;
	@Column(name="User_HomeAdress")
	protected String HomeAdress;
	@Column(name="User_WorkAdress")
	protected String WorkAdress;
	@Column(name="User_Image")
	protected String url_image;
	@Column(name="User_Signature")
	protected String Signature;
	@Column(name="Birth_Date")
	protected Date BirthDate ;
	@Column(name="Professional_Category")
	private String Professional_Category;
	@Column(name="employer")
	private String employer;
	@Column(name="Position")
	private String Position;
	@Column(name="User_Job")
	private String Job;
	@Column(name="User_MaritalStatus")
	private String MaritalStatus;
	@Column(name="User_KidsNumber")
	private int KidsNumber;
	@Column(name="User_ActivityArea")
	private String ActivityArea;
	@Column(name="RcRegister")
	private Date RcRegister;
	@Column(name="User_Nationality")
	private String Nationality;
	@Column(name="Hiring_Date")
	protected Date HiringDate ;
	@Column(name="Discharge_Date")
	protected Date DischargeDate ;
	
	@ManyToOne
	private Agency agency;
	@OneToMany(mappedBy="user", cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	private List<BankAccount> accounts = new ArrayList<>();
	/*@OneToMany(mappedBy="user")
	private List<Claim> claims = new ArrayList<>();*/
	
	public User() {
		super();
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCin() {
		return Cin;
	}

	public void setCin(String cin) {
		Cin = cin;
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getConfirmedPassword() {
		return ConfirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		ConfirmedPassword = confirmedPassword;
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

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	public String getSignature() {
		return Signature;
	}

	public void setSignature(String signature) {
		Signature = signature;
	}

	public Date getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}

	public String getProfessional_Category() {
		return Professional_Category;
	}

	public void setProfessional_Category(String professional_Category) {
		Professional_Category = professional_Category;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public String getJob() {
		return Job;
	}

	public void setJob(String job) {
		Job = job;
	}

	public String getMaritalStatus() {
		return MaritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}

	public int getKidsNumber() {
		return KidsNumber;
	}

	public void setKidsNumber(int kidsNumber) {
		KidsNumber = kidsNumber;
	}

	public String getActivityArea() {
		return ActivityArea;
	}

	public void setActivityArea(String activityArea) {
		ActivityArea = activityArea;
	}

	public Date getRcRegister() {
		return RcRegister;
	}

	public void setRcRegister(Date rcRegister) {
		RcRegister = rcRegister;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public Date getHiringDate() {
		return HiringDate;
	}

	public void setHiringDate(Date hiringDate) {
		HiringDate = hiringDate;
	}

	public Date getDischargeDate() {
		return DischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		DischargeDate = dischargeDate;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	/*public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}*/


	@Override
	public String toString() {
		return "User [id=" + id + ", Cin=" + Cin + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email="
				+ Email + ", phone=" + phone + ", Salary=" + Salary + ", Gender=" + Gender + ", Login=" + Login
				+ ", Password=" + Password + ", ConfirmedPassword=" + ConfirmedPassword + ", HomeAdress=" + HomeAdress
				+ ", WorkAdress=" + WorkAdress + ", url_image=" + url_image + ", Signature=" + Signature
				+ ", BirthDate=" + BirthDate + ", Professional_Category=" + Professional_Category + ", employer="
				+ employer + ", Position=" + Position + ", Job=" + Job + ", MaritalStatus=" + MaritalStatus
				+ ", KidsNumber=" + KidsNumber + ", ActivityArea=" + ActivityArea + ", RcRegister=" + RcRegister
				+ ", Nationality=" + Nationality + ", HiringDate=" + HiringDate + ", DischargeDate=" + DischargeDate
				+ ", agency=" + agency + ", accounts=" + accounts + "]";
	}
	
}
