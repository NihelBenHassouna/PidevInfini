package Services;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.CurrentAcount;
import Interfaces.CurrentAccountInterface;
@Stateless
@Remote(CurrentAccountInterface.class)
public class CurrentAccountService implements CurrentAccountInterface{
	@PersistenceContext(unitName = "Pidev-Sprint1-ejb")
	EntityManager em;

	@Override
	public List<CurrentAcount> DisplayActiveAccount() {
		TypedQuery<CurrentAcount> query= em.createQuery("select a from CurrentAcount a where Status = 1", CurrentAcount.class);
		return query.getResultList();
		
		
	}
	@Override
	public List<CurrentAcount> DisplayInActiveAccount() {
		TypedQuery<CurrentAcount> query= em.createQuery("select a from CurrentAcount a where Status =0", CurrentAcount.class);
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
	
	@Override
	public void updateCurrentAccount(int id, float Balance) {
		 Query query = em.createQuery("update CurrentAcount e set e.Balance=:Balance where e.id=:id");
		 query.setParameter("Balance",Balance);	
		 query.setParameter("id",id);
			int modified = query.executeUpdate();
			if(modified == 1){
				System.out.println("successfully updated");
			}else{
				System.out.println("failed to update");
			}
	
		
	}

}
