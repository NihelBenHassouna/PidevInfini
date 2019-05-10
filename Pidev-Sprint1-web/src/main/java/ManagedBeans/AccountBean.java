package ManagedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Services.CurrentAccountService;
import Services.LoanService;

@ManagedBean(name = "AccountBean") 
@SessionScoped
public class AccountBean {
	@EJB
	CurrentAccountService cs;
	
	double s=0;

	
	

	public double getS() {
		return cs.sumAccount();
	}

	public void setS(double s) {
		this.s = s;
	}

	public double sum(){
		return cs.sumAccount();
	}
	
	public CurrentAccountService getCs() {
		return cs;
	}



	public void setCs(CurrentAccountService cs) {
		this.cs = cs;
	}



	public AccountBean() {
		
		
	}

}
