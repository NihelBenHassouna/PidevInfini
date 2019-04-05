package Services;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.Admin;
import Entities.Agent;
import Entities.User;
import Interfaces.AgentInterface;

@Stateless
@Remote(AgentInterface.class)
public class AgentService implements AgentInterface{
	@PersistenceContext(unitName = "Pidev-Sprint1-ejb")
	EntityManager em;
	public AgentService(){}
	@Override
	public boolean AgentExist(String login, String password) {
		String sql ="Select count(d) from User d where UserType='Agent' and Password=:password and Login=:login";
		Query q =em.createQuery(sql);
		q.setParameter("login", login);
		q.setParameter("password", password);
		long count=(long) q.getSingleResult();
		System.out.println("44444444444444444444444444444444444444 "+count);
		return (count>0);
	}

	@Override
	public User GetAgentByLoginAndPassword(String login, String password) {
		TypedQuery<User> query = 
				em.createQuery("select e from User e WHERE e.Login=:login and e.Password=:password ", User.class);
				query.setParameter("login",login); 
				query.setParameter("password",password); 
				User user=null;
					user = query.getSingleResult(); 
					System.out.println("54545454545888547558  "+user);
					return user;
			
			}
	}


