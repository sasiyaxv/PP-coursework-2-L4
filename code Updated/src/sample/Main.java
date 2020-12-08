package sample;

import javafx.application.Application;
import javafx.stage.Stage;



/*
 * ===========================
 * Programming Principles Two
 * Course Work
 * ===========================
 * */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //displaying the main menu
        HomePage.display();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
