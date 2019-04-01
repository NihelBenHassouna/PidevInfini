package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.Table;

@Entity
@Table(name="Transaction")
public class Transaction implements Serializable{

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private TransactionFK TFK;
	@Column(name="Transaction_Date")
	private Date TransactionDate;
	@Column(name="amount")
	private Date amount;
	@Column(name="Transaction_Type")
	@Enumerated(EnumType.STRING)
	private TransactionCategory type;
  


	public Date getTransactionDate() {
		return TransactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		TransactionDate = transactionDate;
	}
	public Date getAmount() {
		return amount;
	}
	public void setAmount(Date amount) {
		this.amount = amount;
	}
	public TransactionCategory getType() {
		return type;
	}
	public void setType(TransactionCategory type) {
		this.type = type;
	}
	public Transaction(Date transactionDate, Date amount, TransactionCategory type) {
		super();
		TransactionDate = transactionDate;
		this.amount = amount;
		this.type = type;
	}
	public Transaction() {
		super();
	}
	@Override
	public String toString() {
		return "Transaction [TFK=" + TFK + ", TransactionDate=" + TransactionDate + ", amount=" + amount + ", type="
				+ type + "]";
	}

	

}
