package Services;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.CurrentAcount;
import Interfaces.CurrentAccountInterface;
@Stateless
@Remote(CurrentAccountInterface.class)
public class CurrentAccountService implements CurrentAccountInterface{
	@PersistenceContext(unitName = "Pidev-Sprint1-ejb")
	EntityManager em;

	@Override
	public List<CurrentAcount> DisplayAccount() {
		TypedQuery<CurrentAcount> query= em.createQuery("select a from CurrentAcount a", CurrentAcount.class);
		return query.getResultList();
		
		
	}

	@Override
	public CurrentAcount getidCurrentAcount(int user_id) {
		TypedQuery<CurrentAcount> query = em.createQuery(
				  "select c from CurrentAcount c join c.user u where u.id=:user_id", 
				  CurrentAcount.class);
				  query.setParameter("user_id",user_id);
				  return query.getSingleResult();
	}
	

}
