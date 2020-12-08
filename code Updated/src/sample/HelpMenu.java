package sample;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.text.Element;
import javax.swing.text.html.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HelpMenu {
    public static void display()  {

        Stage window = new Stage();
        window.setTitle("Help Window");

        //go back button
        Button goBackBtn = new Button("Back");

        //instructions to use the calculator
        Label mainHelpLbl = new Label("You can do your calculation needs using this calculator.\n In main window there are options listed that you can use.Click on the relevant button to enter the calculation window. ");

        //heading
        Label headingLbl = new Label("Welcome to the Finance Calculator.");
        headingLbl.setId("heading");

        //using the mainmenu
        Label mainMenuImg = new Label();
        mainMenuImg.setId("mainMenuImg");




        //using the layout
        Label layoutHelp = new Label("How to use the layout ? ");
        Label layoutEx = new Label();
        layoutEx.setId("layoutImg");

        //setting up a new PANE for help window
        GridPane helpGrid = new GridPane();
        Scene helpScene = new Scene(helpGrid, 1280, 960);
        helpGrid.getChildren().addAll(goBackBtn,headingLbl,mainHelpLbl);

        helpGrid.setHgap(30);
        helpGrid.setVgap(30);

        GridPane.setConstraints(goBackBtn, 1, 1);
        GridPane.setConstraints(mainHelpLbl, 2, 3);
        GridPane.setConstraints(headingLbl, 2, 2);

        window.setScene(helpScene);
        window.show();

        goBackBtn.setOnAction(e -> {
            window.close();
            HomePage.display();
        });


        //--------------------------- StyleSheets----------------------------------
        helpScene.getStylesheets().add(SimpleSaving.class.getResource("stylesheets/Helpwindow.css").toExternalForm());

    }


}
