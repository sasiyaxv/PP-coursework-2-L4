package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SavingMenu {
    public static void display(){

        Stage window = new Stage();
        window.setTitle("Savings");
        window.setResizable(false);

        //Inside savings menu Pane
        GridPane savingsMenuGrid = new GridPane();
        savingsMenuGrid.setId("savingsMenu");
        Scene savingsMenuScene = new Scene(savingsMenuGrid, 1280, 960);

        savingsMenuGrid.setHgap(50);
        savingsMenuGrid.setVgap(50);

        savingsMenuGrid.setPadding(new Insets(50));

        //buttons in savings menu scene
        Button simpleSavingsBtn = new Button("Simple Savings");
        Button compoundSavingsBtn = new Button("Compound Savings");
        Button backToMain = new Button("Back");

        savingsMenuGrid.getChildren().addAll(compoundSavingsBtn, simpleSavingsBtn, backToMain);

        //positioning the buttons
        GridPane.setConstraints(simpleSavingsBtn, 1, 2);
        GridPane.setConstraints(compoundSavingsBtn, 1, 3);
        GridPane.setConstraints(backToMain, 1, 1);

        window.setScene(savingsMenuScene);
        window.show();

        //----------------------Button onclick events------------------------
        simpleSavingsBtn.setOnAction(e -> {
           window.close();
            try {
                SimpleSaving.display();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        compoundSavingsBtn.setOnAction(e -> {
            window.close();
            CompoundSaving.display();
        });

        backToMain.setOnAction(e -> {
            window.close();
            HomePage.display();
        });
        //--------------------------- StyleSheets----------------------------------
        savingsMenuScene.getStylesheets().add(SavingMenu.class.getResource("stylesheets/Savingsmenu.css").toExternalForm());
    }
}
