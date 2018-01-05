package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
public class DiscountBean {

	private double amount, rate, discount;

	public DiscountBean() {
		System.out.println("DiscountBean()");
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		System.out.println("setAmount()");
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
		System.out.println("Calculate()");
		this.discount = this.amount * this.rate / 100;
	}

	public void changed(ValueChangeEvent evt) {
		System.out.println("Amount Changed  to :" + evt.getNewValue());

	}

	public void cancel(ActionEvent evt) {
		System.out.println("cancel()");
	}

}
