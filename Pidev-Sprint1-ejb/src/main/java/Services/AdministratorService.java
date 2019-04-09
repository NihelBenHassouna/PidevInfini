package Services;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.Admin;
import Interfaces.AdministratorInterface;


@Stateless
@Remote(AdministratorInterface.class)
public class AdministratorService implements AdministratorInterface {

	public AdministratorService() {
	}

	@PersistenceContext(unitName = "Pidev-Sprint1-ejb")
	EntityManager em;

	@Override
	public Admin AdminLogin(String login, String password) {
		Query q = em.createQuery("select a from Admin a where a.Login=:login and a.Password=:password").setParameter("login", login).setParameter("password",password);
		Admin a = new Admin();
		a= (Admin) q.getSingleResult();
		return a;
	}

	@Override
	public boolean AdminExist(String login, String password) {
		
			String sql ="Select count(d) from Admin d where d.Login=:login and d.Password=:password";
			Query q =em.createQuery(sql);
			q.setParameter("login", login);
			q.setParameter("password", password);
			long count=(long) q.getSingleResult();
			System.out.println("44444444444444444444444444444444444444"+count);
			return (count>0);
		
		
	}
	
	@Override
	public Admin GetAdminByLoginAndPassword(String login, String password) {
		TypedQuery<Admin> query = 
		em.createQuery("select e from Admin e WHERE e.Login=:login and e.Password=:password ", Admin.class); 
		query.setParameter("login", login); 
		query.setParameter("password", password); 
		Admin admin = null; 
		try {
			admin = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return admin;
	}
}
