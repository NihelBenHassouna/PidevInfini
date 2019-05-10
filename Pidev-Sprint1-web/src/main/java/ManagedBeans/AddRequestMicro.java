package ManagedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.Customer;
import Entities.MicrocreditRequest;
import Services.microcreditService;
@ManagedBean(name = "addRequestBean") 
@SessionScoped
public class AddRequestMicro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@EJB
	microcreditService microcredService;
	int id=10;
	private String typecred;
	private int duration;
	private Double amount;
	private String description;
	private Customer cust;
	public AddRequestMicro() {
	}

	public microcreditService getMicrocredService() {
		return microcredService;
	}

	public void setMicrocredService(microcreditService microcredService) {
		this.microcredService = microcredService;
	}

	public String getTypecred() {
		return typecred;
	}

	public void setTypecred(String typecred) {
		this.typecred = typecred;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addRequestMicro()
	{
		
		if(amount>20000 || amount<200 )
		{
			 FacesMessage warningMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, 
			            "Warning!", "Amount must be under 20000DT and upper than 200DT.");
			        FacesContext.getCurrentInstance().addMessage("", warningMessage);
	       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Amount must be under 20000DT and upper than 200DT."));

			//FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Amount must be under 20000DT and upper than 200DT."));

		}
		else if(duration==0 || duration>36 )
		{
			 FacesMessage warningMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, 
			            "Warning!", "Number of months must be under 36 .");
			        FacesContext.getCurrentInstance().addMessage("", warningMessage);
	       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Amount must be under 20000DT and upper than 200DT."));

			//FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Amount must be under 20000DT and upper than 200DT."));

		}
		else{
		MicrocreditRequest microR=new MicrocreditRequest();
		microR.setTypeCredit(typecred);
		microR.setMicrocreditSum(amount);
		microR.setDescription(description);
		microR.setDuration(duration);
		
		microcredService.addRequestMicrocredit(microR, id); 
		Clear();
		}
	}
	
	
	
	public void Clear()
	{
		amount=0.0;
		duration=0;
		description="";
	}

}
