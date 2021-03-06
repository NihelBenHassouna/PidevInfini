package Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
@DiscriminatorValue(value="Customer")
public class Customer extends User{

	private static final long serialVersionUID = 1L;

	
	@Column(name="typeOfCredit")
	private String typeOfCredit;
	
	@OneToMany(mappedBy="customer")
	private List<Appointement> appoints;
	@OneToMany(mappedBy="customer1")
	private List<Claim> claims;
	@OneToMany(mappedBy="customer2")
	private List<Rate> rates;
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

	public Customer() {
		super();
	}
	public String getTypeOfCredit() {
		return typeOfCredit;
	}
	public void setTypeOfCredit(String typeOfCredit) {
		this.typeOfCredit = typeOfCredit;
	}
	public List<Rate> getRates() {
		return rates;
	}
	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}


}
	
