package Services;



import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.Admin;
import Entities.Agency;
import Entities.User;
import Interfaces.AdminInterface;





@Stateless
public class AdminAgencyService implements AdminInterface{
	
	
	@PersistenceContext(unitName = "Pidev-Sprint1-ejb")

	EntityManager em;
	public int addAdmin(Admin admin) {
		em.persist(admin);
		System.out.println("Out of addAdmin" + admin.getId());
		return admin.getId();
	}
	@Override
	public int addAgency(Agency agency) {
		em.persist(agency);
		System.out.println("Out of addAgency" + agency.getId());
		return agency.getId();
	}

	@Override
	public int addUser(User user) {
		em.persist(user);
		System.out.println("Out of adduser" + user.getId());
		return user.getId();
	}
	@Override
	public void affecterAgenceAdmin(int id_admin, int id_agence) {
		Admin admin = em.find(Admin.class, id_admin);
		Agency agence = em.find(Agency.class, id_agence);
	      agence.setAdmin(admin);
	      em.merge(agence);
	    
		
	}
	@Override
	public void affecterUserAgency(int id_user, int id_agence) {
		User user = em.find(User.class, id_user);
		Agency agence = em.find(Agency.class, id_agence);
	      user.setAgency(agence);
	      em.merge(user);
		
	}
	



	@Override
	public int getNombreUserByAgenncy(int id_agence) {
	Query query = em.createNativeQuery("SELECT COUNT(User_ID) AS nbruser FROM user u  where  u.agency_Agency_ID = id_agence");
	query.setParameter("agency_Agency_ID",id_agence);
		return (int)query.getSingleResult();
	}
	@Override
	public List<Agency> findAllAgencies() {
		TypedQuery<Agency> query= em.createQuery("select a from Agency a", Agency.class);
		return query.getResultList();
		
		
	}
	@Override
	public Agency getAgencyById(int id_agence) {

		Agency agence = em.find(Agency.class,id_agence);
	return agence;
	}
	@Override
	public boolean DeleteAgency(int id_agence) {
     Agency agence = em.find(Agency.class, id_agence);
		em.remove(agence);
		return true;}
	@Override
	public Agency getAgencyByEmail(String email) {
		TypedQuery<Agency> query = 
				em.createQuery("select a from Agency a WHERE a.email=:email ", Agency.class); 
				query.setParameter("email", email); 
	
				Agency agency = null; 
				try {
					agency = query.getSingleResult(); 
				}
				catch (Exception e) {
					System.out.println("Erreur : " + e);
				}
				return agency;
		
	}
	@Override
	public boolean updateEmploye(Agency agence) {
		Agency ag = em.find(Agency.class, agence.getId()); 
		ag.setName(agence.getName());
		ag.setAdress(agence.getAdress());
		ag.setInformation(agence.getInformation());
		ag.setEmail(agence.getEmail());
		ag.setPhone(agence.getPhone());
		ag.setCreation(agence.getCreation());
		
		return true;
		
	}}



