package ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.RealEstateRequest;
import Services.EstateRequestService;
@ManagedBean(name = "requestBean") 
@ApplicationScoped
public class RequestBean implements Serializable{


	private static final long serialVersionUID = 1L;

	@EJB
	EstateRequestService reqService; 
	
	private List<RealEstateRequest> requests; 
	private RealEstateRequest requ;
	private RealEstateRequest requ1;
	

	
	public RealEstateRequest getRequ1() {
		return requ1;
	}

	public void setRequ1(RealEstateRequest requ1) {
		this.requ1 = requ1;
	}

	public RequestBean() {
		super();
	}
	
	public EstateRequestService getReqService() {
		return reqService;
	}



	public void setReqService(EstateRequestService reqService) {
		this.reqService = reqService;
	}



	public List<RealEstateRequest> getRequests() {
		requests=reqService.findAllRequests();
		return requests;
	}



	public void setRequests(List<RealEstateRequest> requests) {
		this.requests = requests;
	}
	public String chercher(String ref)
	{
		requ=reqService.getrequestByRef(ref);
		System.out.println("balkisss");
		return "/pages/Agent/DisplayOneRequest?faces-redirect=true";
	}
	public String chercher1(String ref)
	{    System.out.println("l 'id de request"+ref);
		requ1=reqService.getrequestByRef(ref);
		return "/pages/Agent/SimulateLoan?faces-redirect=true";
	}
    public String allRequests()
    {
    	return "/pages/Agent/DisplayRequests?faces-redirect=true";
    }
    		
	public RealEstateRequest getRequ() {
		return requ;
	}




	public void setRequ(RealEstateRequest requ) {
		this.requ = requ;
	}

	/*private boolean showPopup;
	public void showw()
	{
		showPopup=true;
	}
	public void hide()
	{
		showPopup=false;
	}
	public boolean isShown()
	{
		return showPopup;
	}
	public void setshowpop(boolean showPopup)
	{
		this.showPopup=showPopup;
	}*/


}
