package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.*;
import java.text.DecimalFormat;

public class SimpleSaving {

    public static void display() throws IOException {



        // Setting the decimal format
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Stage window = new Stage();
        window.setTitle("simple Savings");

        GridPane simpleSavingsGrid = new GridPane();
        simpleSavingsGrid.setId("simpleSavingMenu");
        Scene simpleSaveScene = new Scene(simpleSavingsGrid,  1280, 960);

        window.setScene(simpleSaveScene);
        window.show();

        Label timeinYearsLblS = new Label("Time in Years ");
        Label interestRateLblS = new Label("Interest Rate (%) ");
        Label presentValueLblS = new Label("Present Value (£)");
        Label futureValueLblS = new Label("Future Value (£)");

        TextField timeYearsTxtS = new TextField();
        TextField interestRateTxtS = new TextField();
        TextField presentValueTxtS = new TextField();
        TextField futureValueTxtS = new TextField();

        Button calculateSavingBtnS = new Button("Calculate");
        Button backSavingBtnS = new Button("Back");
        calculateSavingBtnS.setId("calculateSavingBtn");
        backSavingBtnS.setId("goBackBtn");

        simpleSavingsGrid.setHgap(30);
        simpleSavingsGrid.setVgap(30);

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

        simpleSavingsGrid.getChildren().addAll(simpleBtn,compoundBtn,loanBtn,mortgageBtn,timeinYearsLblS, interestRateLblS, presentValueLblS, futureValueLblS, timeYearsTxtS, interestRateTxtS, presentValueTxtS, futureValueTxtS, calculateSavingBtnS, backSavingBtnS);

        simpleSavingsGrid.add(Calculator.display(),4,4,5,5);
        GridPane.setConstraints(timeinYearsLblS, 1, 4);
        GridPane.setConstraints(interestRateLblS, 1, 5);
        GridPane.setConstraints(presentValueLblS, 1, 6);
        GridPane.setConstraints(futureValueLblS, 1, 7);

        GridPane.setConstraints(simpleBtn, 4, 1);
        GridPane.setConstraints(compoundBtn, 5, 1);
        GridPane.setConstraints(loanBtn, 6, 1);
        GridPane.setConstraints(mortgageBtn, 7, 1);



        GridPane.setConstraints(timeYearsTxtS, 2, 4);
        GridPane.setConstraints(interestRateTxtS, 2, 5);
        GridPane.setConstraints(presentValueTxtS, 2, 6);
        GridPane.setConstraints(futureValueTxtS, 2, 7);

        GridPane.setConstraints(backSavingBtnS, 1, 1);
        GridPane.setConstraints(calculateSavingBtnS, 1, 9);

        backSavingBtnS.setOnAction(e -> {
            window.close();
            SavingMenu.display();
        });

        //--------------------Writing userdata to a file---------------------------------
        File userData = new File("SimpleSavings.txt");
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(userData,true);
            pw = new PrintWriter(fw,true);
            pw.println("==== Simple Savings ====");
            pw.println("Saved data from previous calculation");

        }catch (FileNotFoundException e){
            System.out.print("File not found.");
        }catch (IOException e){
            System.out.print("Cant write to the file. No permission.");
        }




        //-------------------------------------------------------------------------------


        PrintWriter finalPw = pw;
        calculateSavingBtnS.setOnAction(e -> {
            //input validation
            //---------------------------------------------------------------------------------
            if (InputValidation.checkAll(timeYearsTxtS, interestRateTxtS, presentValueTxtS, futureValueTxtS) > 1) {
                InputValidation.inputMissing();

            }
            else if (InputValidation.tooManyInput(timeYearsTxtS, interestRateTxtS, presentValueTxtS, futureValueTxtS)==4){
                InputValidation.allFieldsFilled();
            }





            if(futureValueTxtS.getText().trim().isEmpty() && InputValidation.checkAll(timeYearsTxtS, interestRateTxtS, presentValueTxtS, futureValueTxtS) == 1){
                double years = Double.parseDouble(timeYearsTxtS.getText());
                double interestRate = Double.parseDouble(interestRateTxtS.getText());
                double presentValue = Double.parseDouble(presentValueTxtS.getText());
                double futureValue = presentValue * ( Math.pow( 1+ (interestRate/100 / 12), (12 * years)));
                futureValueTxtS.setText(Double.toString(Double.parseDouble(decimalFormat.format(futureValue))));

                //--------------------Writing userdata to a file---------------------------------

                finalPw.println("present Value = "+presentValueTxtS.getText());
                finalPw.println("Years = "+timeYearsTxtS.getText());
                finalPw.println("Interest Rate = "+interestRateTxtS.getText());
                finalPw.println("future Value = "+futureValueTxtS.getText());
                finalPw.println();
                finalPw.close();
                //-------------------------------------------------------------------------------

            }

            if(interestRateTxtS.getText().trim().isEmpty() && InputValidation.checkAll(timeYearsTxtS, interestRateTxtS, presentValueTxtS, futureValueTxtS) == 1){
                double years = Double.parseDouble(timeYearsTxtS.getText());
                double presentValue = Double.parseDouble(presentValueTxtS.getText());
                double futureValue = Double.parseDouble(futureValueTxtS.getText());
                double interestRate = (12*(Math.pow(futureValue/presentValue,1/(12*years))-1))*100;
                interestRateTxtS.setText(Double.toString(Double.parseDouble(decimalFormat.format(interestRate))));

                //--------------------Writing userdata to a file---------------------------------
                finalPw.println("present Value = "+presentValueTxtS.getText());
                finalPw.println("Years = "+timeYearsTxtS.getText());
                finalPw.println("Interest Rate = "+interestRateTxtS.getText());
                finalPw.println("future Value = "+futureValueTxtS.getText());
                finalPw.println();
                finalPw.close();
                //-------------------------------------------------------------------------------

            }

            if(presentValueTxtS.getText().trim().isEmpty() && InputValidation.checkAll(timeYearsTxtS, interestRateTxtS, presentValueTxtS, futureValueTxtS) == 1){
                double years = Double.parseDouble(timeYearsTxtS.getText());
                double interestRate = Double.parseDouble(interestRateTxtS.getText());
                double futureValue = Double.parseDouble(futureValueTxtS.getText());
                double presentValue = futureValue/Math.pow(1+(interestRate/100)/12,12*years);
                presentValueTxtS.setText(Double.toString(Double.parseDouble(decimalFormat.format(presentValue))));

                //--------------------Writing userdata to a file---------------------------------
                finalPw.println("present Value = "+presentValueTxtS.getText());
                finalPw.println("Years = "+timeYearsTxtS.getText());
                finalPw.println("Interest Rate = "+interestRateTxtS.getText());
                finalPw.println("future Value = "+futureValueTxtS.getText());
                finalPw.println();
                finalPw.close();
                //-------------------------------------------------------------------------------
            }
            if(timeYearsTxtS.getText().trim().isEmpty() && InputValidation.checkAll(timeYearsTxtS, interestRateTxtS, presentValueTxtS, futureValueTxtS) == 1){
                double interestRate = Double.parseDouble(interestRateTxtS.getText());
                double presentValue = Double.parseDouble(presentValueTxtS.getText());
                double futureValue = Double.parseDouble(futureValueTxtS.getText());
                double years = Math.log(futureValue/presentValue)/(Math.log((1+((interestRate/100)/12)))*12);
                timeYearsTxtS.setText(Double.toString(Double.parseDouble(decimalFormat.format(years))));

                //--------------------Writing userdata to a file---------------------------------
                finalPw.println("present Value = "+presentValueTxtS.getText());
                finalPw.println("Years = "+timeYearsTxtS.getText());
                finalPw.println("Interest Rate = "+interestRateTxtS.getText());
                finalPw.println("future Value = "+futureValueTxtS.getText());
                finalPw.println();
                finalPw.close();
                //-------------------------------------------------------------------------------
            }
        });

        //--------------------------- StyleSheets----------------------------------
        simpleSaveScene.getStylesheets().add(SimpleSaving.class.getResource("stylesheets/Simplesavings.css").toExternalForm());
        simpleSaveScene.getStylesheets().add(SimpleSaving.class.getResource("stylesheets/Quicknavigation.css").toExternalForm());



    }
}
