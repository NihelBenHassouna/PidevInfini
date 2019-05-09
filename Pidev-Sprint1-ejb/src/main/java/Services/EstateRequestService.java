package Services;

import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.Agency;
import Entities.Agent;
import Entities.Customer;
import Entities.RealEstateRequest;
import Entities.User;
import Interfaces.EstateRequestInterface;
@Stateless
@LocalBean
public class EstateRequestService implements EstateRequestInterface{
	@PersistenceContext(unitName = "Pidev-Sprint1-ejb")

	EntityManager em;
	@Override
	public List<RealEstateRequest> findAllRequests() {
		TypedQuery<RealEstateRequest> query= em.createQuery("select a from RealEstateRequest a where a.status='NonTraité' or a.status='in process'", RealEstateRequest.class);
		return query.getResultList();
	}

	@Override
	public List<User> findAllUsers() {
		TypedQuery<User> query= em.createQuery("select u from User u",User.class);
		return query.getResultList();
	}

	@Override
	public int addRequest(RealEstateRequest request) {
		em.persist(request);
		System.out.println("Out of addRequest" + request.getId());
		return request.getId();
	}

	@Override
	public void affecterUserRequest(int id_user, int id_request) {
		User user = em.find(User.class,id_user);
		RealEstateRequest request = em.find(RealEstateRequest.class,id_request);
	      request.setUser1(user);
	      em.merge(request);
	      System.out.println("succesfull");
		
		
	}

	@Override
	public Customer getuserById(int id_user) {
	Customer user = em.find(Customer.class,id_user);
		return user;
	}
	@Override
	public RealEstateRequest getrequestByRef(String RefRequest) {
		TypedQuery<RealEstateRequest> query = 
				em.createQuery("select a from RealEstateRequest a WHERE a.RefRequest=:RefRequest ",RealEstateRequest.class); 
				query.setParameter("RefRequest",RefRequest); 
	
				RealEstateRequest request = null; 
				try {
					request = query.getSingleResult(); 
				}
				catch (Exception e) {
					System.out.println("Erreur : " + e);
				}
				return request;
		
	}
	@Override
	public void updateAgent1(int id, String LastName, String FirstName, String Cin, String Email, String phone,
			float Salary, Date HiringDate, String Title, String HomeAdress, Date birth, String MaritalStatus,
			 String CampanyName,Integer KidsNumber,Integer Seniority,String job,String employer,String  professionCategory,String disease, String position) {
           Query query = em.createQuery("update Customer e set e.FirstName=:FirstName,e.LastName=:LastName,e.Cin=:Cin,e.Position=:Position,e.Email=:Email ,e.phone=:phone,e.Salary=:Salary,e.HiringDate=:HiringDate,e.Title=:Title,e.HomeAdress=:HomeAdress,e.BirthDate=:BirthDate,e.MaritalStatus=:MaritalStatus,e.CampanyName=:CampanyName,e.KidsNumber=:KidsNumber,e.Seniority=:Seniority,e.job=:job,e.employer=:employer,e.professionCategory=:professionCategory,e.disease=:disease where e.id=:id");
			query.setParameter("id",id);
			query.setParameter("LastName",LastName);
			query.setParameter("FirstName",FirstName);
			query.setParameter("Cin",Cin);
			query.setParameter("Email",Email);
			query.setParameter("phone",phone);
			query.setParameter("Salary",Salary);
			query.setParameter("HiringDate",HiringDate);
			query.setParameter("Title",Title);
			query.setParameter("HomeAdress",HomeAdress);
	        query.setParameter("BirthDate",birth);
	        query.setParameter("MaritalStatus",MaritalStatus);
			query.setParameter("CampanyName",CampanyName);
			query.setParameter("KidsNumber",KidsNumber);
			query.setParameter("Seniority",Seniority);
			query.setParameter("Seniority",Seniority);
			query.setParameter("job",job);
			query.setParameter("employer",employer);
			query.setParameter("professionCategory",professionCategory);
			query.setParameter("disease",disease);
			query.setParameter("Position",position);
			
			int modified = query.executeUpdate();
			if(modified == 1){
				System.out.println("successfully updated");
			}else{
				System.out.println("failed to update");
			}
			
		}

	@Override
	public void updateRequest(int id,String ref) {
	     Query query = em.createQuery("update RealEstateRequest e set e.RefRequest=:ref where e.id=:id");
				query.setParameter("id",id);
				query.setParameter("ref",ref);
				int modified = query.executeUpdate();
				if(modified == 1){
					System.out.println("successfully updated");
				}else{
					System.out.println("failed to update");
				}
		
	}

	@Override
	public void updateRequestStatus(int id,String status) {
	    Query query = em.createQuery("update RealEstateRequest e set e.status=:status where e.id=:id");
					query.setParameter("id",id);
					query.setParameter("status",status);
					int modified = query.executeUpdate();
					if(modified == 1){
						System.out.println("successfully updated");
					}else{
						System.out.println("failed to update");
					}
			
		
	}
	@Override
	public float getBalanceByAccount(int user_id) {
		TypedQuery<Float> query = em.createQuery(
				  "select c.salary from CurrentAcount c join c.user u where u.id=:user_id", 
				  Float.class);
				  query.setParameter("user_id",user_id);
				  return (Float)query.getSingleResult();
	}

	@Override
	public RealEstateRequest getrequestByid(int id_request) {
		RealEstateRequest request = em.find(RealEstateRequest.class,id_request);
		return request;
	}

	@Override
	public List<RealEstateRequest> findATreatedRequests() {
		TypedQuery<RealEstateRequest> query= em.createQuery("select a from RealEstateRequest a where a.status='Accepted' or a.status='Refused'", RealEstateRequest.class);
		return query.getResultList();
	}

	@Override
	public Long countTreatedAccepted() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from RealEstateRequest e where e.status='Accepted'",Long.class);
		     return query.getSingleResult();
	}

	@Override
	public Long countTreatedRefused() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from RealEstateRequest e where e.status='refused'",Long.class);
		     return query.getSingleResult();
	}

	@Override
	public void updateRequest1(int id, int Score) {
		 Query query = em.createQuery("update RealEstateRequest e set e.Score=:Score where e.id=:id");
			query.setParameter("id",id);
			query.setParameter("Score",Score);
			int modified = query.executeUpdate();
			if(modified == 1){
				System.out.println("successfully updated");
			}else{
				System.out.println("failed to update");
			}
	
		
	}

	@Override
	public Long countPreaccepted() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from RealEstateRequest e where e.status='PreAccepted'",Long.class);
		     return query.getSingleResult();
	}

	@Override
	public List<RealEstateRequest> findAPreacceptedRequests() {
		TypedQuery<RealEstateRequest> query= em.createQuery("select a from RealEstateRequest a where a.status='PreAccepted' order by a. Score DESC", RealEstateRequest.class);
		return query.getResultList();
	}

	@Override
	public void updateRequest2(int id, float monthlypayment, float amountInterst) {
		  Query query = em.createQuery("update RealEstateRequest e set e.monthlypayment=:monthlypayment,e.amountInterst=:amountInterst where e.id=:id");
			query.setParameter("id",id);
			query.setParameter("monthlypayment",monthlypayment);
			query.setParameter("amountInterst",amountInterst);
			int modified = query.executeUpdate();
			if(modified == 1){
				System.out.println("successfully updated");
			}else{
				System.out.println("failed to update");
			}
	
		
	}

	

}
