package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Loan implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="Loan_ID") 
	protected int  id;
	@Column(name="LoanSum") 
	protected float LoanSum;
	@Column(name="Duration") 
	protected int  Duration;
	@Column(name="Start_Date")
	protected Date StartDate;
	@Column(name="End_Date")
	protected Date EndDate;
	@Column(name="InterestRate") 
	protected float InterestRate;
	@Column(name="FileExpenses") 
	protected float FileExpenses;
	@Column(name="Refund_Mode")
	protected String RefundMode;
	@Column(name="GracePeriod") 
	protected int GracePeriod;
	@Column(name="Frequency_Amount") 
	protected float FrequencyAmount;
	@ManyToOne
	private CurrentAcount currentAccount;
	@OneToMany(mappedBy="loan", cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	private List<Penalty> penalties = new ArrayList<>();

	public int getGracePeriod() {
		return GracePeriod;
	}
	public void setGracePeriod(int gracePeriod) {
		GracePeriod = gracePeriod;
	}

	
	
	
	public List<Penalty> getPenalties() {
		return penalties;
	}
	public void setPenalties(List<Penalty> penalties) {
		this.penalties = penalties;
	}
	

	public CurrentAcount getCurrentAccount() {
		return currentAccount;
	}
	public void setCurrentAccount(CurrentAcount currentAccount) {
		this.currentAccount = currentAccount;
	}
	@Override
	public String toString() {
		return "Loan [id=" + id + ", LoanSum=" + LoanSum + ", Duration=" + Duration + ", StartDate=" + StartDate
				+ ", EndDate=" + EndDate + ", InterestRate=" + InterestRate + ", FileExpenses=" + FileExpenses
				+ ", RefundMode=" + RefundMode + ", FrequencyAmount=" + FrequencyAmount + "]";
	}
	public Loan() {
		super();
	}
	public Loan(float loanSum, int duration, Date startDate, Date endDate, int interestRate, float fileExpenses,
			String refundMode, float frequencyAmount) {
		super();
		LoanSum = loanSum;
		Duration = duration;
		StartDate = startDate;
		EndDate = endDate;
		InterestRate = interestRate;
		FileExpenses = fileExpenses;
		RefundMode = refundMode;
		FrequencyAmount = frequencyAmount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getLoanSum() {
		return LoanSum;
	}
	public void setLoanSum(float loanSum) {
		LoanSum = loanSum;
	}
	public int getDuration() {
		return Duration;
	}
	public void setDuration(int duration) {
		Duration = duration;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public float getInterestRate() {
		return InterestRate;
	}
	public void setInterestRate(float f) {
		InterestRate = f;
	}
	public float getFileExpenses() {
		return FileExpenses;
	}
	public void setFileExpenses(float fileExpenses) {
		FileExpenses = fileExpenses;
	}
	public String getRefundMode() {
		return RefundMode;
	}
	public void setRefundMode(String refundMode) {
		RefundMode = refundMode;
	}
	public float getFrequencyAmount() {
		return FrequencyAmount;
	}
	public void setFrequencyAmount(float frequencyAmount) {
		FrequencyAmount = frequencyAmount;
	}
	
	

}
