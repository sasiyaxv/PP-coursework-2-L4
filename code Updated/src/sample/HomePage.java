package sample;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomePage {
    public static void display(){
        //----------------------- Buttons and Labels ---------------------

        //Main label
        Label headingLbl = new Label("FINANCE CALCULATOR");
        headingLbl.setId("mainHeader");

        //button to savings calculations
        Button savingsCalculationBtn = new Button("Savings");

        //button to calculations regarding loans
        Button loansCalculationBtn = new Button("Auto loans");

        //buttons to mortgage calculations
        Button mortgageCalculationBtn = new Button("Mortgage");

        //buttons to Quit
        Button quitBtn = new Button("Quit");
        quitBtn.setId("quitBtn");

        //view history Button
        Button viewHistoryBtn = new Button("View History");

        //Button to open help window
        Button helpBtn = new Button("Help");
        helpBtn.setId("helpBtn");



        //positioning the objects - Pane main menu
        savingsCalculationBtn.setLayoutY(150);
        savingsCalculationBtn.setLayoutX(50);
        loansCalculationBtn.setLayoutY(250);
        loansCalculationBtn.setLayoutX(50);
        mortgageCalculationBtn.setLayoutX(50);
        mortgageCalculationBtn.setLayoutY(350);
        quitBtn.setLayoutX(50);
        quitBtn.setLayoutY(650);
        helpBtn.setLayoutX(50);
        helpBtn.setLayoutY(550);
        headingLbl.setLayoutX(350);
        headingLbl.setLayoutY(10);
        viewHistoryBtn.setLayoutX(50);
        viewHistoryBtn.setLayoutY(450);

        //-----------------------------------------------------------------------------------
        //Declaring the PANE and adding the elements
        Stage window = new Stage();
        window.setResizable(false);
        window.setTitle("Main menu");
        Pane mainMenuPane = new Pane();
        mainMenuPane.setId("mainMenuPane");
        mainMenuPane.getChildren().addAll(savingsCalculationBtn, loansCalculationBtn, mortgageCalculationBtn, helpBtn,  headingLbl, quitBtn,viewHistoryBtn);
        Scene mainMenuScene = new Scene(mainMenuPane,  1280, 960);
        window.setScene(mainMenuScene);
        window.show();



        //-------------------------------------------------------------------------------------
        //Button onclick events




        savingsCalculationBtn.setOnAction(e -> {
            window.close();
            SavingMenu.display();
        });

        loansCalculationBtn.setOnAction(e -> {
            window.close();
            AutoLoan.display();
        });

        mortgageCalculationBtn.setOnAction(e -> {
            window.close();
            Mortgage.display();
        });

        viewHistoryBtn.setOnAction(e -> {
                window.close();
                ViewHistory.displayHistory();

        });

        helpBtn.setOnAction(e -> {
            window.close();
            HelpMenu.display();
        });

        quitBtn.setOnAction(e -> {
            Alert quitConifrm = new Alert(Alert.AlertType.CONFIRMATION);
            quitConifrm.setHeaderText("Confirmation");
            quitConifrm.setContentText("Are you sure you want to quit.");
            quitConifrm.showAndWait();
            if (quitConifrm.getResult() == ButtonType.OK) {
                window.close();
            }
        });


        //-----------Adding Style Sheets-------------------
       mainMenuScene.getStylesheets().add(HomePage.class.getResource("stylesheets/Homepage.css").toExternalForm());
    }
    }

