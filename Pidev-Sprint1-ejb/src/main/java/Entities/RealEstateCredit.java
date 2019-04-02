package Entities;



import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RealEstateCredit")
public class RealEstateCredit extends Loan{

	private static final long serialVersionUID = 1L;
	@OneToOne
	RealEstateRequest EstateRequest;
	
  @Override
	public String toString() {
		return "RealEstateCredit [EstateRequest=" + EstateRequest + ", id=" + id + ", LoanSum=" + LoanSum
				+ ", Duration=" + Duration + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", InterestRate="
				+ InterestRate + ", FileExpenses=" + FileExpenses + ", RefundMode=" + RefundMode + ", GracePeriod="
				+ GracePeriod + ", guarantor=" + guarantor + ", gurantee=" + gurantee + "]";
	}
public RealEstateRequest getEstateRequest() {
		return EstateRequest;
	}
	public void setEstateRequest(RealEstateRequest estateRequest) {
		EstateRequest = estateRequest;
	}
public RealEstateCredit()
  {
	  
  }

	
}
	
