package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "UserType"

		)
public abstract class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_ID")
	protected int id;
	@Column(name = "UserType",insertable=false,updatable=false)
	protected String UserType;
	@Column(name = "User_Cin")
	protected String Cin;
	@Column(name = "FirstName")
	protected String FirstName;
	@Column(name = "LastName")
	protected String LastName;
	@Column(name = "User_Email")
	protected String Email;
	@Column(name = "User_Phone")
	protected String phone;
	@Column(name = "User_Salary")
	protected Double Salary;
	@Column(name = "Hiring_Date")
	protected Date HiringDate;
	@Column(name = "User_title")
	protected String Title;
	@Column(name = "User_Login")
	protected String Login;
	@Column(name = "User_Password")
	protected String Password;
	@Column(name = "User_ConfirmedPassword")
	protected String ConfirmedPassword;
	@Column(name = "User_HomeAdress")
	protected String HomeAdress;
	@Column(name = "User_WorkAdress")
	protected String WorkAdress;
	@Column(name = "User_Image")
	protected String url_image;
	@Column(name = "User_Signature")
	protected String Signature;
	@Column(name = "Birth_Date")
	protected Date BirthDate;
	@Column(name = "User_MaritalStatus")
	private String MaritalStatus;
	@Column(name = "User_KidsNumber")
	private Integer KidsNumber;
	@Column(name = "User_Seniority")
	private Integer Seniority;
	@Column(name = "User_job")
	private String job;
	@Column(name = "User_employer")
	private String employer;
	@Column(name = "User_professionCategory")
	private String professionCategory;
	@Column(name = "User_CampanyName")
	private String CampanyName;
	@Column(name = "User_Position")
	private String Position;
	@Column(name="blocked")
	private boolean blocked;
	
	public boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	@ManyToOne
	private Agency agency;
	@OneToMany(mappedBy = "user", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<BankAccount> accounts = new ArrayList<>();
	@OneToMany(mappedBy ="user1")
	private List<RealEstateRequest>requests=new ArrayList<>();
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getProfessionCategory() {
		return professionCategory;
	}

	public void setProfessionCategory(String professionCategory) {
		this.professionCategory = professionCategory;
	}

	public Integer getKidsNumber() {
		return KidsNumber;
	}

	public void setKidsNumber(Integer kidsNumber) {
		KidsNumber = kidsNumber;
	}

	public Integer getSeniority() {
		return Seniority;
	}

	public void setSeniority(Integer seniority) {
		Seniority = seniority;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
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

	public Date getHiringDate() {
		return HiringDate;
	}

	public void setHiringDate(Date hiringDate) {
		HiringDate = hiringDate;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
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

	public String getMaritalStatus() {
		return MaritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}


	public String getCampanyName() {
		return CampanyName;
	}

	public void setCampanyName(String campanyName) {
		CampanyName = campanyName;
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




	public List<RealEstateRequest> getRequests() {
		return requests;
	}

	public void setRequests(List<RealEstateRequest> requests) {
		this.requests = requests;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", UserType=" + UserType + ", Cin=" + Cin + ", FirstName=" + FirstName + ", LastName="
				+ LastName + ", Email=" + Email + ", phone=" + phone + ", Salary=" + Salary + ", HiringDate="
				+ HiringDate + ", Title=" + Title + ", Login=" + Login + ", Password=" + Password
				+ ", ConfirmedPassword=" + ConfirmedPassword + ", HomeAdress=" + HomeAdress + ", WorkAdress="
				+ WorkAdress + ", url_image=" + url_image + ", Signature=" + Signature + ", BirthDate=" + BirthDate
				+ ", MaritalStatus=" + MaritalStatus + ", KidsNumber=" + KidsNumber + ", Seniority=" + Seniority
				+ ", job=" + job + ", employer=" + employer + ", professionCategory=" + professionCategory
				+ ", CampanyName=" + CampanyName + ", Position=" + Position + ", agency=" + agency + "]";
	}















}
