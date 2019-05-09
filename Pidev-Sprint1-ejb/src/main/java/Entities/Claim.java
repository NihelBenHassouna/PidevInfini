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

@Table(name="Claim")


public class Claim implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id") 
	private int  id;
	
	@Column(name="Claim_Object")
	private String Object;
	
	@Column(name="Claim_Status")
	private String Status;
	
	@Column(name="Creation_Date")
	private Date Creation ;
	
	@Column(name="Treatment_Date")
	private Date Treatment_Date ;
	
	@Column(name="Claim_Content")
	private String Content;
	
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Agent agent;
	
	/*@ManyToOne
	private User user;*/


	public Claim() {
		super();
	}
	
	public Claim( Date creation, String status, Date treatment_Date,String object,String content) {
		Object = object;
		Status = status;
		Creation = creation;
		Treatment_Date = treatment_Date;
		Content = content;
	}
	
	public Claim(int id, Date creation, String status, Date treatment_Date,String object,String content) {
		this.id = id;
		Object = object;
		Status = status;
		Creation = creation;
		Treatment_Date = treatment_Date;
		Content = content;
	}

	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getObject() {
		return Object;
	}
	public void setObject(String object) {
		Object = object;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getCreation() {
		return Creation;
	}
	public void setCreation(Date creation) {
		Creation = creation;
	}
	public Date getTreatment_Date() {
		return Treatment_Date;
	}
	public void setTreatment_Date(Date treatment_Date) {
		Treatment_Date = treatment_Date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

	@Override
	public String toString() {
		return "Claim [id=" + id + ", Object=" + Object + ", Status=" + Status + ", Creation=" + Creation
				+ ", Treatment_Date=" + Treatment_Date + ", Content=" + Content + "]";
	}

}