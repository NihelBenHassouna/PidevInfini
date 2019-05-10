package ManagedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.User;
import Services.AdministratorService;
import Services.UserService;


@ManagedBean(name = "loginBean") 
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String login; 
	private String password; 
	private User user; 
	private Boolean loggedIn;
	@EJB
  UserService userSer; 

	public String doLogin()
	{   	user = userSer.getUserByEmailAndPassword(login, password);
	       System.out.println("hhhhhhhhhhhhhhhhh");
	       System.out.println(user.toString());
		String navigateTo = "null"; 
		

		if (user != null && (user.getUserType().equals("Agent"))) {
			navigateTo = "/pages/Agent/AgentSpace?faces-redirect=true";
			loggedIn = true; 
		}
		if (user != null && (user.getUserType().equals("Customer"))) {
			navigateTo = "/pages/CustomerSpace?faces-redirect=true";
			loggedIn = true; 
		}
		
		else 
		{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return navigateTo; 
	}
	public String doLogout()
	{ 	
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/pages/test?faces-redirect=true";
	}
	public LoginBean() {
		super();
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	

}
