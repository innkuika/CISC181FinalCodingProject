package pkgLogic;

import java.util.Date;

public class Payment extends Loan {
	
	//TODO: I've accounted for PaymentNbr, you need to add all the other fields for the class
	private int PaymentNbr;
	private double Interest;
	private Date DueDate;
	private double Principle;
	private double Balance;

	
	//TODO: Fix the constructor, add the fields you've added.
	public Payment(int paymentNbr) {
		super();
		PaymentNbr = paymentNbr;
	}

	public int getPaymentNbr() {
		return PaymentNbr;
	}

	public void setPaymentNbr(int paymentNbr) {
		PaymentNbr = paymentNbr;
	}
	
	//TODO: Add getters and setters for new fields.	
}
