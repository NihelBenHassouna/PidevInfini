package Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RealEstateCredit")
public class RealEstateCredit extends Loan {

	private static final long serialVersionUID = 1L;
	@OneToOne
	RealEstateRequest EstateRequest;

	@Override
	public String toString() {
		return "RealEstateCredit [EstateRequest=" + EstateRequest + ", id=" + id + ", LoanSum=" + LoanSum
				+ ", Duration=" + Duration + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", InterestRate="
				+ InterestRate + ", FileExpenses=" + FileExpenses + ", RefundMode=" + RefundMode + ", GracePeriod="
				+ GracePeriod + "]";
	}

	public RealEstateRequest getEstateRequest() {
		return EstateRequest;
	}

	public void setEstateRequest(RealEstateRequest estateRequest) {
		EstateRequest = estateRequest;
	}

	public RealEstateCredit() {

	}

	public RealEstateCredit(int id, Date startDate, String refundMode, float loanSum, int duration,
			float frequencyAmount) {
		this.id=id;
		this.StartDate=startDate;
		this.RefundMode=refundMode;
		this.LoanSum=loanSum;
		this.Duration=duration;
		this.FrequencyAmount=frequencyAmount;
	}

}
