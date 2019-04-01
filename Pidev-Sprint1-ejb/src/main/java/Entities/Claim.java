package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Claim")
public class Claim implements Serializable{

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private AppointClaimFK APK;
	@ManyToOne
	@JoinColumn(insertable=false,updatable=false,name="id_agent")
	private Agent agent1;
	@ManyToOne
	@JoinColumn(name = "id_customer", insertable=false, updatable=false)
	private Customer customer1;
	public Agent getAgent1() {
		return agent1;
	}
	public void setAgent1(Agent agent1) {
		this.agent1 = agent1;
	}
	public Customer getCustomer1() {
		return customer1;
	}
	public void setCustomer1(Customer customer1) {
		this.customer1 = customer1;
	}


	public AppointClaimFK getAPK() {
		return APK;
	}
	public void setAPK(AppointClaimFK aPK) {
		APK = aPK;
	}

	@Column(name="Claim_Content")
	private String Content;
	@Column(name="Claim_Object")
	private String Object;
	@Column(name="Claim_Status")
	private String Status;
	@Column(name="Creation_Date")
	private Date Creation ;
	@Column(name="Treatment_Date")
	private Date Treatment_Date ;


	
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
	public Claim() {
		super();
	}
	@Override
	public String toString() {
		return "Claim [APK=" + APK + ", agent1=" + agent1 + ", customer1=" + customer1 + ", Content=" + Content
				+ ", Object=" + Object + ", Status=" + Status + ", Creation=" + Creation + ", Treatment_Date="
				+ Treatment_Date + "]";
	}

}
