package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ViewHistory {
    public static void displayHistory(){

        //items in history grid

        //back button
        Button gobackBtn = new Button("Back");
        gobackBtn.setId("backBtn");

        Label headingLbl  = new Label("User History");
        headingLbl.setId("headingLbl");

        TextArea userHistory = new TextArea();
        userHistory.setEditable(false);

        GridPane historyGrid = new GridPane();
        historyGrid.getChildren().addAll(userHistory,gobackBtn,headingLbl);
        historyGrid.setId("history");
        Scene historyScene = new Scene(historyGrid,  1280, 960);

        GridPane.setConstraints(gobackBtn,1,1);
        GridPane.setConstraints(userHistory,2,2);
        GridPane.setConstraints(headingLbl,2,1);

        historyGrid.setHgap(50);
        historyGrid.setVgap(50);

        //Simple Calculations without payment
        try {
            File file = new File("SimpleSavings.txt");
            Scanner readerS = new Scanner(file);
            while (readerS.hasNextLine()) {

                userHistory.appendText(readerS.nextLine() + " \n");


            }
            readerS.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cant read from file.");
            e.printStackTrace();
        }
        //-----------------------------------------------------------

        try {
            File file = new File("CompoundSavings.txt");
            Scanner readerC = new Scanner(file);
            while (readerC.hasNextLine()) {

                userHistory.appendText(readerC.nextLine() + " \n");


            }
            readerC.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cant read from file.");
            e.printStackTrace();
        }
        //-----------------------------------------------------------

        Stage window = new Stage();
        window.setTitle("User history");




        window.setScene(historyScene);
        window.show();


        //Button on click actions
        gobackBtn.setOnAction(e -> {
            window.close();
            HomePage.display();
        });




        //--------------------------- StyleSheets----------------------------------
        historyScene.getStylesheets().add(SimpleSaving.class.getResource("stylesheets/Userhistory.css").toExternalForm());

    }
}
