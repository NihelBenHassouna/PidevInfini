package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
@Entity
@Table(name="MicroCredit")
public class MicroCredit extends Loan{
	
	private static final long serialVersionUID = 1L;
	@Column(name="typeCredit")
	@Enumerated(EnumType.STRING)
	private MicroCreditCategories typeCredit;
	public MicroCreditCategories getTypeCredit() {
		return typeCredit;
	}
	public void setTypeCredit(MicroCreditCategories typeCredit) {
		this.typeCredit = typeCredit;
	}
	public MicroCredit(MicroCreditCategories typeCredit) {
		super();
		this.typeCredit = typeCredit;
	}
	public MicroCredit() {
		super();
	}
	@Override
	public String toString() {
		return "MicroCredit [typeCredit=" + typeCredit + ", toString()=" + super.toString() + ", getId()=" + getId()
				+ ", getLoanSum()=" + getLoanSum() + ", getDuration()=" + getDuration() + ", getStartDate()="
				+ getStartDate() + ", getEndDate()=" + getEndDate() + ", getInterestRate()=" + getInterestRate()
				+ ", getFileExpenses()=" + getFileExpenses() + ", getRefundMode()=" + getRefundMode()
				+ ", getFrequencyAmount()=" + getFrequencyAmount() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
	
}
