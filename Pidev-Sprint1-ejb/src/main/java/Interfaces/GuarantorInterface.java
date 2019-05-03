package Interfaces;

import javax.ejb.Remote;

import Entities.Gurantee;
import Entities.Gurantor;

@Remote
public interface GuarantorInterface {
	public int addGuarantor(Gurantor g);
	public int addGuarantee(Gurantee g);
	public Gurantor getGuaarantorById(int id);
	public Gurantee getGuaaranteeById(int id);
}
