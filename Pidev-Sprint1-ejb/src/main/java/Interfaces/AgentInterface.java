package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Agent;
import Entities.Claim;
import Entities.User;
@Remote
public interface AgentInterface {

	public boolean AgentExist(String login, String password);
	public User GetAgentByLoginAndPassword(String login, String password);
	public int addAgent(Agent agent);
	public long countAgents();
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
