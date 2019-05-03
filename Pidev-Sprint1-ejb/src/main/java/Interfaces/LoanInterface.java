package Interfaces;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import Entities.Customer;
import Entities.Payment;
import Entities.Penalty;
import Entities.RealEstateCredit;
import Entities.RealEstateRequest;




@Remote
public interface LoanInterface {
	public int addLoan(RealEstateCredit EstateCedit);
	public List<RealEstateCredit> findAllLoans();
	public void affecterLoan(int idcredit,int id_request, int id_cuurentaccountid);
	public RealEstateCredit getcreditById(int id_credit);
	public List<Payment> findAllpayments(int id_credit);
	public boolean PaymentExist(Date date,int id_credit);
	public void updateCredit(int id,float amount); 
	public int addPenality(Penalty p);
	public long countPayments(int id_credit);
	public double sumLoans();
	public long countCreditsunder();
	public long countCreditsbetween();
	public long countCreditsup();

	public void updatePayment(String string, int id);
}
