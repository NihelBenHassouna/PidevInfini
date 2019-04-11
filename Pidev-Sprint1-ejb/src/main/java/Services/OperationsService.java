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
import Entities.SavingsAccount;
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
	public void verser(float montant,int Bank_Acount_id,int User_ID)
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
	public void retirer(float montant,int Bank_Acount_id,int User_ID)
	{
		BankAccount ba = consultercompte(Bank_Acount_id);
		ba.setBalance(ba.getBalance()-montant);
		
	}
	

	@Override
	public SavingsAccount consulterSavingsAccount(int Bank_Acount_id) {
		SavingsAccount ba=em.find(SavingsAccount.class,Bank_Acount_id);
		
		return ba;

	}
	@Override
	public boolean boolconsulterSavingsAccount(int Bank_Acount_id) {
		SavingsAccount ba=em.find(SavingsAccount.class,Bank_Acount_id);
		if(ba.equals(null))
		{
			return false;
		}
		else
		{
		return true;
		}
		


	}
	@Override
	public boolean boolconsulterCurrentAccount(int Bank_Acount_id) {
		CurrentAcount ba=em.find(CurrentAcount.class,Bank_Acount_id);
		if(ba.equals(null)){
			return false;
		}
		else{
		return true;
		}
	}
	@Override
	public CurrentAcount consulterCurrentAccount(int Bank_Acount_id) {
		CurrentAcount ba=em.find(CurrentAcount.class,Bank_Acount_id);
		
		return ba;

	}
	@Override
	public BankAccount consultercompte(int Bank_Acount_id) {
		BankAccount ba=em.find(BankAccount.class,Bank_Acount_id);
		
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
		System.out.println(op.getDateOperation());

		em.persist(op);
		int i =1;
		String test = "";
		test = ""+i;
		
	}
	@Override
	public void UpdateBalance(int id, float balance) {
		CurrentAcount a = em.find(CurrentAcount.class, id);
		
		System.out.println(a+" acacacaca");
		//a.setStatus(true);
		a.setBalance(a.getBalance()+balance);
	      em.merge(a);
		
		
	}
	@Override
	public void UpdateSaBalance(int id, float balance) {
		SavingsAccount a = em.find(SavingsAccount.class, id);
		
		System.out.println(a+" acacacaca");
		//a.setStatus(true);
		a.setBalance(a.getBalance()+balance);
	      em.merge(a);
		
		
	}
	@Override
	public void Update1SaBalance(int id, float balance) {
		SavingsAccount a = em.find(SavingsAccount.class, id);
		
		System.out.println(a+" acacacaca");
		//a.setStatus(true);
		a.setBalance(a.getBalance()-balance);
	      em.merge(a);
		
		
	}
	public List<Operation> consulterAllOperations() {
		List<Operation> Operations=em.createQuery("from Operation", Operation.class).getResultList();
		return Operations;
		
	}
	
	@Override
	public void Update1Balance(int id, float balance) {
		CurrentAcount a = em.find(CurrentAcount.class, id);
		System.out.println(a+" acacacaca");
		//a.setStatus(true);
		a.setBalance(a.getBalance()-balance);
	      em.merge(a);
		
	}
	@Override
	public int nombreversement(int bankacountid) {
		Query query=em.createQuery("Select count (*) from Operation where Bank_Acount_id=:x and operationType LIKE :y");
		query.setParameter("x",bankacountid);
		query.setParameter("y","versement");
		int a =((Number)query.getSingleResult()).intValue();
		return a;
	}
	@Override
	public int nombreretrait(int bankacountid) {
		Query query=em.createQuery("Select count (*) from Operation where Bank_Acount_id=:x and operationType LIKE :y");
		query.setParameter("x",bankacountid);
		query.setParameter("y","retrait");
		int a =((Number)query.getSingleResult()).intValue();
		return a;
	}
	
	
	

}
