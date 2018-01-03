package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean
public class DiscountBean {
	private double amount, rate, discount;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getDiscount() {
		return discount;
	}

	
	public void calculate(ActionEvent evt) {
		this.discount = this.amount * this.rate / 100; 
	}

}
