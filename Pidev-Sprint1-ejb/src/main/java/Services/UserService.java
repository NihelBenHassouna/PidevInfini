package Services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.User;
import Interfaces.UserInterface;
@Stateless
@LocalBean
public class UserService implements UserInterface{
	@PersistenceContext(unitName = "Pidev-Sprint1-ejb")

	EntityManager em;
	@Override
	public User getuserById(int id_user) {
	User user = em.find(User.class,id_user);
	return user;
	}
	@Override
	public User getUserByEmailAndPassword(String  Login,String Password) {
		TypedQuery<User> query = 
				em.createQuery("select e from User e WHERE e.Login=:Login and e.Password=:Password",User.class); 
				query.setParameter("Login",Login); 
				query.setParameter("Password",Password); 
				return query.getSingleResult(); 
				
			}

}
