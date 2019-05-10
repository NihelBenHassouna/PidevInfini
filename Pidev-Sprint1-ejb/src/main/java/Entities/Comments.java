package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comments implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="comment_id") 
	private int  id;
	private String typeMicrocred;
	private String comment;
	@ManyToOne
	private Customer customer;
	
	private Date dateCom;

	
	public Comments() {
		super();
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDateCom() {
		return dateCom;
	}

	public void setDateCom(Date dateCom) {
		this.dateCom = dateCom;
	}
	
	
	
	
	
}
