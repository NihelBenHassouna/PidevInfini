package Services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Customer;
import Entities.Gurantee;
import Entities.Gurantor;

import Interfaces.GuarantorInterface;
@Stateless
public class GuarantorService implements GuarantorInterface{
	@PersistenceContext(unitName = "Pidev-Sprint1-ejb")

	EntityManager em;
	@Override
	public int addGuarantor(Gurantor g) {
		em.persist(g);
		return g.getId();
	}
	public int addGuarantee(Gurantee g)
	{
		em.persist(g);
		return g.getId();
	}
	@Override
	public Gurantor getGuaarantorById(int id) {
		Gurantor user = em.find(Gurantor.class,id);
		
		return user;
	}
	@Override
	public Gurantee getGuaaranteeById(int id) {
Gurantee user = em.find(Gurantee.class,id);
		
		return user;
	}

}
