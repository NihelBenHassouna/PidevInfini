package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Loan implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="Loan_ID") 
	protected int  id;
	@Column(name="LoanSum") 
	protected Double LoanSum;
	@Column(name="Duration") 
	protected int  Duration;
	@Column(name="Start_Date")
	protected Date StartDate;
	@Column(name="End_Date")
	protected Date EndDate;
	@Column(name="InterestRate") 
	protected int InterestRate;
	@Column(name="FileExpenses") 
	protected Double FileExpenses;
	@Column(name="Refund_Mode")
	@Enumerated(EnumType.STRING)
	protected Frequency RefundMode;
	@Column(name="Frequency_Amount") 
	private Double FrequencyAmount;
	@ManyToOne
	private CurrentAcount currentAccount;
	@OneToMany(mappedBy="loan", cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	private List<Penalty> penalties = new ArrayList<>();
	@OneToOne
	Gurantor guarantor;
	@OneToOne
	Gurantee gurantee;
	
	public List<Penalty> getPenalties() {
		return penalties;
	}
	public void setPenalties(List<Penalty> penalties) {
		this.penalties = penalties;
	}
	
	public Gurantor getGuarantor() {
		return guarantor;
	}
	public void setGuarantor(Gurantor guarantor) {
		this.guarantor = guarantor;
	}
	public Gurantee getGurantee() {
		return gurantee;
	}
	public void setGurantee(Gurantee gurantee) {
		this.gurantee = gurantee;
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
	public Loan(Double loanSum, int duration, Date startDate, Date endDate, int interestRate, Double fileExpenses,
			Frequency refundMode, Double frequencyAmount) {
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
	public Double getLoanSum() {
		return LoanSum;
	}
	public void setLoanSum(Double loanSum) {
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
	public int getInterestRate() {
		return InterestRate;
	}
	public void setInterestRate(int interestRate) {
		InterestRate = interestRate;
	}
	public Double getFileExpenses() {
		return FileExpenses;
	}
	public void setFileExpenses(Double fileExpenses) {
		FileExpenses = fileExpenses;
	}
	public Frequency getRefundMode() {
		return RefundMode;
	}
	public void setRefundMode(Frequency refundMode) {
		RefundMode = refundMode;
	}
	public Double getFrequencyAmount() {
		return FrequencyAmount;
	}
	public void setFrequencyAmount(Double frequencyAmount) {
		FrequencyAmount = frequencyAmount;
	}
	
	

}
