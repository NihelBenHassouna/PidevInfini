package Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AppointClaimFK implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_agent;
	private int id_customer;
	public int getId_agent() {
		return id_agent;
	}
	public void setId_agent(int id_agent) {
		this.id_agent = id_agent;
	}
	public int getId_customer() {
		return id_customer;
	}
	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}
	public AppointClaimFK(int id_agent, int id_customer) {
		super();
		this.id_agent = id_agent;
		this.id_customer = id_customer;
	}
	public AppointClaimFK() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_agent;
		result = prime * result + id_customer;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppointClaimFK other = (AppointClaimFK) obj;
		if (id_agent != other.id_agent)
			return false;
		if (id_customer != other.id_customer)
			return false;
		return true;
	}
	
	

}
