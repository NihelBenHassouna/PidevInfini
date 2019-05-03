package Services;



import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.CurrentAcount;

import Entities.Payment;
import Entities.Penalty;
import Entities.RealEstateCredit;
import Entities.RealEstateRequest;

import Interfaces.LoanInterface;
@Stateless
public class LoanService implements LoanInterface{
	@PersistenceContext(unitName = "Pidev-Sprint1-ejb")

	EntityManager em;
	@Override
	public int addLoan(RealEstateCredit EstateCedit) {
		em.persist(EstateCedit);
		return EstateCedit.getId();
	}
	@Override
	public List<RealEstateCredit> findAllLoans() {
		TypedQuery<RealEstateCredit> query= em.createQuery("select u from RealEstateCredit u",RealEstateCredit.class);
		return query.getResultList();
	
	}
	@Override
	public void affecterLoan(int idcredit,int id_request, int id_cuurentaccountid) {
		RealEstateRequest request = em.find(RealEstateRequest.class,id_request);
		CurrentAcount account = em.find(CurrentAcount.class,id_cuurentaccountid);
		RealEstateCredit loan = em.find(RealEstateCredit.class,idcredit);
	    loan.setCurrentAccount(account);
	     loan.setEstateRequest(request);
	      em.merge(loan);
	      System.out.println("succesfull");
		
	}
	@Override
	public RealEstateCredit getcreditById(int id_credit) {
		RealEstateCredit credit = em.find(RealEstateCredit.class,id_credit);
		return credit;
	}
	@Override
	public List<Payment> findAllpayments(int idLoan) {
		TypedQuery<Payment> query= em.createQuery("select a from Payment a where a.idLoan=:idLoan",Payment.class);
		query.setParameter("idLoan",idLoan);
		return query.getResultList();
	}
	@Override
	public boolean PaymentExist(Date DatePay,int id) {
		String sql ="Select count(d) from Payment d where d.DatePay=:DatePay and d.id=:id";
		Query q =em.createQuery(sql);
		q.setParameter("DatePay",DatePay);
		q.setParameter("id",id);
		long count=(long) q.getSingleResult();
		System.out.println("tala3li fama payment ba3ed bechhar w ela le "+count);
		return (count>0);
	}
	@Override
	public void updateCredit(int id, float LoanSum) {
		 Query query = em.createQuery("update RealEstateCredit e set e.LoanSum=:LoanSum where e.id=:id");
		 query.setParameter("LoanSum",LoanSum);	
		 query.setParameter("id",id);
			int modified = query.executeUpdate();
			if(modified == 1){
				System.out.println("successfully updated");
			}else{
				System.out.println("failed to update");
			}
	
		
	}
	@Override
	public int addPenality(Penalty p) {
		em.persist(p);
		return p.getId();
	}
	@Override
	public long countPayments(int idLoan) {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from Payment e where e.idLoan=:idLoan",Long.class);
		    query.setParameter("idLoan",idLoan);
		    return query.getSingleResult();
		
	}
	@Override
	public double sumLoans() {
		Query query = 
				em.createQuery("select sum(e.LoanSum) from RealEstateCredit e ",Double.class);
		   
		    return (double) query.getSingleResult();
	}

	@Override
	public long countCreditsunder() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from RealEstateCredit e where   e.LoanSum < 30.0",Long.class);

		    return query.getSingleResult();
	}
	@Override
	public long countCreditsbetween() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from RealEstateCredit e where e.LoanSum  >= 30.0 and e.LoanSum <75.0 ",Long.class);

		    return query.getSingleResult();
	}
	@Override
	public long countCreditsup() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from RealEstateCredit e where e.LoanSum >= 75.0 ",Long.class);

		    return query.getSingleResult();
	}
	@Override
	public void updatePayment(String status,int id) {
		 Query query = em.createQuery("update Payment e set e.status=:status where e.id=:id");
		 query.setParameter("status",status);	
		 query.setParameter("id",id);
			int modified = query.executeUpdate();
			if(modified == 1){
				System.out.println("successfully updated");
			}else{
				System.out.println("failed to update");
			}
		
	}

}