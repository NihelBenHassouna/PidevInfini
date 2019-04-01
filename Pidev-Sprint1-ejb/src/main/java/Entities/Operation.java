package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Operation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int NumeroOperation;
	private Date DateOperation;
	private String operationType;
	private double Montant;
	@Override
	public String toString() {
		return "Operation [NumeroOperation=" + NumeroOperation + ", DateOperation=" + DateOperation + ", operationType="
				+ operationType + ", Montant=" + Montant + ", bankaccount=" + bankaccount + ", agent=" + agent + "]";
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	@ManyToOne
	@JoinColumn(name = "Bank_Acount_id")
	private BankAccount bankaccount;
	@ManyToOne
	@JoinColumn(name = "User_ID")
	private Agent agent;

	public int getNumeroOperation() {
		return NumeroOperation;
	}

	public void setNumeroOperation(int numeroOperation) {
		NumeroOperation = numeroOperation;
	}

	public Date getDateOperation() {
		return DateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		DateOperation = dateOperation;
	}

	public double getMontant() {
		return Montant;
	}

	public void setMontant(double montant) {
		Montant = montant;
	}

	public BankAccount getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(BankAccount bankaccount) {
		this.bankaccount = bankaccount;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operation(Date dateOperation, double montant, BankAccount bankaccount, Agent agent) {
		super();
		DateOperation = dateOperation;
		Montant = montant;
		this.bankaccount = bankaccount;
		this.agent = agent;
	}

}
