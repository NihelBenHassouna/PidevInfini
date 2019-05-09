package Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Agent;
import Entities.Claim;
import Entities.Customer;
import Interfaces.AgentInterface;



@Stateless
@LocalBean
public class AgentClaimService implements AgentInterface{
	
	@PersistenceContext(unitName = "Pidev-Sprint1-ejb")
	
	EntityManager em;
	@Override
	public int addClaim(Claim claim) {
		// TODO Auto-generated method stub
		em.persist(claim);
		System.out.println("Out of addClaim" + claim.getId());
		return claim.getId();
	}

	@Override
	public void affecterClaimAgent(Agent agent, int id_claim) {

		// TODO Auto-generated method stub
		//Agent agent = em.find(Agent.class, id_agent);
		Claim claim = em.find(Claim.class, id_claim);
	    claim.setAgent(agent);
	    em.merge(claim);
	}

	@Override
	public List<Claim> findAllClaims() {
		// TODO Auto-generated method stub
		TypedQuery<Claim> query= em.createQuery("select c from Claim c", Claim.class);
		return query.getResultList();
	}

	@Override
	public Claim getClaimById(int id_claim) {
		// TODO Auto-generated method stub
		Claim claim = em.find(Claim.class,id_claim);
		return claim;
	}

	@Override
	public boolean DeleteClaim(int id_claim) {
		// TODO Auto-generated method stub
		Claim claim = em.find(Claim.class, id_claim);
		em.remove(claim);
		return true;
	}

	@Override
	public Claim getClaimByObjet(String Object) {
		// TODO Auto-generated method stub
		TypedQuery<Claim> query = 
		em.createQuery("select c from Claim c WHERE c.Object=:Object ", Claim.class); 
		query.setParameter("Object", Object); 
	
		Claim claim = null; 
		try {
				claim = query.getSingleResult(); 
			}
		catch (Exception e) {
				System.out.println("Erreur : " + e);
			}
		return claim;
	}

	@Override
	public boolean updateClaim(Claim claim) {
		// TODO Auto-generated method stub
		
		Claim cl = em.find(Claim.class, claim.getId()); 
		
		cl.setCreation(claim.getCreation());
		cl.setStatus(claim.getStatus());
		cl.setTreatment_Date(claim.getTreatment_Date());
		cl.setObject(claim.getObject());
		cl.setContent(claim.getContent());
		cl.setAgent(claim.getAgent());
		
		return true;
	}
	
	@Override
	public String getEmailByCustomerId(int customer_id) {
		// TODO Auto-generated method stub
		Customer customer = em.find(Customer.class,customer_id);
		
		return customer.getEmail();
	}

	@Override
	public String getEmailByAgentId(int agent_id) {
		// TODO Auto-generated method stub
		Agent agent = em.find(Agent.class,agent_id);
		
		return agent.getEmail();
		
	}

}

