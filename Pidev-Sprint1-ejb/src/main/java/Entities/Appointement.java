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
@Table(name="Appointement")
public class Appointement implements Serializable{

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private AppointClaimFK APK;
        
	@ManyToOne
	@JoinColumn(insertable=false,updatable=false,name="id_agent")
	private Agent agent;
	@ManyToOne
	@JoinColumn(name = "id_customer", insertable=false, updatable=false)
	private Customer customer;
	

	public AppointClaimFK getAPK() {
		return APK;
	}
	public void setAPK(AppointClaimFK aPK) {
		APK = aPK;
	}
	
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Column(name="Meeting_Date")
	private Date Meeting_Date;
	@Column(name="Appointement_Status")
	private boolean Status;
	

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;}

	public Date getMeeting_Date() {
		return Meeting_Date;
	}
	public void setMeeting_Date(Date meeting_Date) {
		Meeting_Date = meeting_Date;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}

    @Override
	public String toString() {
		return "Appointement [Meeting_Date=" + Meeting_Date + ", Status=" + Status + "]";
	}
	public Appointement() {
		super();
	}
	
}
