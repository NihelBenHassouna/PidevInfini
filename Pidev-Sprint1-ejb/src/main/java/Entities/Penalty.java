package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Penalty")
public class Penalty implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="Penalty_ID") 
	private int  id;
	@Column(name="Penalty_Date")
	private Date PenaltyDate ;
	@Column(name="Rate") 
	private int rate;
	@ManyToOne
	private Loan loan;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getPenaltyDate() {
		return PenaltyDate;
	}
	public void setPenaltyDate(Date penaltyDate) {
		PenaltyDate = penaltyDate;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public Penalty() {
		super();
	}
	public Penalty(Date penaltyDate, int rate) {
		super();
		PenaltyDate = penaltyDate;
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Penalty [id=" + id + ", PenaltyDate=" + PenaltyDate + ", rate=" + rate + "]";
	}
	public Loan getLoan() {
		return loan;
	}
	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	      

}
