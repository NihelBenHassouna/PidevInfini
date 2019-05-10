package ManagedBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Agency;
import Services.AdminAgencyService;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@ManagedBean(name = "AgencyBean") 
@SessionScoped
public class AgencyBean {
	
	List <Agency> agencies = new ArrayList<>();
	@EJB
	AdminAgencyService ag;
	public AgencyBean() {
		// TODO Auto-generated constructor stub
	}
	  public List<Agency> getAgencies() {
			agencies = ag.findAllAgencies();
	    	return agencies;
		}
		public void setAgencies(List<Agency> agencies) {
			this.agencies = agencies;
		}
		public AdminAgencyService getAg() {
			return ag;
		}
		public void setAg(AdminAgencyService ag) {
			this.ag = ag;
		}
		public void removeAgency(int id){
			ag.DeleteAgency(id);
		}
		

}
