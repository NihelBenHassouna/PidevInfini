package Services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import Entities.User;
import Interfaces.UserInterface;
@Stateless
public class UserService implements UserInterface{
	@PersistenceContext(unitName = "Pidev-Sprint1-ejb")

	EntityManager em;
	@Override
	public User getuserById(int id_user) {
	User user = em.find(User.class,id_user);
	return user;
	}

}
