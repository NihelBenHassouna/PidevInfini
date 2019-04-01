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
		String sql ="Select count(d) from User d where role='agent' and Password=:password and Login=:login";
		Query q =em.createQuery(sql);
		q.setParameter("login", login);
		q.setParameter("password", password);
		long count=(long) q.getSingleResult();
		System.out.println("44444444444444444444444444444444444444 "+count);
		return (count>0);
	}

	@Override
	public Agent GetAgentByLoginAndPassword(String login, String password) {
		TypedQuery<Agent> query = 
				em.createQuery("select e from User e WHERE e.role like agent and e.Login=:login and e.Password=:password ", Agent.class);
				query.setParameter("login", login); 
				query.setParameter("password", password); 
				Agent user = null; 
				try {
					user = query.getSingleResult(); 
					
					
				}
				catch (Exception e) {
					System.out.println("Erreur : " + e);
				}
				return user;
			}
	}


