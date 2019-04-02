package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Current_Account")
public class CurrentAcount extends BankAccount{

	private static final long serialVersionUID = 1L;
	@Column(name = "Overdraftauth")
	private Double Overdradtauth;
	@OneToMany(mappedBy="currentAccount", cascade = {CascadeType.ALL})
	private List<Loan> loans = new ArrayList<>();
	public Double getOverdradtauth() {
		return Overdradtauth;
	}
	public void setOverdradtauth(Double overdradtauth) {
		Overdradtauth = overdradtauth;
	}
	@Override
	public String toString() {
		return "CurrentAcount [Overdradtauth=" + Overdradtauth + ", getId()=" + getId() + ", getRib()=" + getRib()
				+ ", getBalance()=" + getBalance() + ", getCreation()=" + getCreation() + ", getClose_Date()="
				+ getClose_Date() + ", isStatus()=" + isStatus() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	public CurrentAcount() {
		super();
	}
	public CurrentAcount(Double overdradtauth) {
		super();
		Overdradtauth = overdradtauth;
	}
	

}
