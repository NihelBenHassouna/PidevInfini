package Interfaces;


import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;



import Entities.RealEstateRequest;
import Entities.User;



@Remote
public interface EstateRequestInterface {
	public List<RealEstateRequest> findAllRequests();
	public List<RealEstateRequest> findATreatedRequests();
	public List<RealEstateRequest> findAPreacceptedRequests();
	public List<User> findAllUsers();
	public int addRequest(RealEstateRequest request);
	public void affecterUserRequest(int id_user,int id_request);
	public User getuserById(int id_user);
	public RealEstateRequest getrequestByid(int id_request);
	public void updateRequest2(int id,float monthlypayment,float amountInterst);
	public RealEstateRequest getrequestByRef(String RefRequest) ;
	public void updateAgent1(int id,String LastName,String FirstName,String Cin,String Email,String phone,float Salary,Date hiringDate,String Title,String HomeAdress,Date birth,String MaritalStatus,String CampanyName,Integer kids,Integer seniority,String job,String employer,String  professionCategory,String disease, String position);
	public void updateRequest(int id,String ref);
	public void updateRequest1(int id,int Score);
	public void updateRequestStatus(int id,String status);
	public float getBalanceByAccount(int user_id);
	public Long countTreatedAccepted();
	public Long countTreatedRefused();
	public Long countPreaccepted();
	
}
