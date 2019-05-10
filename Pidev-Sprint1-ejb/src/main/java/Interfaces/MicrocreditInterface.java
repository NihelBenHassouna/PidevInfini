package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Comments;
import Entities.Customer;
import Entities.MicroCredit;
import Entities.MicrocreditPayment;
import Entities.MicrocreditRequest;
import Entities.Rate;
import Entities.User;


@Remote
public interface MicrocreditInterface {

	public int addRequestMicrocredit(MicrocreditRequest microcreditrequest,int id);
	public List<MicrocreditRequest> getRequestMicrocredit();
	public  List<MicrocreditRequest> SearchMicrocreditRequestByType(String typecredit) ;
	public Customer getCustomerById(int idcustomer);
	public  List<MicrocreditRequest> SearchMicrocreditRequestByState(String state) ;
	public void updateState(MicrocreditRequest request);
	public MicrocreditRequest getRequestById(int idreq);
	public long getNombreRequests();
	public int addMicrocredit(MicroCredit microcred ,int id);
	public Customer getCustomerByCIN(String cin);
	public List<Customer> getAllCustomers();
	public List<MicroCredit> getAllMicrocredits() ;
	public long getNombreMicrocreditInprogress();
	public long getNombreMicrocreditPaid();
	public long getNombreMicrocreditUnpaid();
	public long getNbrMicrocreditReqInprogress();
	public long getNbrMicrocreditReqRefused();
	public long getNbrMicrocreditReqAccepted();
	public int scoringMicrocreditRequest(int id);
	public void updateNote(MicrocreditRequest request) ;
	public MicroCredit getMicrocrecitByCustomerCin(Customer cust);
	public void updateMicrocreditAmount(MicroCredit microcredit);
	public int addMicrocreditPayment(MicrocreditPayment microcreditpayment, int id);
	public List<MicrocreditPayment> getMicrocrecitPayByMicrocredit(MicroCredit micro);
	public void updateState(MicroCredit micro) ;
	//public long getNbrMicrocreditPayment(int idmicro);
	public void updateStateUnpaid(MicroCredit micro) ;
	public List<MicroCredit> SearchMicrocreditByState(String state);
	public long getNombreCustomerMicrocreditMale() ;
	public long getNombreCustomerMicrocreditFemale();
	public long getNombreCustomerMicrocredit();
	
	
	
	public Double getAmountForSclCred() ;
	public Double getAmountForProfCred();
	public Double getAmountForAgrCred();
	public Double getAmountForAccomCred();
	public Double getAmountForTrvlCred();
	public Double getAmountForMargCred();
	public Double getAmountPaidForMargCred();
	public Double getAmountPaidForTrvlCred();
	public Double getAmountPaidForSclCred();
	public Double getAmountPaidForAccomCred();
	public Double getAmountPaidForAgrCred();
	public Double getAmountPaidForProfCred();
	
	
	
	
	public Double getAmountPaid();
	public Double getAmountStill();
	public List<MicrocreditRequest> SearchMicrocreditRequestByCustomerID(Customer  cust);
	public void DeleteReq(int idReq);
	public void  addRate( Rate rate);
	public Double AverageRate();
	public Double AverageRateSchool();
	public Double AverageRateMariage();
	public Double AverageRateTravel();
	public Double AverageRateAccommodation();
	public Double AverageRateProfessional();
	public void  addComment( Comments comment);
	public List<Comments> getCommentsSchool();
	public List<Comments> getCommentsAgriculture();
	public List<Comments> getCommentsTravel() ;
	public List<Comments> getCommentsMariage();
	public List<Comments> getCommentsAccomodation();
	public List<Comments> getCommentsProfessional();
	public boolean RateExistAgriculture(Customer cust);
	public boolean RateExistSchool(Customer cust);
	public boolean RateExistTravel(Customer cust) ;
	public boolean RateExistMariage(Customer cust);
	public boolean RateExistAccomodation(Customer cust);
	public boolean RateExistProfessional(Customer cust);
	
	
}
