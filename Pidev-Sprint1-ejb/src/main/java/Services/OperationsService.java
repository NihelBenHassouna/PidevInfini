package Services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Agency;
import Entities.BankAccount;
import Entities.CurrentAcount;
import Entities.Operation;
import Interfaces.OperationInterface;
@Stateless
public class OperationsService implements OperationInterface {
	@PersistenceContext(unitName = "Pidev-Sprint1-ejb")
	private EntityManager em;


/*	public Operation addOperation(Operation op, int Bank_Acount_id, int User_ID) {
		BankAccount ba=consultercompte(Bank_Acount_id);
		Agent agent =em.find(Agent.class,User_ID);
		op.setBankaccount(ba);
		op.setAgent(agent);
		em.persist(op);
		return op;
		
	}*/
	
	
	@Override
	public void verser(double montant,int Bank_Acount_id,int User_ID)
	{ 
		BankAccount ba = consultercompte(Bank_Acount_id);
		ba.setBalance(ba.getBalance()+montant);
	}
	/**
	 * function kima consulterAccount traja3lk currentAcoount w wahda okhra traja3lk saviings account
	 * 9bal kol opération tu teste si l id mta3 l compte eli bch tekhdou mel TextField si il est savings wala current
	 * w taamel test b CurrenctAcount a = testCurrent();
	 * if (a.getId()>0) ....
	 * **/
	 
	@Override
	public void retirer(double montant,int Bank_Acount_id,int User_ID)
	{
		BankAccount ba = consultercompte(Bank_Acount_id);
		ba.setBalance(ba.getBalance()-montant);
		
	}
	

	@Override
	public BankAccount consultercompte(int Bank_Acount_id) {
		BankAccount ba=em.find(BankAccount.class,Bank_Acount_id);
		if(ba==null) throw new RuntimeException("Compte introuvable");
		return ba;

	}

	@Override
	public List<Operation> consulterOperations(int Bank_Acount_id) {
		Query req=em.createQuery("Select o from Operation where o.BankAccount.Bank_Acount_id=:x");
		req.setParameter("x", Bank_Acount_id); 
		return req.getResultList();
	}
	@Override
	public void addOperation(Operation op) {
	//	BankAccount ba=consultercompte(op.getBankaccount().getId());
		
		op.setDateOperation(new Date());
		em.persist(op);
		int i =1;
		String test = "";
		test = ""+i;
		
	}
	@Override
	public void UpdateBalance(int id, double balance) {
		CurrentAcount a = em.find(CurrentAcount.class, id);
		System.out.println(a+" acacacaca");
		//a.setStatus(true);
		a.setBalance(a.getBalance()+balance);
	      em.merge(a);
		
		
	}

}
