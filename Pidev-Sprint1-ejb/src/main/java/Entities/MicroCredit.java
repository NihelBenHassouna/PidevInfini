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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="MicroCredit")
public class MicroCredit implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="microcredit_id") 
	private int  id;
	
	@Column(name="typeCredit")
	private String typeCredit;
	@Column(name="microcreditSum") 
	private Double microcreditSum;
	@Column(name="duration") 
	private int  Duration;
	@Column(name="Start_Date")
	private Date StartDate;
	@Column(name="End_Date")
	private Date EndDate;
	@Column(name="InterestRate") 
	private float InterestRate;
	@Column(name="FileExpenses") 
	private Double FileExpenses;
	
	@Column(name="MonthlyPayment") 
	private Double MonthlyPayment;
	
	@Column(name="RiskFund") 
	private float RiskFund;
	@Column(name="TotalAmount") 
	private Double TotalAmount;
	@Column(name="stateOfpayment") 
	private String stateOfpayment;
	@Column(name="AmountPaid") 
	private Double AmountPaid;
	
	@OneToOne
	private Customer customermicrocredit;
	
	
	
	/*@OneToMany(mappedBy="microcred")
	private List<Penalty> penalty;*/
	
	@OneToMany(mappedBy="microcredit")
	private List<MicrocreditPayment> payment;
	
	public MicroCredit() {
		super();
	}

	public MicroCredit(int id, String typeCredit, Double microcreditSum, int duration, Date startDate, Date endDate,
			float interestRate, Double fileExpenses, Double monthlyPayment, float riskFund, Double totalAmount,
			String stateOfpayment, Double amountPaid, Customer customermicrocredit, CurrentAcount garantor
			) {
		super();
		this.id = id;
		this.typeCredit = typeCredit;
		this.microcreditSum = microcreditSum;
		Duration = duration;
		StartDate = startDate;
		EndDate = endDate;
		InterestRate = interestRate;
		FileExpenses = fileExpenses;
		MonthlyPayment = monthlyPayment;
		RiskFund = riskFund;
		TotalAmount = totalAmount;
		this.stateOfpayment = stateOfpayment;
		AmountPaid = amountPaid;
		this.customermicrocredit = customermicrocredit;
	}
	
	

	public MicroCredit(int id, String typeCredit, Date startDate, Date endDate, Double monthlyPayment,
			Double totalAmount, String stateOfpayment, Double amountPaid, Customer customermicrocredit ) {
		super();
		this.id = id;
		this.typeCredit = typeCredit;
		StartDate = startDate;
		EndDate = endDate;
		MonthlyPayment = monthlyPayment;
		TotalAmount = totalAmount;
		this.stateOfpayment = stateOfpayment;
		AmountPaid = amountPaid;
		this.customermicrocredit=customermicrocredit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeCredit() {
		return typeCredit;
	}

	public void setTypeCredit(String typeCredit) {
		this.typeCredit = typeCredit;
	}

	public Double getMicrocreditSum() {
		return microcreditSum;
	}

	public void setMicrocreditSum(Double microcreditSum) {
		this.microcreditSum = microcreditSum;
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

	public void setInterestRate(float interestRate) {
		InterestRate = interestRate;
	}

	public Double getFileExpenses() {
		return FileExpenses;
	}

	public void setFileExpenses(Double fileExpenses) {
		FileExpenses = fileExpenses;
	}

	public Double getMonthlyPayment() {
		return MonthlyPayment;
	}

	public void setMonthlyPayment(Double monthlyPayment) {
		MonthlyPayment = monthlyPayment;
	}

	public float getRiskFund() {
		return RiskFund;
	}

	public void setRiskFund(float riskFund) {
		RiskFund = riskFund;
	}

	public Double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		TotalAmount = totalAmount;
	}

	public String getStateOfpayment() {
		return stateOfpayment;
	}

	public void setStateOfpayment(String stateOfpayment) {
		this.stateOfpayment = stateOfpayment;
	}

	public Double getAmountPaid() {
		return AmountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		AmountPaid = amountPaid;
	}

	public Customer getCustomermicrocredit() {
		return customermicrocredit;
	}

	public void setCustomermicrocredit(Customer customermicrocredit) {
		this.customermicrocredit = customermicrocredit;
	}

	
	

	public List<MicrocreditPayment> getPayment() {
		return payment;
	}

	public void setPayment(List<MicrocreditPayment> payment) {
		this.payment = payment;
	}

	public MicroCredit(int id, String typeCredit, Double microcreditSum, int duration, Date startDate, Date endDate,
			float interestRate, Double fileExpenses, Double monthlyPayment, float riskFund, Double totalAmount,
			String stateOfpayment, Double amountPaid, Customer customermicrocredit, CurrentAcount garantor,
			List<MicrocreditPayment> payment) {
		super();
		this.id = id;
		this.typeCredit = typeCredit;
		this.microcreditSum = microcreditSum;
		Duration = duration;
		StartDate = startDate;
		EndDate = endDate;
		InterestRate = interestRate;
		FileExpenses = fileExpenses;
		MonthlyPayment = monthlyPayment;
		RiskFund = riskFund;
		TotalAmount = totalAmount;
		this.stateOfpayment = stateOfpayment;
		AmountPaid = amountPaid;
		this.customermicrocredit = customermicrocredit;
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "MicroCredit [id=" + id + ", typeCredit=" + typeCredit + ", microcreditSum=" + microcreditSum
				+ ", Duration=" + Duration + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", InterestRate="
				+ InterestRate + ", FileExpenses=" + FileExpenses + ", MonthlyPayment=" + MonthlyPayment + ", RiskFund="
				+ RiskFund + ", TotalAmount=" + TotalAmount + ", stateOfpayment=" + stateOfpayment + ", AmountPaid="
				+ AmountPaid + ", customermicrocredit=" + customermicrocredit 
				+  ", payment=" + payment + "]";
	}

	
	

	

	

	

	
	
	
	
}
