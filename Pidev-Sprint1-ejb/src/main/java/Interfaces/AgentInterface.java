package Interfaces;

import java.util.List;
import javax.ejb.Remote;

import Entities.Agent;
import Entities.Claim;
import Entities.Customer;


@Remote
public interface AgentInterface {
	
	
	
	public int addClaim(Claim claim);
	
	public void affecterClaimAgent(Agent agent,int id_claim);
	
	public List<Claim> findAllClaims();
	
	public Claim getClaimById(int id_claim);
	
	public Claim getClaimByObjet(String Object);
	
	public boolean DeleteClaim(int id_claim);
	
	public boolean updateClaim(Claim claim );
	
	public String getEmailByCustomerId(int customer_id);
	
	public String getEmailByAgentId(int agent_id);
	
	

}