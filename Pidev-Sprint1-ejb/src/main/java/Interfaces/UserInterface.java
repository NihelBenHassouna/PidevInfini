package Interfaces;

import javax.ejb.Remote;


import Entities.User;

@Remote
public interface UserInterface {
	
	public User getuserById(int id_user);
	public User getUserByEmailAndPassword(String  Login,String Password);

}
