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
	private float Overdradtauth;
	@Column(name = "salary")
	private float salary;
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@OneToMany(mappedBy="currentAccount", cascade = {CascadeType.ALL})
	private List<Loan> loans = new ArrayList<>();
	public float getOverdradtauth() {
		return Overdradtauth;
	}
	public void setOverdradtauth(float overdradtauth) {
		Overdradtauth = overdradtauth;
	}


	@Override
	public String toString() {
		return "CurrentAcount [Overdradtauth=" + Overdradtauth + ", salary=" + salary + "]";
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
	public CurrentAcount(float overdradtauth) {
		super();
		Overdradtauth = overdradtauth;
	}
	

}
