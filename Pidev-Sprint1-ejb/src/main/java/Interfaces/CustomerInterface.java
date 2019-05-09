package Interfaces;

import java.util.List;
import javax.ejb.Remote;
import Entities.Claim;


@Remote
public interface CustomerInterface {
	
	
	
	public int addClaim(Claim claim);
	
	public void affecterClaimCustomer(int id_customer,int id_claim);
	
	public List<Claim> findAllClaims();
	
	public Claim getClaimById(int id_claim);
	
	public Claim getClaimByObjet(String Object);
	
	public boolean DeleteClaim(int id_claim);
	
	public boolean updateClaim(Claim claim );
	
	
	

}
