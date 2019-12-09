package pkgUT;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.junit.jupiter.api.Test;

import pkgLogic.Loan;

public class Test1 {
	@Test
	public void TestLoan(){

		double r = 0.04;
		int n = 1 ;
		double p = 5000;

		double apmt = 0;
		
		Calendar c = Calendar.getInstance();
		c.set(19, 12, 9);
		
		Loan l = new Loan(r,n,c,apmt,p);
		
		double PMTExpected = 425.75;	
		assertEquals(PMTExpected, l.getPMT(), 0.01);
		
		assertEquals(1, l.getPayments().get(0).getPaymentNbr());
		
		double Balance1Expected = 4590.92;
		assertEquals(Balance1Expected, l.getPayments().get(0).getPrinciple(), 0.01);
		
	}

}
