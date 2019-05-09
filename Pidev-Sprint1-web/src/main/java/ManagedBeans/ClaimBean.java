package ManagedBeans;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.Claim;
import Services.CustomerClaimService;




@ManagedBean(name= "claimBean")
@SessionScoped
public class ClaimBean implements Serializable {
	
	private static final long serialVersionUID= 1L;
	private Date CreationDate; 
	private String ClaimStatus; 
	private Date TreatmentDate;
	private String ClaimObject; 
	private String ClaimContent;
	
	private Integer claimIdToBeUpdated;
		
	@EJB
	CustomerClaimService customerClaimService;
	
	public String doLogin1() { 
		String navigateTo = "null";
		navigateTo = "/pages/ClaimCustomerSpace?faces-redirect=true"; //ClaimCustomerSpace // welcome // ClaimAgentSpace
		return navigateTo;
	}
	
	public String doLogin2() { 
		String navigateTo = "null";
		navigateTo = "/pages/ClaimAgentSpace?faces-redirect=true"; //ClaimCustomerSpace // welcome // ClaimAgentSpace
		return navigateTo;
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}
	
	
	
	public void addClaim() {	
	customerClaimService.addClaim(new Claim( CreationDate, ClaimStatus, TreatmentDate,ClaimObject,ClaimContent));
	}
	
	private List<Claim> claims;
	
	
	public void removeClaim(int claimId)
	{
		customerClaimService.DeleteClaim(claimId);
	}
	
	
	
	public void displayClaim(Claim clm)
	{
		this.setCreationDate(clm.getCreation());
		this.setClaimStatus(clm.getStatus());
		this.setTreatmentDate(clm.getTreatment_Date());
		this.setClaimObject(clm.getObject());
		this.setClaimContent(clm.getContent());
		this.setClaimIdToBeUpdated(clm.getId());
	}
	

	public void updateClaim()
	{ 
		customerClaimService.updateClaim(new Claim(claimIdToBeUpdated,CreationDate, ClaimStatus, TreatmentDate,ClaimObject,ClaimContent));
	} 

	

	public Date getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}

	public String getClaimStatus() {
		return ClaimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		ClaimStatus = claimStatus;
	}

	public Date getTreatmentDate() {
		return TreatmentDate;
	}

	public void setTreatmentDate(Date treatmentDate) {
		TreatmentDate = treatmentDate;
	}

	public String getClaimObject() {
		return ClaimObject;
	}

	public void setClaimObject(String claimObject) {
		ClaimObject = claimObject;
	}

	public String getClaimContent() {
		return ClaimContent;
	}

	public void setClaimContent(String claimContent) {
		ClaimContent = claimContent;
	}

	public CustomerClaimService getCustomerClaimService() {
		return customerClaimService;
	}

	public void setCustomerClaimService(CustomerClaimService customerClaimService) {
		this.customerClaimService = customerClaimService;
	}

	public List<Claim> getClaims() {
		
		claims = customerClaimService.getAllClaims();
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public Integer getClaimIdToBeUpdated() {
		return claimIdToBeUpdated;
	}

	public void setClaimIdToBeUpdated(Integer claimIdToBeUpdated) {
		this.claimIdToBeUpdated = claimIdToBeUpdated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
