package app.controller;

import app.StudentCalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pkgLogic.Loan;
import pkgLogic.Payment;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

public class LoanCalcViewController implements Initializable {

	private StudentCalc SC = null;

	@FXML
	private TextField LoanAmount;

	@FXML
	private TextField InterestRate;

	@FXML
	private TextField NbrOfYears;

	@FXML
	private TextField AddPMT;

	@FXML
	private DatePicker PaymentStartDate;

	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private Label lblTotalInterest;

	@FXML
	private TableView<Payment> tvResults;

	@FXML
	private TableColumn<Payment, Integer> colPaymentNumber;

	@FXML
	private TableColumn<Payment, Double> colInterest;

	@FXML
	private TableColumn<Payment, Double> colPrinciple;

	@FXML
	private TableColumn<Payment, Double> colBalance;

	@FXML
	private TableColumn<Payment, Double> colPMT;

	@FXML
	private TableColumn<Payment, Double> colAddPMT;

	@FXML
	private TableColumn<Payment, Calendar> colDueDate;

	private ObservableList<Payment> paymentList = FXCollections.observableArrayList();;

	// TODO: Account for all the other columns
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		colPaymentNumber.setCellValueFactory(new PropertyValueFactory<>("PaymentNbr"));
		colInterest.setCellValueFactory(new PropertyValueFactory<>("Interest"));
		colPrinciple.setCellValueFactory(new PropertyValueFactory<>("Principle"));
		colBalance.setCellValueFactory(new PropertyValueFactory<>("Balance"));
		colPMT.setCellValueFactory(new PropertyValueFactory<>("PMT"));
		colAddPMT.setCellValueFactory(new PropertyValueFactory<>("AddPMT"));
		colDueDate.setCellValueFactory(new PropertyValueFactory<>("DueDate"));

	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}

	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {
		
		tvResults.getItems().clear();
		lblTotalPayemnts.setText("");
		lblTotalInterest.setText("");
		
		
		//Stage stage = (Stage) tvResults.getScene().getWindow();

		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		double dAddPMT = Double.parseDouble(AddPMT.getText());
		double dInterestRate = Double.parseDouble(InterestRate.getText());
		int iTerm = Integer.parseInt(NbrOfYears.getText());
		LocalDate localDate = PaymentStartDate.getValue();		
		Calendar c = (Calendar) Calendar.getInstance();
		c.set(Calendar.MONTH, localDate.getMonthValue());
		c.set(Calendar.YEAR, localDate.getYear());
		c.set(Calendar.DAY_OF_MONTH, localDate.getDayOfMonth());

		
		tvResults.getColumns().setAll(colPaymentNumber,colDueDate,colPMT,colAddPMT,colInterest,colPrinciple,colBalance);


		Loan loan = new Loan(dInterestRate, iTerm, c, dAddPMT, dLoanAmount);
		loan.setPayments(loan.autoPayments());
		
		lblTotalPayemnts.setText(Integer.toString(loan.getPayments().size()));
		lblTotalInterest.setText(Double.toString(loan.totalInterest(loan.getPayments())));
				
		paymentList= FXCollections.observableArrayList(loan.getPayments());
		
		tvResults.setItems(paymentList);
		



		/*
		 * When this button is clicked, you need to do the following:
		 * 
		 * 1) Clear the table 2) Clear the results fields (Total Payments, Total
		 * Interest) 3) You're going to create 'n' payments based on the data you give.
		 * You'll calculate and carry forward 'balance', because you're going to have to
		 * hand calculate that month's interest. Payment# - you'll set this, counting
		 * from 1 to N Due Date - based on the given date. method .plusMonths(1) will
		 * calculate date + 1 month. Payment - Calculate based on PMT function (which is
		 * your minimum payment) Additional Payment - based on Additional Payment given
		 * by user Interest - Calculate based on
		 */

	}

}
