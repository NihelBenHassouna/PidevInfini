package Interfaces;

import javax.ejb.Remote;

import Entities.Agent;
import Entities.User;
@Remote
public interface AgentInterface {

	public boolean AgentExist(String login, String password);
	public User GetAgentByLoginAndPassword(String login, String password);
	public int addAgent(Agent agent);
	public long countAgents();
}
