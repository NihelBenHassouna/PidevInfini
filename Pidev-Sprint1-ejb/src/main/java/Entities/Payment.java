package Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column	(name="Payment_id")
	private int id;
	@Column(name="Date_Payment")
     Date DatePay;
	@Column(name="amount")
	float amount;
	@Column(name="idUser")
	int idUser;
	@Column(name="idLoan")
	int idLoan;
	@Column(name="status")
	String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDatePay() {
		return DatePay;
	}
	public void setDatePay(Date datePay) {
		DatePay = datePay;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getIdUser() {
		return idUser;
	}
	public Payment() {
		super();
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdLoan() {
		return idLoan;
	}
	public void setIdLoan(int idLoan) {
		this.idLoan = idLoan;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Payment(Date date) {
		this.DatePay=date;
	}
	public Payment(Date datePay2, String status2,int id) {
		this.DatePay=datePay2;
		this.status=status2;
		this.id=id;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", DatePay=" + DatePay + ", amount=" + amount + ", idUser=" + idUser + ", idLoan="
				+ idLoan + ", status=" + status + "]";
	}

	
	
}
