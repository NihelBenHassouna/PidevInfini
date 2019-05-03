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
@Table(name="MicrocreditPayment")
public class MicrocreditPayment implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="microcredit_id") 
	private int  id;
	
	
	@Column(name="payementdate")
	private Date payementdate;
	
	@Column(name="amountpaid") 
	private Double amountpaid;
	
	@ManyToOne
	private MicroCredit microcredit;

	public MicrocreditPayment() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPayementdate() {
		return payementdate;
	}

	public void setPayementdate(Date payementdate) {
		this.payementdate = payementdate;
	}

	public Double getAmountpaid() {
		return amountpaid;
	}

	public void setAmountpaid(Double amountpaid) {
		this.amountpaid = amountpaid;
	}

	public MicroCredit getMicrocredit() {
		return microcredit;
	}

	public void setMicrocredit(MicroCredit microcredit) {
		this.microcredit = microcredit;
	}

	public MicrocreditPayment(int id, Date payementdate, Double amountpaid, MicroCredit microcredit) {
		super();
		this.id = id;
		this.payementdate = payementdate;
		this.amountpaid = amountpaid;
		this.microcredit = microcredit;
	}

	@Override
	public String toString() {
		return "MicrocreditPayment [id=" + id + ", payementdate=" + payementdate + ", amountpaid=" + amountpaid
				+ ", microcredit=" + microcredit + "]";
	}
	
	
	
}
