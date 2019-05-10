package ManagedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Agency;
import Entities.Agent;
import Entities.Claim;
import Entities.Customer;
import Entities.User;
import Services.AdminAgencyService;
import Services.AdministratorService;
import Services.AgentService;
import Services.CustomerService;
import Services.UserService;

@ManagedBean(name = "UserBean") 
@SessionScoped
public class UserBean {
	String firstName;
	String lastName;
	String Gender;
	String email;
	String cin;
	String homeAddress;
	String workAddress;
	String password;
	String title;
	String job;
	String phone;
	Float salary;

	
	List<User> customers = new ArrayList<>();
	@EJB
	CustomerService cs;
	
	
	public void addCustomer(Customer c){
		cs.addCustomer(c);
	}
	public List<User> getCustomers() {
		return customers = cs.displayCustomer();
	}

	public void setCustomers(List<User> customers) {
		this.customers = customers;
	}

	public CustomerService getCs() {
		return cs;
	}

	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

	public UserBean() {
		// TODO Auto-generated constructor stub
	}
	
    public String allCustomers()
    {
    	return "/pages/Agent/AgentSpace?faces-redirect=true";
    }
    
    
  
	public List<User> getAllCustomer(){
    	customers= cs.displayCustomer();
    	System.out.println(customers);
    	return customers;
    }
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}

    
    
    
}
