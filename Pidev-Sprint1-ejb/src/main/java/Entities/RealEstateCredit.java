package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "RealEstateCreditCredit")
public class RealEstateCredit extends Loan{

	private static final long serialVersionUID = 1L;
	@Column(name="typeRealestate")
	@Enumerated(EnumType.STRING)
	private RealEstateCreditCategories typeRealestate;
	public RealEstateCreditCategories getTypeRealestate() {
		return typeRealestate;
	}
	public void setTypeRealestate(RealEstateCreditCategories typeRealestate) {
		this.typeRealestate = typeRealestate;
	}
	public RealEstateCredit(RealEstateCreditCategories typeRealestate) {
		super();
		this.typeRealestate = typeRealestate;
	}
	public RealEstateCredit() {
		super();
	}
	@Override
	public String toString() {
		return "RealEstateCredit [typeRealestate=" + typeRealestate + ", toString()=" + super.toString() + ", getId()="
				+ getId() + ", getLoanSum()=" + getLoanSum() + ", getDuration()=" + getDuration() + ", getStartDate()="
				+ getStartDate() + ", getEndDate()=" + getEndDate() + ", getInterestRate()=" + getInterestRate()
				+ ", getFileExpenses()=" + getFileExpenses() + ", getRefundMode()=" + getRefundMode()
				+ ", getFrequencyAmount()=" + getFrequencyAmount() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
	

}
