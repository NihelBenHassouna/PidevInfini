package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Agent")
@DiscriminatorValue(value="Agent")
public class Agent extends User {
	private static final long serialVersionUID = 1L;

	@Column(name="Bonus")
	private Double Bonus ;
	
	@OneToMany(mappedBy="agent")
	private List<Claim> claims = new ArrayList<>();

	public Double getBonus() {
		return Bonus;
	}
	public void setBonus(Double bonus) {
		Bonus = bonus;
	}
	public List<Claim> getClaims() {
		return claims;
	}
	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}
	
	public Agent() {
		super();
	}
	public Agent(Double bonus) {
		super();
		Bonus = bonus;
	}
	@Override
	public String toString() {
		return "Agent [Bonus=" + Bonus + ", claims=" + claims + "]";
	}
	

}
