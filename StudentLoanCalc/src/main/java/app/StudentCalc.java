package app;

import java.io.IOException;

import app.controller.LoanCalcViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pkgLogic.Loan;

public class StudentCalc extends Application {

	private Stage primaryStage;
	
	private BorderPane LoanScreen = null;
	
	private LoanCalcViewController LCVC = null;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		ShowScreen();
		
	}
	
	public void ShowScreen() {
		// Parent root;
		try {

			FXMLLoader loader = new FXMLLoader();
			loader = new FXMLLoader(getClass()
					.getResource("/app/view/LoanCalcView.fxml"));
			LoanScreen = (BorderPane) loader.load();
			Scene scene = new Scene(LoanScreen);
			
			primaryStage.setScene(scene);
			
			//scene.getStylesheets().add("/src/main/resources/stylesheet.css");
			scene.getStylesheets().add(getClass().getResource("/app/view/stylesheet.css").toExternalForm());
			LCVC = loader.getController();
			LCVC.setMainApp(this);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
