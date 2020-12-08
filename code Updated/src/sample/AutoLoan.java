package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.text.DecimalFormat;

public class AutoLoan {

    public static void display(){

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Stage window = new Stage();
        window.setTitle("Auto Loan");

        //Loans Calculations Setup
        GridPane loanGrid = new GridPane();
        loanGrid.setId("loanGrid");

        Scene loanScene = new Scene(loanGrid,  1280, 960);

        Label autoPriceLblL = new Label("Auto Price (£) ");
        Label loanTermLblL = new Label("Loan Term (£)");
        Label interestRateLblL = new Label("Interest Rate (%)");
        Label paymentLblL = new Label("Down Payment (£)");
        Label tradeValueLblL = new Label("Trade Value (£)");

        TextField autoPriceTxtL = new TextField();
        TextField loanTermTxtL = new TextField();
        TextField interestRateTxtL = new TextField();
        TextField paymentTxtL = new TextField();
        TextField tradeValueTxtL = new TextField();

        Button calculateLoanBtn = new Button("Calculate");
        Button backloanBtnL = new Button("Back");
        backloanBtnL.setId("gobackBtn");
        calculateLoanBtn.setId("loanBtn");




        loanGrid.setHgap(30);
        loanGrid.setVgap(30);

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


        loanGrid.getChildren().addAll(simpleBtn,compoundBtn,loanBtn,mortgageBtn,autoPriceLblL,loanTermLblL,interestRateLblL,paymentLblL,tradeValueLblL,autoPriceTxtL,loanTermTxtL,interestRateTxtL,paymentTxtL,tradeValueTxtL,calculateLoanBtn,backloanBtnL);
        GridPane.setConstraints(autoPriceLblL, 1, 3);
        GridPane.setConstraints(loanTermLblL, 1, 4);
        GridPane.setConstraints(interestRateLblL, 1, 5);
        GridPane.setConstraints(paymentLblL, 1, 6);
        GridPane.setConstraints(tradeValueLblL, 1, 7);

        GridPane.setConstraints(simpleBtn, 4, 1);
        GridPane.setConstraints(compoundBtn, 5, 1);
        GridPane.setConstraints(loanBtn, 6, 1);
        GridPane.setConstraints(mortgageBtn, 7, 1);

        loanGrid.add(Calculator.display(),4,3,5,5);

        GridPane.setConstraints(autoPriceTxtL, 2, 3);
        GridPane.setConstraints(loanTermTxtL, 2, 4);
        GridPane.setConstraints(interestRateTxtL, 2, 5);
        GridPane.setConstraints(paymentTxtL, 2, 6);
        GridPane.setConstraints(tradeValueTxtL, 2, 7);

        GridPane.setConstraints(backloanBtnL, 1, 1);
        GridPane.setConstraints(calculateLoanBtn, 1, 10);


        window.setScene(loanScene);
        window.show();



        backloanBtnL.setOnAction(e -> {

            window.close();
            HomePage.display();


        });

        calculateLoanBtn.setOnAction(e -> {

            if (autoPriceTxtL.getText().trim().isEmpty() && loanTermTxtL.getText().trim().isEmpty() && interestRateTxtL.getText().trim().isEmpty() && paymentTxtL.getText().trim().isEmpty() && tradeValueTxtL.getText().trim().isEmpty() ){
                InputValidation.inputMissing();
            }
        });

        //--------------------------- StyleSheets----------------------------------
         loanScene.getStylesheets().add(AutoLoan.class.getResource("stylesheets/Loancalculations.css").toExternalForm());
        loanScene.getStylesheets().add(SimpleSaving.class.getResource("stylesheets/Quicknavigation.css").toExternalForm());

    }
}
