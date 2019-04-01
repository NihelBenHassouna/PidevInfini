package Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TransactionFK implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id_accountSender;
	private int id_accountReceiver;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_accountReceiver;
		result = prime * result + id_accountSender;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionFK other = (TransactionFK) obj;
		if (id_accountReceiver != other.id_accountReceiver)
			return false;
		if (id_accountSender != other.id_accountSender)
			return false;
		return true;
	}
	public TransactionFK(int id_accountSender, int id_accountReceiver) {
		super();
		this.id_accountSender = id_accountSender;
		this.id_accountReceiver = id_accountReceiver;
	}
	public TransactionFK() {
		super();
	}
	
	

}
