package Services;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import Entities.Agency;
import Entities.Customer;
import Entities.MicroCredit;
import Entities.MicrocreditPayment;
import Entities.MicrocreditRequest;
import Entities.Rate;
import Entities.User;
import Interfaces.MicrocreditInterface;


@Stateless
@LocalBean
public class microcreditService implements MicrocreditInterface {

	@PersistenceContext(unitName = "Pidev-Sprint1-ejb")

	EntityManager em;
	
	@Override
	public int addRequestMicrocredit(MicrocreditRequest microcreditrequest, int id) {
			
		em.persist(microcreditrequest);
			Customer cus=em.find(Customer.class, id);
			microcreditrequest.setUsers(cus);
			microcreditrequest.setDateRequest(new java.util.Date());
			microcreditrequest.setState("inprogress");
			
			return microcreditrequest.getId();
		
	}

	@Override
	public List<MicrocreditRequest> getRequestMicrocredit() {
		
		List<MicrocreditRequest> query= em.createQuery("select a from MicrocreditRequest a ", MicrocreditRequest.class).getResultList();
		return query;
		
	}

	@Override
	public List<MicrocreditRequest> SearchMicrocreditRequestByType(String typecredit) {
		TypedQuery<MicrocreditRequest> query= em.createQuery("select a from MicrocreditRequest a where a.typeCredit=:typecr", MicrocreditRequest.class);
		query.setParameter("typecr",typecredit);
		
		return query.getResultList();
	}

	@Override
	public Customer getCustomerById(int idcustomer) {
		TypedQuery<Customer> query= em.createQuery("select a from Customer a where a.id=:idusr", Customer.class);
		query.setParameter("idusr",idcustomer);
		return query.getSingleResult();
	}

	@Override
	public List<MicrocreditRequest> SearchMicrocreditRequestByState(String state) {
		TypedQuery<MicrocreditRequest> query= em.createQuery("select a from MicrocreditRequest a where a.state=:stat", MicrocreditRequest.class);
		query.setParameter("stat",state);
		
		return query.getResultList();
	}

	@Override
	public void updateState(MicrocreditRequest request) {
	MicrocreditRequest req =em.find(MicrocreditRequest.class, request.getId());
		req.setState(request.getState());
	}

	@Override
	public MicrocreditRequest getRequestById(int idreq) {
		TypedQuery<MicrocreditRequest> query= em.createQuery("select a from MicrocreditRequest a where a.id=:idr", MicrocreditRequest.class);
		query.setParameter("idr",idreq);
		return query.getSingleResult();
	}
	
	@Override
	public long getNombreRequests() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from MicrocreditRequest e", Long.class);
		return query.getSingleResult();
	} 
	
	@Override
	public int addMicrocredit(MicroCredit microcred, int id) {
		
			em.persist(microcred);
			Customer cus=em.find(Customer.class, id);
			microcred.setCustomermicrocredit(cus);
			cus.setTypeOfCredit("Microcredit");
			return microcred.getId();
		
	}
	@Override
	public Customer getCustomerByCIN(String cin) {
		TypedQuery<Customer> query= em.createQuery("select a from Customer a where a.Cin=:cin", Customer.class);
		query.setParameter("cin",cin);
		
		Customer customer = null; 
		try {
			customer = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		return customer;
	}


	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> customers= em.createQuery("select a from Customer a ", Customer.class).getResultList();
		return customers;
		
	}

	@Override
	public List<MicroCredit> getAllMicrocredits() {
		
		List<MicroCredit> microcredits= em.createQuery("select a from MicroCredit a ", MicroCredit.class).getResultList();
		return microcredits;
		
	}
	
	@Override
	public MicroCredit getMicrocrecitByCustomerCin(Customer cust) {
		TypedQuery<MicroCredit> query = 
		em.createQuery("select e from MicroCredit e WHERE e.customermicrocredit=:cust  ", MicroCredit.class); 
		query.setParameter("cust", cust); 
		MicroCredit microcred = null; 
		try {
			microcred = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return microcred;
	}
	
	@Override
	public long getNombreMicrocreditInprogress() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from MicroCredit e where e.stateOfpayment like'inprogress'", Long.class);
		long nbrinprogress=0; 
		try {
			nbrinprogress = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return nbrinprogress;
	} 
	@Override
	public long getNombreMicrocreditPaid() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from MicroCredit e where e.stateOfpayment like'paid'", Long.class);
		
		long nbrpaid=0; 
		try {
			nbrpaid = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return nbrpaid;
	} 
	
	@Override
	public long getNombreMicrocreditUnpaid() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from MicroCredit e where e.stateOfpayment like'unpaid'", Long.class);
		long nbrunpaid=0; 
		try {
			nbrunpaid = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return nbrunpaid;
	} 
	
	@Override
	public long getNbrMicrocreditReqInprogress() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from MicrocreditRequest e where e.state like'inprogress'", Long.class);
		long nbrinprogress=0; 
		try {
			nbrinprogress = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return nbrinprogress;
	} 
	@Override
	public long getNbrMicrocreditReqRefused() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from MicrocreditRequest e where e.state like'refused'", Long.class);
		
		long nbrRef=0; 
		try {
			nbrRef = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return nbrRef;
	} 
	@Override
	public long getNbrMicrocreditReqAccepted() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from MicrocreditRequest e where e.state like'accepted'", Long.class);
		long nbraccep=0; 
		try {
			nbraccep = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return nbraccep;
	} 
	
	@Override
	public int scoringMicrocreditRequest(int id)
	{
		int noteTot =0;
		int noteAge=0;
		int noteMaritalStatus=0;
		int noteKidsNumber=0;
		int notegender=0;
		int notesalary=0;
		int noteduration=0;
		int notetypecredit=0;
		int noteamount=0;

		MicrocreditRequest credReq=em.find(MicrocreditRequest.class, id);
		Customer cust;
		cust=credReq.getUsers();
		Calendar cal = Calendar.getInstance();
		
		int Age=cal.getTime().getYear()-cust.getBirthDate().getYear();
		
		if(Age<20)noteAge=1;
		if(Age>=20 && Age<30) {noteAge= 2;}
		if(Age>=30 && Age<50) {noteAge=5;}
		if(Age>=50 && Age<60) {noteAge= 3;}
		if(Age>=60) {noteAge= 1;}
		
		if(cust.getGender().equals("Male")){notegender=1;}
		if(cust.getGender().equals("Female")){notegender=2;}
		
		if(cust.getSalary()<400){notesalary=1;}
		if(cust.getSalary()>=400 &&cust.getSalary()<700){notesalary=2;}
		if(cust.getSalary()>=700 && cust.getSalary()<1000){notesalary=3;}
		if(cust.getSalary()>=1000 && cust.getSalary()<1500){notesalary=4;}
		if(cust.getSalary()>=1500 && cust.getSalary()<2000){notesalary=5;}
		if(cust.getSalary()>=2000 ){notesalary=6;}

		if(cust.getMaritalStatus().equals("Divorced")){noteMaritalStatus=1;}
		if(cust.getMaritalStatus().equals("Single")){noteMaritalStatus=2;}
		if(cust.getMaritalStatus().equals("Married")){noteMaritalStatus=4;}
		if(cust.getMaritalStatus().equals("Widow")){noteMaritalStatus=3;}
		
		if(cust.getKidsNumber()>=3){noteKidsNumber=1;}
		if(cust.getKidsNumber()==2){noteKidsNumber=3;}
		if(cust.getKidsNumber()<=1){noteKidsNumber=5;}
		
		if(credReq.getDuration()<6){noteduration=2;}
		if(credReq.getDuration()>=6 && credReq.getDuration()<12){noteduration=3;}
		if(credReq.getDuration()>=12 && credReq.getDuration()<18){noteduration=4;}
		if(credReq.getDuration()>=18 && credReq.getDuration()<24){noteduration=5;}
		if(credReq.getDuration()>=24){noteduration=6;}

		if(credReq.getTypeCredit().equals("schoolCredit")){notetypecredit=2;}
		if(credReq.getTypeCredit().equals("mariageCredit") ||credReq.getTypeCredit().equals("travelCredit")||credReq.getTypeCredit().equals("AccomodationCredit")){notetypecredit=3;}
		if(credReq.getTypeCredit().equals("agricultureCredit")||credReq.getTypeCredit().equals("ProfessionalCredit")){notetypecredit=5;}

		if(credReq.getMicrocreditSum()<1000){noteamount=1;}
		if(credReq.getMicrocreditSum()>=1000 && credReq.getMicrocreditSum()<5000){noteamount=2;}
		if(credReq.getMicrocreditSum()>=5000 && credReq.getMicrocreditSum()<10000){noteamount=4;}
		if(credReq.getMicrocreditSum()>=10000 && credReq.getMicrocreditSum()<20000){noteamount=6;}

		noteTot=noteAge+noteMaritalStatus+noteKidsNumber+noteduration+notetypecredit+noteamount+notegender+notesalary;
		
		
		
		return noteTot;
			
	}
	@Override
	public void updateNote(MicrocreditRequest request) {
	MicrocreditRequest req =em.find(MicrocreditRequest.class, request.getId());
		req.setNote(request.getNote());
	}
	
	
	@Override
	public void updateMicrocreditAmount(MicroCredit microcredit) {
	MicroCredit mic =em.find(MicroCredit.class, microcredit.getId());
		
		mic.setAmountPaid(mic.getAmountPaid()+microcredit.getAmountPaid());
		mic.setTotalAmount(Math.max((microcredit.getTotalAmount()-microcredit.getAmountPaid()),0));
	}
	
	@Override
	public int addMicrocreditPayment(MicrocreditPayment microcreditpayment, int id) {
			
		em.persist(microcreditpayment);
			MicroCredit mic=em.find(MicroCredit.class, id);
			microcreditpayment.setMicrocredit(mic);
			microcreditpayment.setPayementdate(new java.util.Date());
			
			return microcreditpayment.getId();
		
	}
	@Override
	public List<MicrocreditPayment> getMicrocrecitPayByMicrocredit(MicroCredit micro) {
		TypedQuery<MicrocreditPayment> query = 
		em.createQuery("select e from MicrocreditPayment e WHERE e.microcredit=:micro  ", MicrocreditPayment.class); 
		query.setParameter("micro", micro); 
		List<MicrocreditPayment> micropay = null; 
		try {
			micropay = query.getResultList(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return micropay;
	}
	
	
	@Override
	public void updateState(MicroCredit micro) {
		MicroCredit microcred =em.find(MicroCredit.class, micro.getId());
		if(microcred.getTotalAmount()==0){
		
			microcred.setStateOfpayment("paid");}
	}
	
	
	@Override
	public void updateStateUnpaid(MicroCredit micro) {
		MicroCredit microcred =em.find(MicroCredit.class, micro.getId());
		Date date=new java.util.Date();
		if(  date.compareTo(micro.getEndDate())>0){
		
			microcred.setStateOfpayment("unpaid");}
	}
	
	/*
	@Override
	public long getNbrMicrocreditPayment(int idmicro) {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from MicrocreditPayment e where e.microcredit=idmicro", Long.class);
		query.setParameter("idmicro", idmicro); 

		long nbrpay=0; 
		try {
			nbrpay = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return nbrpay;
	} 
*/
	
	

	@Override
	public List<MicroCredit> SearchMicrocreditByState(String state) {
		TypedQuery<MicroCredit> query= em.createQuery("select a from MicroCredit a where a.stateOfpayment=:state", MicroCredit.class);
		query.setParameter("state",state);
		
		return query.getResultList();
	}
	
	
	@Override
	public long getNombreCustomerMicrocredit() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from Customer e where e.typeOfCredit like'Microcredit' ", Long.class);
		
		long nbrcust=0; 
		try {
			nbrcust = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return nbrcust;

	}
	
	@Override
	public long getNombreCustomerMicrocreditMale() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from Customer e where e.typeOfCredit like'Microcredit'  and e.Gender like 'Male'", Long.class);
		
		long nbrcustmale=0; 
		try {
			nbrcustmale = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return nbrcustmale;
	} 
	@Override
	public long getNombreCustomerMicrocreditFemale() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from Customer e where e.typeOfCredit like'Microcredit' and e.Gender like 'Female' ", Long.class);
		
		long nbrcustFemale=0; 
		try {
			nbrcustFemale = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return nbrcustFemale;
	} 
	@Override
	public Double getAmountForSclCred() {
		TypedQuery<Double> query = 
				em.createQuery("select SUM(e.TotalAmount) from MicroCredit e where e.typeCredit like'schoolCredit'", Double.class);
		
		Double sum=0.0; 
		try {
			sum = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return sum;
	} 
	@Override
	public Double getAmountPaidForSclCred() {
		TypedQuery<Double> query = 
				em.createQuery("select SUM(e.AmountPaid) from MicroCredit e where e.typeCredit like'schoolCredit'", Double.class);
		
		Double sum=0.0; 
		try {
			sum = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return sum;
	} 
	
	@Override
	public Double getAmountForMargCred() {
		TypedQuery<Double> query = 
				em.createQuery("select SUM(e.TotalAmount) from MicroCredit e where e.typeCredit like'mariageCredit'", Double.class);
		
		Double sum=0.0; 
		try {
			sum = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return sum;
	} 
	
	@Override
	public Double getAmountPaidForMargCred() {
		TypedQuery<Double> query = 
				em.createQuery("select SUM(e.AmountPaid) from MicroCredit e where e.typeCredit like'mariageCredit'", Double.class);
		
		Double sum=0.0; 
		try {
			sum = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return sum;
	} 
	@Override
	public Double getAmountForTrvlCred() {
		TypedQuery<Double> query = 
				em.createQuery("select SUM(e.TotalAmount) from MicroCredit e where e.typeCredit like'travelCredit'", Double.class);
		
		Double sum=0.0; 
		try {
			sum = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return sum;
	} 
	
	@Override
	public Double getAmountPaidForTrvlCred() {
		TypedQuery<Double> query = 
				em.createQuery("select SUM(e.AmountPaid) from MicroCredit e where e.typeCredit like'travelCredit'", Double.class);
		
		Double sum=0.0; 
		try {
			sum = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return sum;
	} 
	
	
	@Override
	public Double getAmountForAccomCred() {
		TypedQuery<Double> query = 
				em.createQuery("select SUM(e.TotalAmount) from MicroCredit e where e.typeCredit like'AccomodationCredit'", Double.class);
		
		Double sum=0.0; 
		try {
			sum = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return sum;
	} 
	
	@Override
	public Double getAmountPaidForAccomCred() {
		TypedQuery<Double> query = 
				em.createQuery("select SUM(e.AmountPaid) from MicroCredit e where e.typeCredit like'AccomodationCredit'", Double.class);
		
		Double sum=0.0; 
		try {
			sum = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return sum;
	} 
	
	@Override
	public Double getAmountForAgrCred() {
		TypedQuery<Double> query = 
				em.createQuery("select SUM(e.TotalAmount) from MicroCredit e where e.typeCredit like'agricultureCredit'", Double.class);
		
		Double sum=0.0; 
		try {
			sum = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return sum;
	} 
	@Override
	public Double getAmountPaidForAgrCred() {
		TypedQuery<Double> query = 
				em.createQuery("select SUM(e.AmountPaid) from MicroCredit e where e.typeCredit like'agricultureCredit'", Double.class);
		
		Double sum=0.0; 
		try {
			sum = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return sum;
	} 

	@Override
	public Double getAmountForProfCred() {
		TypedQuery<Double> query = 
				em.createQuery("select SUM(e.TotalAmount) from MicroCredit e where e.typeCredit like'ProfessionalCredit'", Double.class);
		
		Double sum=0.0; 
		try {
			sum = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return sum;
	} 

	@Override
	public Double getAmountPaidForProfCred() {
		TypedQuery<Double> query = 
				em.createQuery("select SUM(e.AmountPaid) from MicroCredit e where e.typeCredit like'ProfessionalCredit'", Double.class);
		
		Double sum=0.0; 
		try {
			sum = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return sum;
	} 
	
	
	
	
	
	
	
	@Override
	public Double getAmountPaid() {
		TypedQuery<Double> query = 
				em.createQuery("select SUM(e.AmountPaid) from MicroCredit e ", Double.class);
		
		Double sum=0.0; 
		try {
			sum = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return sum;
	} 
	
	
	@Override
	public Double getAmountStill() {
		TypedQuery<Double> query = 
				em.createQuery("select SUM(e.TotalAmount) from MicroCredit e", Double.class);
		
		Double sum=0.0; 
		try {
			sum = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return sum;
	} 
	
	
	
	@Override
	public List<MicrocreditRequest> SearchMicrocreditRequestByCustomerID(Customer  cust) {
		TypedQuery<MicrocreditRequest> query= em.createQuery("select a from MicrocreditRequest a where a.users=:cust", MicrocreditRequest.class);
		query.setParameter("cust",cust);
		
		return query.getResultList();
	}
	
	@Override
	public void DeleteReq(int idReq) {
     MicrocreditRequest req = em.find(MicrocreditRequest.class, idReq);
		em.remove(req);
		}
	
	@Override
	public void  addRate( Rate rate) {
			
		em.persist(rate);


	}
	@Override
	public Double AverageRate()
	{
		TypedQuery<Double> query = 
				em.createQuery("select AVG(e.rate) from Rate e where e.typeMicrocred like'agricultureCredit' ", Double.class);
		
		Double avg=0.0; 
		try {
			avg = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return avg;
	}
	@Override
	public Double AverageRateSchool()
	{
		TypedQuery<Double> query = 
				em.createQuery("select AVG(e.rate) from Rate e where e.typeMicrocred like'schoolCredit' ", Double.class);
		
		Double avg=0.0; 
		try {
			avg = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return avg;
	}
	@Override
	public Double AverageRateMariage()
	{
		TypedQuery<Double> query = 
				em.createQuery("select AVG(e.rate) from Rate e where e.typeMicrocred like'mariageCredit' ", Double.class);
		
		Double avg=0.0; 
		try {
			avg = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return avg;
	}
	
	@Override
	public Double AverageRateTravel()
	{
		TypedQuery<Double> query = 
				em.createQuery("select AVG(e.rate) from Rate e where e.typeMicrocred like'travelCredit' ", Double.class);
		
		Double avg=0.0; 
		try {
			avg = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return avg;
	}
	@Override
	public Double AverageRateAccommodation()
	{
		TypedQuery<Double> query = 
				em.createQuery("select AVG(e.rate) from Rate e where e.typeMicrocred like'AccomodationCredit' ", Double.class);
		
		Double avg=0.0; 
		try {
			avg = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return avg;
	}
	
	@Override
	public Double AverageRateProfessional()
	{
		TypedQuery<Double> query = 
				em.createQuery("select AVG(e.rate) from Rate e where e.typeMicrocred like'ProfessionalCredit' ", Double.class);
		
		Double avg=0.0; 
		try {
			avg = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		
		
		return avg;
	}
	
	
	
	
}
