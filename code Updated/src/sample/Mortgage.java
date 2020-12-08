package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.text.DecimalFormat;

public class Mortgage {
    public static void display(){

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Stage window = new Stage();

        window.setTitle("Mortgage");


        //Mortgage Calculations
        GridPane mortgageGrid = new GridPane();
        mortgageGrid.setId("mortgageGrid");

        Scene mortgageScene = new Scene(mortgageGrid, 1280, 960);

        Label homepriceLblM = new Label("Home Price (£)");
        Label downpaymentLblM = new Label("Down Payment (£)");
        Label loantermLblM = new Label("Loan Term (£)");
        Label interestRateLblM = new Label("Interest Rate (%)");

        Label propertyTaxesLblM = new Label("Property Taxes (£)");
        Label homeInsuranceLblM = new Label("Home Insurance (£)");
        Label pmiInsuranceLblM = new Label("PMI Insurance (£)");




        TextField homepriceTxtM = new TextField();
        TextField downpaymentTxtM = new TextField();
        TextField loantermTxtM = new TextField();
        TextField interestRateTxtM = new TextField();

        TextField propertyTaxesTxtM = new TextField();
        TextField homeInsuranceTxtM = new TextField();
        TextField pmiInsuranceTxtM = new TextField();




        mortgageGrid.setHgap(30);
        mortgageGrid.setVgap(30);

        //Top toolbar to navigate through options easily ---------------
        Button simpleBtn = new Button("Simple");
        simpleBtn.setId("quickNav");
        Button compoundBtn = new Button("Compound");
        compoundBtn.setId("quickNav");
        Button loanBtn = new Button("Loan");
        loanBtn.setId("quickNav");
        Button mortgageBtn = new Button("Mortgage");
        mortgageBtn.setId("quickNav");

        simpleBtn.setOnAction(e -> {
            window.close();
            try {
                SimpleSaving.display();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        compoundBtn.setOnAction(e -> {
            window.close();
            CompoundSaving.display();
        });
        loanBtn.setOnAction(e -> {
            window.close();
            AutoLoan.display();
        });
        mortgageBtn.setOnAction(e -> {
            window.close();
            Mortgage.display();
        });
        //-------------------------------------------------------------------


        Button calculateMortgage = new Button("Calculate");
        Button backMortgageBtn = new Button("Back");
        backMortgageBtn.setId("gobackBtn");
        calculateMortgage.setId("mortgageBtn");



        mortgageGrid.getChildren().addAll(simpleBtn,compoundBtn,loanBtn,mortgageBtn,homepriceLblM,downpaymentLblM,loantermLblM,interestRateLblM,propertyTaxesLblM,homeInsuranceLblM,pmiInsuranceLblM,homepriceTxtM,downpaymentTxtM,loantermTxtM,interestRateTxtM,propertyTaxesTxtM,homeInsuranceTxtM,pmiInsuranceTxtM,calculateMortgage,backMortgageBtn);

        GridPane.setConstraints(homepriceLblM, 1, 2);
        GridPane.setConstraints(downpaymentLblM, 1, 3);
        GridPane.setConstraints(loantermLblM, 1, 4);
        GridPane.setConstraints(interestRateLblM, 1, 5);
        GridPane.setConstraints(propertyTaxesLblM, 1, 7);
        GridPane.setConstraints(homeInsuranceLblM, 1, 8);
        GridPane.setConstraints(pmiInsuranceLblM, 1, 9);

        GridPane.setConstraints(simpleBtn, 4, 1);
        GridPane.setConstraints(compoundBtn, 5, 1);
        GridPane.setConstraints(loanBtn, 6, 1);
        GridPane.setConstraints(mortgageBtn, 7, 1);

        mortgageGrid.add(Calculator.display(),4,3,5,5);


        GridPane.setConstraints(homepriceTxtM, 2, 2);
        GridPane.setConstraints(downpaymentTxtM, 2, 3);
        GridPane.setConstraints(loantermTxtM, 2, 4);
        GridPane.setConstraints(interestRateTxtM, 2, 5);
        GridPane.setConstraints(propertyTaxesTxtM, 2, 7);
        GridPane.setConstraints(homeInsuranceTxtM, 2, 8);
        GridPane.setConstraints(pmiInsuranceTxtM, 2, 9);



        GridPane.setConstraints(calculateMortgage, 1, 12);
        GridPane.setConstraints(backMortgageBtn, 1, 1);

        window.setScene(mortgageScene);
        window.show();



        backMortgageBtn.setOnAction(e -> {
            window.close();
            HomePage.display();
        });

        //--------------------------- StyleSheets----------------------------------
        mortgageScene.getStylesheets().add(Mortgage.class.getResource("stylesheets/Mortgagecalculation.css").toExternalForm());
        mortgageScene.getStylesheets().add(SimpleSaving.class.getResource("stylesheets/Quicknavigation.css").toExternalForm());
    }

}
