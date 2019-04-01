package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Admin;
import Entities.Agency;
import Entities.User;



@Remote
public interface AdminInterface {
	public int addAdmin(Admin admin);
	public int addAgency(Agency agency);
	public void affecterAgenceAdmin(int id_admin,int id_agence);
	public void affecterUserAgency(int id_user,int id_agence);
	public int addUser(User user);
	public List<Agency> findAllAgencies();
	public int getNombreUserByAgenncy(int id_agence);
	public Agency getAgencyById(int id_agence);
	public Agency getAgencyByEmail(String email);
	public boolean DeleteAgency(int id_agence);
	public boolean updateEmploye(Agency agence);
}
