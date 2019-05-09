package ManagedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Customer;
import Entities.MicrocreditRequest;
import Services.microcreditService;

@ManagedBean(name = "consultReqBean") 
@SessionScoped
public class ConsultReq implements Serializable{
	private static final long serialVersionUID = 1L;
	private String typeC;
	private Double sumC;
	private int duration;
	private String description;
	private String state;
	
	
	
	
	@EJB
	microcreditService microcredService;
	int id=6;
	Customer user;
	List<MicrocreditRequest> microReq;
	public ConsultReq() {
	}
	public String getTypeC() {
		return typeC;
	}
	public void setTypeC(String typeC) {
		this.typeC = typeC;
	}
	public Double getSumC() {
		return sumC;
	}
	public void setSumC(Double sumC) {
		this.sumC = sumC;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
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
	public microcreditService getMicrocredService() {
		return microcredService;
	}
	public void setMicrocredService(microcreditService microcredService) {
		this.microcredService = microcredService;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getUser() {
		return user;
	}
	public void setUser(Customer user) {
		this.user = user;
	}
	public List<MicrocreditRequest> getMicroReq() {
		user=microcredService.getCustomerById(id);
		microReq=microcredService.SearchMicrocreditRequestByCustomerID(user);
		
		return microReq;
	}
	public void setMicroReq(List<MicrocreditRequest> microReq) {
		this.microReq = microReq;
	}

	public void DeleteReq(int idR)
	{
		microcredService.DeleteReq(idR);
	}
	
}
