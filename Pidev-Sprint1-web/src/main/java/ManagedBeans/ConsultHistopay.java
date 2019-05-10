package ManagedBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Customer;
import Entities.MicroCredit;
import Entities.MicrocreditPayment;
import Services.microcreditService;

@ManagedBean(name = "histopayBean") 
@SessionScoped
public class ConsultHistopay implements Serializable{
	
	private Double amountpay;
	private Date datepay;
	private Double amountpaid;
	private Double amounttopay;
	private static final long serialVersionUID = 1L;
	@EJB
	microcreditService microcredService;
	
	int id=10;
	Customer user;
	MicroCredit micro;
	List<MicrocreditPayment> micropay;
	public ConsultHistopay() {

	}
	public Double getAmountpay() {
		return amountpay;
	}
	public void setAmountpay(Double amountpay) {
		this.amountpay = amountpay;
	}
	public Date getDatepay() {
		return datepay;
	}
	public void setDatepay(Date datepay) {
		this.datepay = datepay;
	}
	public microcreditService getMicrocredService() {
		return microcredService;
	}
	public void setMicrocredService(microcreditService microcredService) {
		this.microcredService = microcredService;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getUser() {

		return user;
	}
	public void setUser(Customer user) {
		this.user = user;
	}
	public MicroCredit getMicro() {

		return micro;
	}
	public void setMicro(MicroCredit micro) {
		this.micro = micro;
	}
	public List<MicrocreditPayment> getMicropay() {
		user=microcredService.getCustomerById(id);
		micro=microcredService.getMicrocrecitByCustomerCin(user);

		micropay=microcredService.getMicrocrecitPayByMicrocredit(micro);

		return micropay;
	}
	public void setMicropay(List<MicrocreditPayment> micropay) {
		this.micropay = micropay;
	}
	public Double getAmountpaid() {
		user=microcredService.getCustomerById(id);
		micro=microcredService.getMicrocrecitByCustomerCin(user);
		amountpaid=micro.getAmountPaid();
		return amountpaid;
	}
	public void setAmountpaid(Double amountpaid) {
		this.amountpaid = amountpaid;
	}
	public Double getAmounttopay() {
		user=microcredService.getCustomerById(id);
		micro=microcredService.getMicrocrecitByCustomerCin(user);
		amounttopay=micro.getTotalAmount();
		return amounttopay;
	}
	public void setAmounttopay(Double amounttopay) {
		this.amounttopay = amounttopay;
	}
	
	
	
		
		
		
		
	
	
	
	
	
	
}
