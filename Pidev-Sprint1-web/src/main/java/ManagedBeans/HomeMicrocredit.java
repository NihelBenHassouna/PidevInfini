package ManagedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Services.microcreditService;

@ManagedBean(name = "homeMicrocreditBean") 
@SessionScoped
public class HomeMicrocredit implements Serializable{
	private static final long serialVersionUID = 1L;

	private long nbrCustomer;
	private Double sumCredits;
	private Double averageCredit;
	private int percentage;

	@EJB
	microcreditService microcredService;
	public HomeMicrocredit() {
	}
	
	public long getNbrCustomer() {
		
		nbrCustomer= microcredService.getNombreCustomerMicrocredit();
		System.out.println("aaaaaaaaaaaaaaaaa"+nbrCustomer);

		return nbrCustomer;
	}

	public Double getSumCredits() {
		sumCredits=microcredService.getAmountPaid()+microcredService.getAmountStill();
		sumCredits=sumCredits/1000;
		
		return sumCredits;
	}

	public Double getAverageCredit() {
		averageCredit=(microcredService.getAmountPaid()+microcredService.getAmountStill())/microcredService.getNombreCustomerMicrocredit();
		
		averageCredit=averageCredit/1000;
		
		return averageCredit;
	}

	

	

	public int getPercentage() {
		double unpaid=microcredService.getNombreMicrocreditUnpaid();
		double paid=microcredService.getNombreMicrocreditPaid();
		double inprogress=microcredService.getNombreMicrocreditInprogress();
		double percent=((unpaid/(paid+inprogress))*100);
		percentage=(int)Math.round(percent);
		System.out.println("!-----------------::"+percentage);
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public void setAverageCredit(Double averageCredit) {
		this.averageCredit = averageCredit;
	}

	public void setSumCredits(Double sumCredits) {
		this.sumCredits = sumCredits;
	}

	public void setNbrCustomer(long nbrCustomer) {
		this.nbrCustomer = nbrCustomer;
	}

	public microcreditService getMicrocredService() {
		return microcredService;
	}
	public void setMicrocredService(microcreditService microcredService) {
		this.microcredService = microcredService;
	} 
	

	

	
	
}
