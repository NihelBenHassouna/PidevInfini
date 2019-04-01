package Interfaces;

import Entities.Operation;
import Entities.BankAccount;
import Entities.CurrentAcount;

import java.util.List;

import javax.ejb.Remote;
@Remote
public interface OperationInterface {
	public void addOperation (Operation op);
	public void verser(double montant,int Bank_Acount_id,int User_ID);
	public void retirer(double montant,int Bank_Acount_id,int User_ID);
	public BankAccount consultercompte(int Bank_Acount_id);
	public List<Operation> consulterOperations(int Bank_Acount_id);
	public void UpdateBalance(int id, double balance);
}

