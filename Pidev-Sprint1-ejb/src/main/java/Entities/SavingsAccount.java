package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Savings_Account")
public class SavingsAccount extends BankAccount{

	
	private static final long serialVersionUID = 1L;
	   @Column(name = "Rate")
		private int Rate;
	public int getRate() {
		return Rate;
	}
	public void setRate(int rate) {
		Rate = rate;
	}
	@Override
	public String toString() {
		return "SavingsAccount [Rate=" + Rate + ", getId()=" + getId() + ", getRib()=" + getRib() + ", getBalance()="
				+ getBalance() + ", getCreation()=" + getCreation() + ", getClose_Date()=" + getClose_Date()
				+ ", isStatus()=" + isStatus() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	public SavingsAccount() {
		super();
	}
	public SavingsAccount(int rate) {
		super();
		Rate = rate;
	}
	   
	   
}
