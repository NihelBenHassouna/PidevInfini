package Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Rate implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="microcredit_id") 
	private int  id;
	
	private String typeMicrocred;
	
	private int rate;
	
	@ManyToOne
	private Customer customer2;

	public Rate() {
		super();
	}

	public Rate( String typeMicrocred, int rate, Customer customer2) {
		super();
		
		this.typeMicrocred = typeMicrocred;
		this.rate = rate;
		this.customer2 = customer2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeMicrocred() {
		return typeMicrocred;
	}

	public void setTypeMicrocred(String typeMicrocred) {
		this.typeMicrocred = typeMicrocred;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Customer getCustomer2() {
		return customer2;
	}

	public void setCustomer2(Customer customer2) {
		this.customer2 = customer2;
	}

	
	
}
