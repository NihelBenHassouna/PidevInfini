package ManagedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RateEvent;

import Entities.Customer;
import Entities.Rate;
import Services.microcreditService;

@ManagedBean
@SessionScoped
public class RatingView implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	microcreditService microcredService;
	int id=10;
	private Customer cust;
	private Double average=0.0;
	private Double averageSchool=0.0;
	private Double averageTravel=0.0;
	private Double averageAccomodation=0.0;
	private Double averageProfessional=0.0;
	private Double averageMariage=0.0;





    private Integer rating3;    
    
    public void onrate(RateEvent rateEvent) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + ((Integer) rateEvent.getRating()).intValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

  

    public Integer getRating3() {
        return rating3;
    }

    public void setRating3(Integer rating3) {
        this.rating3 = rating3;
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

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

    public Double getAverage() {
		average=(double)(Math.round(microcredService.AverageRate()*100)/100);
		
    	return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public Double getAverageSchool() {
		averageSchool=(double)(Math.round(microcredService.AverageRateSchool()*100)/100);

		return averageSchool;
	}

	public void setAverageSchool(Double averageSchool) {
		this.averageSchool = averageSchool;
	}

	public Double getAverageTravel() {
		averageTravel=(double)(Math.round(microcredService.AverageRateTravel()*100)/100);

		return averageTravel;
	}

	public void setAverageTravel(Double averageTravel) {
		this.averageTravel = averageTravel;
	}

	public Double getAverageAccomodation() {
		averageAccomodation=(double)(Math.round(microcredService.AverageRateAccommodation()*100)/100);

		return averageAccomodation;
	}

	public void setAverageAccomodation(Double averageAccomodation) {
		this.averageAccomodation = averageAccomodation;
	}

	public Double getAverageProfessional() {
		averageProfessional=(double)(Math.round(microcredService.AverageRateProfessional()*100)/100);

		return averageProfessional;
	}

	public void setAverageProfessional(Double averageProfessional) {
		this.averageProfessional = averageProfessional;
	}


	public Double getAverageMariage() {
		averageMariage=(double)(Math.round(microcredService.AverageRateMariage()*100)/100);

		return averageMariage;
	}

	public void setAverageMariage(Double averageMariage) {
		this.averageMariage = averageMariage;
	}

	public void addRate()
    {
    	
    	
    	cust=microcredService.getCustomerById(id);
    	if(microcredService.RateExistAgriculture(cust)){
    		FacesContext context = FacesContext.getCurrentInstance();
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Rate Given Already!") );
    	}
    	else{
    	Rate rate =new Rate();
    	
    	rate.setCustomer2(cust);
    	rate.setRate(rating3);
    	rate.setTypeMicrocred("agricultureCredit");
    	microcredService.addRate(rate);}
    }
	
	public void addRate1()
    {
    	
    	
    	cust=microcredService.getCustomerById(id);
    	
    	if(microcredService.RateExistSchool(cust)){
    		FacesContext context = FacesContext.getCurrentInstance();
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Rate Given Already!") );
    	}
    	else{
    		Rate rate =new Rate();
    	
    	rate.setCustomer2(cust);
    	rate.setRate(rating3);
    	rate.setTypeMicrocred("schoolCredit");
    	microcredService.addRate(rate);
    	}
    }
	
	public void addRateTravel()
    {
    	
    	
    	cust=microcredService.getCustomerById(id);
    	
    	if(microcredService.RateExistTravel(cust)){
    		FacesContext context = FacesContext.getCurrentInstance();
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Rate Given Already!") );
    	}
    	else{
    		Rate rate =new Rate();
    	
    	rate.setCustomer2(cust);
    	rate.setRate(rating3);
    	rate.setTypeMicrocred("travelCredit");
    	microcredService.addRate(rate);
    	}
    }
	
	public void addRateMariage()
    {
    	
    	
    	cust=microcredService.getCustomerById(id);
    	
    	if(microcredService.RateExistMariage(cust)){
    		FacesContext context = FacesContext.getCurrentInstance();
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Rate Given Already!") );
    	}
    	else{
    		Rate rate =new Rate();
    	
    	rate.setCustomer2(cust);
    	rate.setRate(rating3);
    	rate.setTypeMicrocred("mariageCredit");
    	microcredService.addRate(rate);
    	}
    }
	
	public void addRateAccomodation()
    {
    	
    	
    	cust=microcredService.getCustomerById(id);
    	
    	if(microcredService.RateExistAccomodation(cust)){
    		FacesContext context = FacesContext.getCurrentInstance();
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Rate Given Already!") );
    	}
    	else{
    		Rate rate =new Rate();
    	
    	rate.setCustomer2(cust);
    	rate.setRate(rating3);
    	rate.setTypeMicrocred("AccomodationCredit");
    	microcredService.addRate(rate);
    	}
    }
	
	public void addRateProfessional()
    {
    	
    	
    	cust=microcredService.getCustomerById(id);
    	
    	if(microcredService.RateExistProfessional(cust)){
    		FacesContext context = FacesContext.getCurrentInstance();
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Rate Given Already!") );
    	}
    	else{
    		Rate rate =new Rate();
    	
    	rate.setCustomer2(cust);
    	rate.setRate(rating3);
    	rate.setTypeMicrocred("ProfessionalCredit");
    	microcredService.addRate(rate);
    	}
    }
	
	
	
}
