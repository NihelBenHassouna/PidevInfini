package ManagedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Services.microcreditService;

@ManagedBean(name = "simulatorBean") 
@SessionScoped
public class SimulatorCredit implements Serializable {
	private static final long serialVersionUID = 1L;

	private String typecred;
	private long amount;
	private int duration;
	private double monthlypayment;
	
	
	
	@EJB
	microcreditService microcredService;

	

	public SimulatorCredit() {
	}


	public String getTypecred() {
		return typecred;
	}


	public void setTypecred(String typecred) {
		this.typecred = typecred;
	}


	public long getAmount() {
		return amount;
	}


	public void setAmount(long amount) {
		this.amount = amount;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public microcreditService getMicrocredService() {
		return microcredService;
	}


	public void setMicrocredService(microcreditService microcredService) {
		this.microcredService = microcredService;
	}


	public double getMonthlypayment() {
		return monthlypayment;
	}


	public void setMonthlypayment(double monthlypayment) {
		this.monthlypayment = monthlypayment;
	}
	
	public double calculate()
	{
		 int dur;
			long cred;
			Double risk;
			Double fileExp;
			float interestR;
		if(amount>20000 || amount<200 ){
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Amount must be under 20000DT and upper than 200DT."));
		   }
		   else if(duration==0 || duration>36)
		   {  FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage(" Number of months must be under 36 ."));
	   
			  }
		  
		   else  if(typecred.equals("mariageCredit")||typecred.equals("travelCredit")||typecred.equals("AccomodationCredit"))
		  {
			  dur=duration;
	    		 cred=amount;
	    		 risk=amount*0.02;
	    		 interestR=0.02f;
	    		 fileExp=amount*0.02;
	    		monthlypayment=((Math.round((cred*(Math.pow(1+interestR, dur))+fileExp+risk))/dur)*100)/100;
	    		
		  }
		    
		  
		  else if (typecred.equals("agricultureCredit")||typecred.equals("travelCredit")||typecred.equals("ProfessionalCredit"))
		  	{
			  dur=duration;
	    		 cred=amount;
	    		 risk=amount*0.02;
	    		 interestR=0.01f;
	    		 fileExp=amount*0.02;
	    		monthlypayment=((Math.round((cred*(Math.pow(1+interestR, dur))+fileExp+risk))/dur)*100)/100;
	    		
		  	}
		  else
		  {
			  dur=duration;
	    		 cred=amount;
	    		 risk=amount*0.02;
	    		 interestR=0.005f;
	    		 fileExp=amount*0.02;
	    		monthlypayment=((Math.round((cred*(Math.pow(1+interestR, dur))+fileExp+risk))/dur)*100)/100;
		  }
		return monthlypayment;
	    
	}
	
	
}
