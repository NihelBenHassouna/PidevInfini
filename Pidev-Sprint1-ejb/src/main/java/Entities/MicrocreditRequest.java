package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="microcreditrequest")
public class MicrocreditRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id") 
	private int  id;
	@Column(name="microcreditSum") 
	private Double microcreditSum;
	

	@Column(name="duration") 
	private int  Duration;
	
	@ManyToOne
	private Customer users;
	
	@Column(name="description")
	private String description;
	
	@Column(name="state")
	private String state;
	
	@Column(name="typeCredit")
	private String typeCredit;
	
	@Column(name="dateRequest")
	private Date dateRequest;
	@OneToOne
	private Gurantor guarantor;
	
	@Column(name="note") 
	private int  note;

	public MicrocreditRequest() {
		super();
	}

	public MicrocreditRequest(int id, Double microcreditSum, int duration, Customer users, String description,
			String state, String typeCredit, Date dateRequest) {
		super();
		this.id = id;
		this.microcreditSum = microcreditSum;
		Duration = duration;
		this.users = users;
		this.description = description;
		this.state = state;
		this.typeCredit = typeCredit;
		this.dateRequest = dateRequest;
	}

	public MicrocreditRequest(int id, Double microcreditSum, int duration, String description, String state,
			String typeCredit, Date dateRequest,int note) {
		super();
		this.id = id;
		this.microcreditSum = microcreditSum;
		Duration = duration;
		this.description = description;
		this.state = state;
		this.typeCredit = typeCredit;
		this.dateRequest = dateRequest;
		this.note=note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getMicrocreditSum() {
		return microcreditSum;
	}

	public void setMicrocreditSum(Double microcreditSum) {
		this.microcreditSum = microcreditSum;
	}

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}

	public Customer getUsers() {
		return users;
	}

	public void setUsers(Customer users) {
		this.users = users;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTypeCredit() {
		return typeCredit;
	}

	public void setTypeCredit(String typeCredit) {
		this.typeCredit = typeCredit;
	}

	public Date getDateRequest() {
		return dateRequest;
	}

	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}

	public Gurantor getGuarantor() {
		return guarantor;
	}

	public void setGuarantor(Gurantor guarantor) {
		this.guarantor = guarantor;
	}

	public MicrocreditRequest(int id, Double microcreditSum, int duration, Customer users, String description,
			String state, String typeCredit, Date dateRequest, Gurantor guarantor) {
		super();
		this.id = id;
		this.microcreditSum = microcreditSum;
		Duration = duration;
		this.users = users;
		this.description = description;
		this.state = state;
		this.typeCredit = typeCredit;
		this.dateRequest = dateRequest;
		this.guarantor = guarantor;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public MicrocreditRequest(int id, Double microcreditSum, int duration, Customer users, String description,
			String state, String typeCredit, Date dateRequest, Gurantor guarantor, int note) {
		super();
		this.id = id;
		this.microcreditSum = microcreditSum;
		Duration = duration;
		this.users = users;
		this.description = description;
		this.state = state;
		this.typeCredit = typeCredit;
		this.dateRequest = dateRequest;
		this.guarantor = guarantor;
		this.note = note;
	}

	@Override
	public String toString() {
		return "MicrocreditRequest [id=" + id + ", microcreditSum=" + microcreditSum + ", Duration=" + Duration
				+ ", users=" + users + ", description=" + description + ", state=" + state + ", typeCredit="
				+ typeCredit + ", dateRequest=" + dateRequest + ", guarantor=" + guarantor + ", note=" + note + "]";
	}

	




	

	
	
	
}
