package Entities;


import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="RealEstateRequest")
public class RealEstateRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="Request_ID") 
	private int  id;
	@Column(name="Typeestate") 
	private String TypeEstate;
	@Column(name="ProjectValue") 
	private float ProjectValue;
   @Column(name="PropretyDes") 
	private String PropretyDes;
	@Column(name="Status") 
	private String status;
	@Column(name="Otherearning") 
	private float Otherearning;
	@Column(name="Otherloan") 
	private boolean Otherloan;
	@Column(name="PropretyNature") 
	private String PropretyNature;
	@Column(name="PropretyAdress") 
	private String PropretyAdress;
	@Column(name="LandArea") 
	private float LandArea;
	@Column(name="ConstructionDate") 
	private Date ConstructionDate;
	@Column(name="SellerName") 
	private String SellerName;
	@Column(name="CoveredArea") 
	private float CoveredArea;
	@Column(name="GracePeriod") 
	private int GracePeriod;
	@Column(name="DesiredPeriod") 
	private int DesiredPeriod;
	@Column(name="DurationContract") 
	private int DurationContract;
	@Column(name="Gurantor_id") 
	private int ID_Gurantor;
	@Column(name="Gurantee_id") 
	private int ID_Gurantee;
	@Column(name="Req_Score") 
	private int Score;
	@Column(name="Start_Date") 
	private Date Start_Date;
	@Column(name="anotherCreditPayment") 
	private float anotherCreditPayment;
	@Column(name="Frequency") 
	private String Frequency;
	@ManyToOne
	private User user1;
	@OneToOne(mappedBy="EstateRequest")
	private RealEstateCredit realestatecredit;
	@Column(name="anotherCreditRemainingTime") 
	private int anotherCreditRemainingTime;
	@Column(name="AmountRequest") 
	private float AmountRequest;
	@Column(name="RefRequest") 
	private String RefRequest;
	@Column(name="DateRequest") 
	private Date DateRequest;
	@Column(name="Monthly_payment") 
	private float monthlypayment=0;
	@Column(name="amount_with_interest") 
	private float amountInterst=0;

	
	public float getMonthlypayment() {
		return monthlypayment;
	}
	public void setMonthlypayment(float monthlypayment) {
		this.monthlypayment = monthlypayment;
	}
	public float getAmountInterst() {
		return amountInterst;
	}
	public void setAmountInterst(float amountInterst) {
		this.amountInterst = amountInterst;
	}
	public Date getStart_Date() {
		return Start_Date;
	}
	public void setStart_Date(Date start_Date) {
		Start_Date = start_Date;
	}
	public void setProjectValue(float projectValue) {
		ProjectValue = projectValue;
	}
	public int getID_Gurantee() {
		return ID_Gurantee;
	}
	public void setID_Gurantee(int iD_Gurantee) {
		ID_Gurantee = iD_Gurantee;
	}
	public int getID_Gurantor() {
		return ID_Gurantor;
	}
	public void setID_Gurantor(int iD_Gurantor) {
		ID_Gurantor = iD_Gurantor;
	}
	public int getDurationContract() {
		return DurationContract;
	}
	public void setDurationContract(int durationContract) {
		DurationContract = durationContract;
	}

    public String getFrequency() {
		return Frequency;
	}
	public void setFrequency(String frequency) {
		Frequency = frequency;
	}
	
	public String getRefRequest() {
		return RefRequest;
	}
	public void setRefRequest(String refRequest) {
		RefRequest = refRequest;
	}

	
	public Date getDateRequest() {
		return DateRequest;
	}
	public void setDateRequest(Date dateRequest) {
		DateRequest = dateRequest;
	}

	public float getOtherearning() {
		return Otherearning;
	}
	public void setOtherearning(float otherearning) {
		Otherearning = otherearning;
	}
	public boolean isOtherloan() {
		return Otherloan;
	}
	public void setOtherloan(boolean otherloan) {
		Otherloan = otherloan;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	

	public RealEstateRequest(String typeEstate,Date dateRequest, String refRequest,float AmountRequest,String status) {
		super();
		TypeEstate = typeEstate;
		RefRequest = refRequest;
		DateRequest = dateRequest;
		this.AmountRequest=AmountRequest;
		this.status=status;
	}
	public RealEstateRequest(Date dateRequest, String refRequest,int score) {
		super();

		RefRequest = refRequest;
		DateRequest = dateRequest;
		Score=score;
	}
	public RealEstateCredit getRealestatecredit() {
		return realestatecredit;
	}
	public void setRealestatecredit(RealEstateCredit realestatecredit) {
		this.realestatecredit = realestatecredit;
	}
	public User getUser1() {
		return user1;
	}
	public void setUser1(User user1) {
		this.user1 = user1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeEstate() {
		return TypeEstate;
	}
	public void setTypeEstate(String typeEstate) {
		TypeEstate = typeEstate;
	}
	public float getProjectValue() {
		return ProjectValue;
	}
	
	public String getPropretyDes() {
		return PropretyDes;
	}
	public void setPropretyDes(String propretyDes) {
		PropretyDes = propretyDes;
	}
	public String getPropretyNature() {
		return PropretyNature;
	}
	public void setPropretyNature(String propretyNature) {
		PropretyNature = propretyNature;
	}
	public String getPropretyAdress() {
		return PropretyAdress;
	}
	public void setPropretyAdress(String propretyAdress) {
		PropretyAdress = propretyAdress;
	}
	public float getLandArea() {
		return LandArea;
	}
	public void setLandArea(float landArea) {
		LandArea = landArea;
	}
	public Date getConstructionDate() {
		return ConstructionDate;
	}
	public void setConstructionDate(Date constructionDate) {
		ConstructionDate = constructionDate;
	}
	public String getSellerName() {
		return SellerName;
	}
	public void setSellerName(String sellerName) {
		SellerName = sellerName;
	}
	public float getCoveredArea() {
		return CoveredArea;
	}
	public void setCoveredArea(float coveredArea) {
		CoveredArea = coveredArea;
	}
	public int getGracePeriod() {
		return GracePeriod;
	}
	public void setGracePeriod(int gracePeriod) {
		GracePeriod = gracePeriod;
	}
	public int getDesiredPeriod() {
		return DesiredPeriod;
	}
	public void setDesiredPeriod(int desiredPeriod) {
		DesiredPeriod = desiredPeriod;
	}

	public int getAnotherCreditRemainingTime() {
		return anotherCreditRemainingTime;
	}
	public void setAnotherCreditRemainingTime(int anotherCreditRemainingTime) {
		this.anotherCreditRemainingTime = anotherCreditRemainingTime;
	}
	public float getAmountRequest() {
		return AmountRequest;
	}
	public void setAmountRequest(float amountRequest) {
		AmountRequest = amountRequest;
	}
	public float getAnotherCreditPayment() {
		return anotherCreditPayment;
	}
	public void setAnotherCreditPayment(float anotherCreditPayment) {
		this.anotherCreditPayment = anotherCreditPayment;
	}
	
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public RealEstateRequest() {
		super();
	}
	@Override
	public String toString() {
		return "RealEstateRequest [id=" + id + ", TypeEstate=" + TypeEstate + ", ProjectValue=" + ProjectValue
				+ ", PropretyDes=" + PropretyDes + ", status=" + status + ", Otherearning=" + Otherearning
				+ ", Otherloan=" + Otherloan + ", PropretyNature=" + PropretyNature + ", PropretyAdress="
				+ PropretyAdress + ", LandArea=" + LandArea + ", ConstructionDate=" + ConstructionDate + ", SellerName="
				+ SellerName + ", CoveredArea=" + CoveredArea + ", GracePeriod=" + GracePeriod + ", DesiredPeriod="
				+ DesiredPeriod + ", DurationContract=" + DurationContract + ", ID_Gurantor=" + ID_Gurantor
				+ ", ID_Gurantee=" + ID_Gurantee + ", Score=" + Score + ", Start_Date=" + Start_Date
				+ ", anotherCreditPayment=" + anotherCreditPayment + ", Frequency=" + Frequency + ", user1=" + user1
				+ ", anotherCreditRemainingTime=" + anotherCreditRemainingTime + ", AmountRequest=" + AmountRequest
				+ ", RefRequest=" + RefRequest + ", DateRequest=" + DateRequest + ", monthlypayment=" + monthlypayment
				+ ", amountInterst=" + amountInterst + "]";
	}

	



	
	
	
}