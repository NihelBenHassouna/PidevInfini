package Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Guarantee")
public class Gurantee implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column	(name="Guarantee_id")
	private int id;
	@Column(name="GuarantedBalance")
	private  Double Balance;
	@Column(name="GuaranteeType")
	@Enumerated(EnumType.STRING)
	private GuranteeType Type;
	@OneToOne(mappedBy="gurantee")
	private Loan loan;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getBalance() {
		return Balance;
	}
	public void setBalance(Double balance) {
		Balance = balance;
	}
	public GuranteeType getType() {
		return Type;
	}
	public void setType(GuranteeType type) {
		Type = type;
	}
	@Override
	public String toString() {
		return "Gurantee [id=" + id + ", Balance=" + Balance + ", Type=" + Type + "]";
	}
	public Gurantee() {
		super();
	}
	public Gurantee(Double balance, GuranteeType type) {
		super();
		Balance = balance;
		Type = type;
	}
	

}
