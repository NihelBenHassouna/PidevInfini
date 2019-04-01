package Interfaces;

import javax.ejb.Remote;

import Entities.Admin;

@Remote
public interface AdministratorInterface {
public Admin AdminLogin(String login, String password);
public boolean AdminExist(String login, String password);
public Admin GetAdminByLoginAndPassword(String login, String password);
}
