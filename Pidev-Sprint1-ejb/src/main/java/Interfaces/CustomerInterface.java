package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Customer;
import Entities.User;

@Remote
public interface CustomerInterface {
	public void blockCustomer(int id);
	public void activateAccount(int id);
	public Customer getCustomerById(int id);
	public List<User> displayCustomer();
	public List<User> displayAgents();
	public long countCustomers();
	public Customer getCustomerByLoginAndPassword(String login, String password);
}
