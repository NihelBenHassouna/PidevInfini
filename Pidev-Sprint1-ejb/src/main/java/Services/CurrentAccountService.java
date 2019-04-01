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
	

}
