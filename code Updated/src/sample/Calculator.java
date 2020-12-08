package sample;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Calculator  {
    public static GridPane display() {
        Button noOneBtn = new Button("1");
        Button noTwoBtn = new Button("2");
        Button noThreeBtn = new Button("3");
        Button noFourBtn = new Button("4");
        Button noFiveBtn = new Button("5");
        Button noSixBtn = new Button("6");
        Button noSevenBtn = new Button("7");
        Button noEightBtn = new Button("8");
        Button noNineBtn = new Button("9");
        Button noZeroBtn = new Button("0");
        Button decimalPointBtn = new Button(".");
        Button deleteLastBtn = new Button();
        deleteLastBtn.setId("deleteLast");
        Button minusValueBtn = new Button("-");

        Button enterBtn = new Button("GO");
        enterBtn.setId("enterBtn");

        TextField calEntryTxt = new TextField();

        GridPane calculatorGrid = new GridPane();

        //Positioning Calculator buttons
        GridPane.setConstraints(noZeroBtn, 1, 4);
        GridPane.setConstraints(decimalPointBtn, 2, 4);
        GridPane.setConstraints(deleteLastBtn, 3, 4);
        GridPane.setConstraints(noOneBtn, 1, 3);
        GridPane.setConstraints(noTwoBtn, 2, 3);
        GridPane.setConstraints(noThreeBtn, 3, 3);
        GridPane.setConstraints(noFourBtn, 1, 2);
        GridPane.setConstraints(noFiveBtn, 2, 2);
        GridPane.setConstraints(noSixBtn, 3, 2);
        GridPane.setConstraints(noSevenBtn, 1, 1);
        GridPane.setConstraints(noEightBtn, 2, 1);
        GridPane.setConstraints(noNineBtn, 3, 1);
        GridPane.setConstraints(calEntryTxt,1,5,3,1);
        GridPane.setConstraints(enterBtn, 2, 8,3,1);
        GridPane.setConstraints(minusValueBtn, 1, 8,3,1);




        calculatorGrid.setHgap(10);
        calculatorGrid.setVgap(10);

        //adding buttons to the calculator
        calculatorGrid.getChildren().addAll(minusValueBtn,calEntryTxt,enterBtn,noOneBtn, noTwoBtn, noThreeBtn, noFourBtn, noFiveBtn, noSixBtn, noSevenBtn, noEightBtn, noNineBtn, noZeroBtn, deleteLastBtn, decimalPointBtn);

        calEntryTxt.setText(" ");

        noZeroBtn.setOnAction(event -> calEntryTxt.setText(calEntryTxt.getText()+"0"));

        noOneBtn.setOnAction(event -> calEntryTxt.setText(calEntryTxt.getText()+"1"));

        noTwoBtn.setOnAction(event -> calEntryTxt.setText(calEntryTxt.getText()+"2"));

        noThreeBtn.setOnAction(event -> calEntryTxt.setText(calEntryTxt.getText()+"3"));

        noFourBtn.setOnAction(event -> calEntryTxt.setText(calEntryTxt.getText()+"4"));

        noFiveBtn.setOnAction(event -> calEntryTxt.setText(calEntryTxt.getText()+"5"));

        noSixBtn.setOnAction(event -> calEntryTxt.setText(calEntryTxt.getText()+"6"));

        noSevenBtn.setOnAction(event -> calEntryTxt.setText(calEntryTxt.getText()+"7"));

        noEightBtn.setOnAction(event -> calEntryTxt.setText(calEntryTxt.getText()+"8"));

        noNineBtn.setOnAction(event -> calEntryTxt.setText(calEntryTxt.getText()+"9"));

        decimalPointBtn.setOnAction(event -> calEntryTxt.setText(calEntryTxt.getText()+"."));

        minusValueBtn.setOnAction(event -> calEntryTxt.setText(calEntryTxt.getText()+"-"));


            deleteLastBtn.setOnAction(event -> {
                String previousValue = calEntryTxt.getText();
                if (previousValue != null)
                    calEntryTxt.setText(calEntryTxt.getText(0, calEntryTxt.getLength()-1));
                else
                    calEntryTxt.getText();

            });

        enterBtn.setOnAction(event -> {
            String userInput = calEntryTxt.getText();

            int counterDecimal =0;
            int counterMinus =0;
            for (int i =0;i<userInput.length();i++){
                if (userInput.charAt(i)=='.'){
                    counterDecimal++;
                }
                if (userInput.charAt(i)=='-'){
                    counterMinus++;
                }

            }
            if (counterDecimal>1){
                InputValidation.wrongDecimalPlace();
            }
            if (counterMinus > 1) {
                InputValidation.minusValueError();
            }
                }



        );

        //--------------------------- StyleSheets----------------------------------
        calculatorGrid.getStylesheets().add(Calculator.class.getResource("stylesheets/Calculator.css").toExternalForm());

return calculatorGrid;
    }
 }
