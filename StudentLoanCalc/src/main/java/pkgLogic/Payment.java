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
	public Payment(int paymentNbr, Calendar dueDate, double balance,double interestRate,int term,Calendar firstPMTDate,double addPMT,double loanAmount) {
		super(interestRate, term,firstPMTDate, addPMT, loanAmount);
		this.PaymentNbr = paymentNbr;
		this.DueDate = dueDate;
		this.Balance = balance;
		this.Interest = balance* this.getInterestRate()/12;
		this.Principle = super.getPMT() - balance* this.getInterestRate()/12 + super.getAddPMT();	
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
