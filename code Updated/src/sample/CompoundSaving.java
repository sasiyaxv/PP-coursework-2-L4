package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.Global;

import java.io.*;
import java.text.DecimalFormat;

public class CompoundSaving {
    public static void display(){

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        //Compound Savings Calculations Setup

        Stage window = new Stage();
        window.setTitle("Compound savings");

        GridPane compoundSavingsGrid = new GridPane();
        compoundSavingsGrid.setId("compoundSavingsGrid");

        Scene compoundSaveScene = new Scene(compoundSavingsGrid,  1280, 960);

        Label timeinYearsLblC = new Label("Time in Years ");
        Label interestRateLblC = new Label("Interest Rate (%)");
        Label presentValueLblC = new Label("Present Value (£)");
        Label paymentLblC = new Label("Payment (£)");
        Label futureValueLblC = new Label("Future Value (£)");


        TextField timeYearsTxtC = new TextField();
        TextField interestRateTxtC = new TextField();
        TextField presentValueTxtC = new TextField();
        TextField paymentTxtC = new TextField();
        TextField futureValueTxtC = new TextField();

        Button calculateSavingBtnC = new Button("Calculate");
        Button backSavingBtnC = new Button("Back");
        calculateSavingBtnC.setId("calculateSavingBtn");
        backSavingBtnC.setId("goBackBtn");

        compoundSavingsGrid.setHgap(30);
        compoundSavingsGrid.setVgap(30);

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


        compoundSavingsGrid.getChildren().addAll(simpleBtn,compoundBtn,loanBtn,mortgageBtn,timeinYearsLblC, interestRateLblC, presentValueLblC, paymentLblC, futureValueLblC,  timeYearsTxtC, interestRateTxtC, presentValueTxtC, paymentTxtC, futureValueTxtC, calculateSavingBtnC, backSavingBtnC);
        GridPane.setConstraints(timeinYearsLblC, 1, 3);
        GridPane.setConstraints(interestRateLblC, 1, 4);
        GridPane.setConstraints(presentValueLblC, 1, 5);
        GridPane.setConstraints(paymentLblC, 1, 6);

        GridPane.setConstraints(simpleBtn, 4, 1);
        GridPane.setConstraints(compoundBtn, 5, 1);
        GridPane.setConstraints(loanBtn, 6, 1);
        GridPane.setConstraints(mortgageBtn, 7, 1);

        compoundSavingsGrid.add(Calculator.display(),4,3,5,5);

        GridPane.setConstraints(futureValueLblC, 1, 7);
        GridPane.setConstraints(timeYearsTxtC, 2, 3);
        GridPane.setConstraints(interestRateTxtC, 2, 4);
        GridPane.setConstraints(presentValueTxtC, 2, 5);
        GridPane.setConstraints(paymentTxtC, 2, 6);
        GridPane.setConstraints(futureValueTxtC, 2, 7);
        GridPane.setConstraints(backSavingBtnC, 1, 1);
        GridPane.setConstraints(calculateSavingBtnC, 1, 10);


        window.setScene(compoundSaveScene);
        window.show();



        backSavingBtnC.setOnAction(e -> {

            window.close();
            SavingMenu.display();


        });

        //--------------------Writing userdata to a file---------------------------------
        File userData = new File("CompoundSavings.txt");
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(userData,true);
            pw = new PrintWriter(fw,true);
            pw.println("==== Compound Savings ====");
            pw.println("Saved data from previous calculation");

        }catch (FileNotFoundException e){
            System.out.print("File not found.");
        }catch (IOException e){
            System.out.print("Cant write to the file. No permission.");
        }




        //-------------------------------------------------------------------------------

        PrintWriter finalPw = pw;
        calculateSavingBtnC.setOnAction(e -> {

            if (InputValidation.checkAll(timeYearsTxtC, interestRateTxtC, presentValueTxtC, futureValueTxtC,paymentTxtC) > 1) {
                InputValidation.inputMissing();
            }
            else if (InputValidation.tooManyInput(timeYearsTxtC, interestRateTxtC, presentValueTxtC, futureValueTxtC,paymentTxtC)==5){
                InputValidation.allFieldsFilled();
            }

            if(timeYearsTxtC.getText().trim().isEmpty() && InputValidation.checkAll(timeYearsTxtC, interestRateTxtC, presentValueTxtC, futureValueTxtC,paymentTxtC) == 1){

                double interestRate = Double.parseDouble(interestRateTxtC.getText());
                double presentValue = Double.parseDouble(presentValueTxtC.getText());
                double payment = Double.parseDouble(paymentTxtC.getText());
                double futureValue = Double.parseDouble(futureValueTxtC.getText());
              // double years =

            }

            if(futureValueTxtC.getText().trim().isEmpty() && InputValidation.checkAll(timeYearsTxtC, interestRateTxtC, presentValueTxtC, futureValueTxtC,paymentTxtC) == 1){

                double interestRate = Double.parseDouble(interestRateTxtC.getText());
                double presentValue = Double.parseDouble(presentValueTxtC.getText());
                double payment = Double.parseDouble(paymentTxtC.getText());
                double years = Double.parseDouble(timeYearsTxtC.getText());
                double futureValue = presentValue * ( Math.pow( 1+ (interestRate/100 / 12), (12 * years)))+payment*((Math.pow(1+((interestRate/100)/12),12*years)-1)/(years/12));
                String futureValueNew = decimalFormat.format(futureValue);
                futureValueTxtC.setText(Double.toString(Double.parseDouble(futureValueNew)));

                //--------------------Writing userdata to a file---------------------------------
                finalPw.println("present Value = "+presentValueTxtC.getText());
                finalPw.println("Years = "+timeYearsTxtC.getText());
                finalPw.println("Interest Rate = "+interestRateTxtC.getText());
                finalPw.println("future Value = "+futureValueTxtC.getText());
                finalPw.println("future Value = "+paymentTxtC.getText());
                finalPw.println();
                finalPw.close();
                //-------------------------------------------------------------------------------

            }

            if(paymentTxtC.getText().trim().isEmpty() && InputValidation.checkAll(timeYearsTxtC, interestRateTxtC, presentValueTxtC, futureValueTxtC,paymentTxtC) == 1){

                double interestRate = Double.parseDouble(interestRateTxtC.getText());
                double years = Double.parseDouble(timeYearsTxtC.getText());
                double futureValue = Double.parseDouble(futureValueTxtC.getText());
                double payment = (futureValue-Math.pow(1+(interestRate/100)/12,12*years))/(Math.pow(1+(interestRate/100)/12,12*years)-1)/(interestRate/100)/12;
                String paymentNew = decimalFormat.format(payment);
                paymentTxtC.setText(Double.toString(Double.parseDouble(paymentNew)));

                //--------------------Writing userdata to a file---------------------------------
                finalPw.println("present Value = "+presentValueTxtC.getText());
                finalPw.println("Years = "+timeYearsTxtC.getText());
                finalPw.println("Interest Rate = "+interestRateTxtC.getText());
                finalPw.println("future Value = "+futureValueTxtC.getText());
                finalPw.println("future Value = "+paymentTxtC.getText());
                finalPw.println();
                finalPw.close();
                //-------------------------------------------------------------------------------

            }
            if(presentValueTxtC.getText().trim().isEmpty() && InputValidation.checkAll(timeYearsTxtC, interestRateTxtC, presentValueTxtC, futureValueTxtC,paymentTxtC) == 1){

                double interestRate = Double.parseDouble(interestRateTxtC.getText());
                double years = Double.parseDouble(timeYearsTxtC.getText());
                double payment = Double.parseDouble(paymentTxtC.getText());
                double futureValue = Double.parseDouble(futureValueTxtC.getText());
                double presentValue =futureValue-payment* (((Math.pow(1+(interestRate/100)/12,12*years)-1)/(interestRate/100)/12))/Math.pow(1+(interestRate/100)/12,12*years);
                presentValueTxtC.setText(Double.toString(Double.parseDouble(decimalFormat.format(presentValue))));

                //--------------------Writing userdata to a file---------------------------------
                finalPw.println("present Value = "+presentValueTxtC.getText());
                finalPw.println("Years = "+timeYearsTxtC.getText());
                finalPw.println("Interest Rate = "+interestRateTxtC.getText());
                finalPw.println("future Value = "+futureValueTxtC.getText());
                finalPw.println("future Value = "+paymentTxtC.getText());
                finalPw.println();
                finalPw.close();
                //-------------------------------------------------------------------------------

            }

            if(interestRateTxtC.getText().trim().isEmpty() && InputValidation.checkAll(timeYearsTxtC, interestRateTxtC, presentValueTxtC, futureValueTxtC,paymentTxtC) == 1){

                double futureValue = Double.parseDouble(futureValueTxtC.getText());
                double presentValue = Double.parseDouble(presentValueTxtC.getText());
                double years = Double.parseDouble(timeYearsTxtC.getText());
                double interestRate = (12*(Math.pow(futureValue/presentValue,1/(12*years))-1))*100;
                interestRateTxtC.setText(Double.toString(Double.parseDouble(decimalFormat.format(interestRate))));

                //--------------------Writing userdata to a file---------------------------------
                finalPw.println("present Value = "+presentValueTxtC.getText());
                finalPw.println("Years = "+timeYearsTxtC.getText());
                finalPw.println("Interest Rate = "+interestRateTxtC.getText());
                finalPw.println("future Value = "+futureValueTxtC.getText());
                finalPw.println("future Value = "+paymentTxtC.getText());
                finalPw.println();
                finalPw.close();
                //-------------------------------------------------------------------------------

            }


        });


        //--------------------------- StyleSheets----------------------------------
         compoundSaveScene.getStylesheets().add(CompoundSaving.class.getResource("stylesheets/Compoundsavings.css").toExternalForm());
        compoundSaveScene.getStylesheets().add(SimpleSaving.class.getResource("stylesheets/Quicknavigation.css").toExternalForm());



    }
}
