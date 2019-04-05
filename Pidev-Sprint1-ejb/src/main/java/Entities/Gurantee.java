package Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Guarantee")
public class Gurantee implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column	(name="Guarantee_id")
	private int id;
	@Column(name="GuaranteeValue")
	private  float value;
	@Column(name="GuaranteeType")
	private String Type;
	@Column(name="GuaranteeAddress")
	String address;
	@Column(name="GuaranteeNmber")
	String number;
	@Column(name="CarModel")
	String model;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}


	@Override
	public String toString() {
		return "Gurantee [id=" + id + ", value=" + value + ", Type=" + Type + ", address=" + address + ", number="
				+ number + ", model=" + model + "]";
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}


}
