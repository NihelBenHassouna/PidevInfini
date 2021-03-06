package Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Agent")
@DiscriminatorValue(value="Agent")
public class Agent extends User {
	private static final long serialVersionUID = 1L;

	@Column(name="Bonus")
	private Double Bonus ;
	@OneToMany(mappedBy="agent")
	private List<Appointement> appoints;
	@OneToMany(mappedBy="agent1")
	private List<Claim> claims;



	public List<Claim> getClaims() {
		return claims;
	}
	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}
	
public List<Appointement> getAppoints() {
		return appoints;
	}
	public void setAppoints(List<Appointement> appoints) {
		this.appoints = appoints;
	}

	public Double getBonus() {
		return Bonus;
	}
	public void setBonus(Double bonus) {
		Bonus = bonus;
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

	



	public Agent() {
		super();
	}
	public Agent(Double bonus) {
		super();
		Bonus = bonus;
	}
	


}
