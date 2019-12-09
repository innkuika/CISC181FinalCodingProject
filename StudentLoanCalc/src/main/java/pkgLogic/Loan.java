package pkgLogic;

import java.util.ArrayList;
import java.util.Calendar;
import org.apache.poi.ss.formula.functions.*;

public class Loan {

	private double InterestRate;
	private double PMT; 
	private int Term;
	private Calendar FirstPMTDate;
	private double AddPMT;
	private double LoanAmount;
	private ArrayList<Payment> Payments;
	
	public Loan() {
		
	}
	
	public Loan(double interestRate,int term,Calendar firstPMTDate,double addPMT,double loanAmount) {
		InterestRate = interestRate;
		Term = term;
		FirstPMTDate = firstPMTDate;
		AddPMT = addPMT;
		LoanAmount = loanAmount;
		PMT = Math.abs(FinanceLib.pmt(InterestRate/12, Term*12, LoanAmount, 0, false));
		Payments = autoPayments();
		
		
		
	}
	
	public ArrayList<Payment> autoPayments(){
		int i = 1;
		Calendar d = FirstPMTDate;
		double b = LoanAmount;
		
		ArrayList<Payment> payments = new ArrayList<Payment>();
		Payment p1 = new Payment(i,d,b);
		
		payments.add(p1);
		while((PMT + AddPMT) < p1.getBalance()) {
			i += 1;
			d.add(Calendar.MONTH, 1);
			b = b - PMT - AddPMT;
			Payment p2 = new Payment(i,d,b);
			payments.add(p2);
			p1 = p2;
		}
		
		return payments;
	}
	
	
	
	
	public double getInterestRate() {
		return InterestRate;
	}
	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}
	public double getPMT() {
		return PMT;
	}
	public void setPMT(double pMT) {
		PMT = pMT;
	}
	public int getTerm() {
		return Term;
	}
	public void setTerm(int term) {
		Term = term;
	}
	public Calendar getFirstPMTDate() {
		return FirstPMTDate;
	}
	public void setFirstPMTDate(Calendar firstPMTDate) {
		FirstPMTDate = firstPMTDate;
	}
	public double getAddPMT() {
		return AddPMT;
	}
	public void setAddPMT(double addPMT) {
		AddPMT = addPMT;
	}
	public double getLoanAmount() {
		return LoanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		LoanAmount = loanAmount;
	}
	public ArrayList<Payment> getPayments() {
		return Payments;
	}
	public void setPayments(ArrayList<Payment> payments) {
		Payments = payments;
	}
	
	
}
