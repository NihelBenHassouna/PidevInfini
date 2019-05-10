package ManagedBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ToggleEvent;

import Entities.Comments;
import Entities.Customer;
import Services.microcreditService;

@ManagedBean(name = "addCommentBean") 
@SessionScoped
public class AddComments implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
	microcreditService microcredService;
	
	int id=10;
	private String typecred;
	private String comment;
	private Customer cust;
	private List<Comments> comts;
	private List<Comments> agriclCom;
	private List<Comments> travelCom;
	private List<Comments> profesCom;
	private List<Comments> mariagCom;
	private List<Comments> AccomoCom;

	private Date date;
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public AddComments() {
		super();
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
	public String getTypecred() {
		return typecred;
	}
	public void setTypecred(String typecred) {
		this.typecred = typecred;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void saveCommentSchool() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful",  "Your Comment: " + comment + " saved") );
       Comments com=new Comments();
       com.setComment(comment);
   		cust=microcredService.getCustomerById(id);
       com.setCustomer(cust);
        com.setTypeMicrocred("schoolCredit");
        microcredService.addComment(com);
        Clear();
    }
	public List<Comments> getComts() {
		comts=microcredService.getCommentsSchool();
		return comts;
	}
	public void setComts(List<Comments> comts) {
		this.comts = comts;
	}
	
	
	 public List<Comments> getAgriclCom() {
		agriclCom=microcredService.getCommentsAgriculture();
		 return agriclCom;
	}
	public void setAgriclCom(List<Comments> agriclCom) {
		this.agriclCom = agriclCom;
	}
	public List<Comments> getTravelCom() {
		travelCom=microcredService.getCommentsTravel();
		return travelCom;
	}
	public void setTravelCom(List<Comments> travelCom) {
		this.travelCom = travelCom;
	}
	public List<Comments> getProfesCom() {
		profesCom=microcredService.getCommentsProfessional();
		return profesCom;
	}
	public void setProfesCom(List<Comments> profesCom) {
		this.profesCom = profesCom;
	}
	public List<Comments> getMariagCom() {
		mariagCom=microcredService.getCommentsMariage();
		return mariagCom;
	}
	public void setMariagCom(List<Comments> mariagCom) {
		this.mariagCom = mariagCom;
	}
	public List<Comments> getAccomoCom() {
		AccomoCom=microcredService.getCommentsAccomodation();
		return AccomoCom;
	}
	public void setAccomoCom(List<Comments> accomoCom) {
		AccomoCom = accomoCom;
	}
	public void handleToggle(ToggleEvent event) {
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" + event.getVisibility());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }

	public void saveCommentTravel() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful",  "Your Comment: " + comment + " saved") );
       Comments com=new Comments();
       com.setComment(comment);
   		cust=microcredService.getCustomerById(id);
       com.setCustomer(cust);
        com.setTypeMicrocred("travelCredit");
        microcredService.addComment(com);
        Clear();
    }
	public void saveCommentAgriculture() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful",  "Your Comment: " + comment + " saved") );
       Comments com=new Comments();
       com.setComment(comment);
   		cust=microcredService.getCustomerById(id);
       com.setCustomer(cust);
        com.setTypeMicrocred("agricultureCredit");
        microcredService.addComment(com);
        Clear();
    }
	public void saveCommentMariage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful",  "Your Comment: " + comment + " saved") );
       Comments com=new Comments();
       com.setComment(comment);
   		cust=microcredService.getCustomerById(id);
       com.setCustomer(cust);
        com.setTypeMicrocred("mariageCredit");
        microcredService.addComment(com);
        Clear();
    }
	public void saveCommentAccomodation() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful",  "Your Comment: " + comment + " saved") );
       Comments com=new Comments();
       com.setComment(comment);
   		cust=microcredService.getCustomerById(id);
       com.setCustomer(cust);
        com.setTypeMicrocred("AccomodationCredit");
        microcredService.addComment(com);
        Clear();
    }
	public void saveCommentProfessional() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful",  "Your Comment: " + comment + " saved") );
       Comments com=new Comments();
       com.setComment(comment);
   		cust=microcredService.getCustomerById(id);
       com.setCustomer(cust);
        com.setTypeMicrocred("ProfessionalCredit");
        microcredService.addComment(com);
        Clear();
    }
	
	public void Clear()
	{
		comment="";
	}
	
	
}
