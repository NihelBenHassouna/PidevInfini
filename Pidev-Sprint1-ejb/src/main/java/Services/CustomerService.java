package Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.Customer;
import Entities.User;
import Interfaces.CustomerInterface;
@Stateless
public class CustomerService implements CustomerInterface {
	@PersistenceContext(unitName = "Pidev-Sprint1-ejb")

	EntityManager em;
	@Override
	public void blockCustomer(int id) {
		 Query query = em.createQuery("update User e set e.blocked='1' where e.id=:id");
			query.setParameter("id",id);
			int modified = query.executeUpdate();
			if(modified == 1){
				System.out.println("successfully updated");
			}else{
				System.out.println("failed to update");
			}
			
		
	}
	

	@Override
	public void activateAccount(int id) {
		 Query query = em.createQuery("update CurrentAcount e set e.Status='1' where e.id=:id");
			query.setParameter("id",id);
			int modified = query.executeUpdate();
			if(modified == 1){
				System.out.println("successfully updated");
			}else{
				System.out.println("failed to update");
			}
		
	}

	@Override
	public Customer getCustomerById(int id) {
		
		Customer user = em.find(Customer.class,id);
		return user;
	}


	@Override
	public List<User> displayCustomer() {
		TypedQuery<User> query= em.createQuery("select a from User a where UserType='Customer'", User.class);
		return query.getResultList();
		
	}


	@Override
	public List<User> displayAgents() {
		TypedQuery<User> query= em.createQuery("select a from User a where UserType='Agent'", User.class);
		return query.getResultList();
	}


	@Override
	public long countCustomers() {
		String sql ="Select count(d) from User d where UserType='Customer'";
		Query q =em.createQuery(sql);
		return (long) q.getSingleResult();
	}


	@Override
	public Customer getCustomerByLoginAndPassword(String login, String password) {
		Query q = em.createQuery("select a from Customer a where a.Login=:login and a.Password=:password").setParameter("login", login).setParameter("password",password);
		Customer a = new Customer();
		a= (Customer) q.getSingleResult();
		return a;
	}




}
