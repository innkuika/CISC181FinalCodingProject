package pkgLogic;

import java.util.Calendar;
import java.util.Date;

public class Payment extends Loan {
	

	private int PaymentNbr;
	private double Interest;
	private Calendar DueDate;
	private double Principle;
	private double Balance; //Beginning balance

	
	//TODO: Fix the constructor, add the fields you've added.
	public Payment(int paymentNbr, Calendar dueDate, double balance) {
		super();
		PaymentNbr = paymentNbr;
		DueDate = dueDate;
		Balance = balance;
		Interest = Balance* super.getInterestRate()/12;
		Principle = super.getPMT() - Interest + super.getAddPMT();	
	}
	
	public double getInterest() {
		return Interest;
	}

	public void setInterest(double interest) {
		Interest = interest;
	}

	public Calendar getDueDate() {
		return DueDate;
	}

	public void setDueDate(Calendar dueDate) {
		DueDate = dueDate;
	}

	public double getPrinciple() {
		return Principle;
	}

	public void setPrinciple(double principle) {
		Principle = principle;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}	

	public int getPaymentNbr() {
		return PaymentNbr;
	}

	public void setPaymentNbr(int paymentNbr) {
		PaymentNbr = paymentNbr;
	}
	

}
