package Interfaces;

import java.util.List;

import javax.ejb.Remote;
import Entities.CurrentAcount;

@Remote
public interface CurrentAccountInterface {
public List<CurrentAcount> DisplayAccount();
public CurrentAcount getidCurrentAcount(int id_user);
public void updateCurrentAccount(int id,float amount); 
}
