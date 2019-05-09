package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
@DiscriminatorValue(value="Customer")
public class Customer extends User{

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="customer")
	private List<Claim> claims= new ArrayList<>();
	
	public List<Claim> getClaims() {
		return claims;
	}
	public void setClaims(List<Claim> claims) {
		this.claims = claims ;
	}

	public Customer() {
		super();
	}
	
	@Override
	public String toString() {
		return "Customer [claims=" + claims + "]";
	}
	
}
	
