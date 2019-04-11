package Interfaces;

import Entities.Operation;
import Entities.SavingsAccount;
import javafx.collections.ObservableList;
import Entities.BankAccount;
import Entities.CurrentAcount;

import java.util.List;

import javax.ejb.Remote;
@Remote
public interface OperationInterface {
	public void addOperation (Operation op);
	public void verser(float montant,int Bank_Acount_id,int User_ID);
	public void retirer(float montant,int Bank_Acount_id,int User_ID);
	public List<Operation> consulterOperations(int Bank_Acount_id);
	public void UpdateBalance(int id, float balance);
	public List<Operation> consulterAllOperations();
	public void Update1Balance(int id, float balance);
	public void UpdateSaBalance(int id, float balance);
	public SavingsAccount consulterSavingsAccount(int Bank_Acount_id);
	public CurrentAcount consulterCurrentAccount(int Bank_Acount_id);
	public boolean boolconsulterSavingsAccount(int Bank_Acount_id);
	public boolean boolconsulterCurrentAccount(int Bank_Acount_id);
	public BankAccount consultercompte(int Bank_Acount_id);
	public void Update1SaBalance(int id, float balance);
	int nombreversement(int bankacountid);
	int nombreretrait(int bankacountid);
	
	
}

