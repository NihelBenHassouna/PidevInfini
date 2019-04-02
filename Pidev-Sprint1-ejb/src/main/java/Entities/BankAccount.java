package Entities;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.ManyToOne;


@Entity 
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class BankAccount implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "Bank_Acount_id")
   private int id;
   @Column(name = "Rib")
   private String Rib;
   @Column(name = "Balance")
   private Double Balance;
   @Column(name="Creation_Date")
	private Date Creation ;
   @Column(name="Close_Date")
	private Date Close_Date ;
	@Column(name="Account_Status")
	private boolean Status;
	@ManyToOne
	private User user;
	/*  @OneToMany( mappedBy = "SenderAccount")
	 private Set<BankAccount> receiverAccounts = new HashSet<BankAccount>(0);
	 public Set<BankAccount> getReceiverAccounts() {
		return receiverAccounts;
	}
	public void setReceiverAccounts(Set<BankAccount> receiverAccounts) {
		this.receiverAccounts = receiverAccounts;
	}
	public BankAccount getSenderAccount() {
		return SenderAccount;
	}
	public void setSenderAccount(BankAccount senderAccount) {
		SenderAccount = senderAccount;
	}
	@ManyToOne(cascade = {})
	    @JoinColumn(name = "SenderAccountId", unique = false, nullable = true, insertable = true, updatable = true)
	 private BankAccount SenderAccount;
*/
	



	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	/*public BankAccount getAccount() {
		return account;
	}
	public void setAccount(BankAccount account) {
		this.account = account;
	}
	
	public Set<BankAccount> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<BankAccount> accounts) {
		this.accounts = accounts;
	}*/

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRib() {
		return Rib;
	}
	public void setRib(String rib) {
		Rib = rib;
	}
	public Double getBalance() {
		return Balance;
	}
	public void setBalance(Double balance) {
		Balance = balance;
	}
	public Date getCreation() {
		return Creation;
	}
	public void setCreation(Date creation) {
		Creation = creation;
	}
	public Date getClose_Date() {
		return Close_Date;
	}
	public void setClose_Date(Date close_Date) {
		Close_Date = close_Date;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", Rib=" + Rib + ", Balance=" + Balance + ", Creation=" + Creation
				+ ", Close_Date=" + Close_Date + ", Status=" + Status + "]";
	}
	public BankAccount() {
		super();
	}
	public BankAccount(String rib, Double balance, Date creation, Date close_Date, boolean status) {
		super();
		Rib = rib;
		Balance = balance;
		Creation = creation;
		Close_Date = close_Date;
		Status = status;
	}
	

}
