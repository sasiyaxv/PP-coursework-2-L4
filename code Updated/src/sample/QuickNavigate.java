package sample;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;

public class QuickNavigate {
    public static void toolbarDisplay(Window window){

        //Top toolbar to navigate through options
        Button simpleBtn = new Button("Simple");
        Button compoundBtn = new Button("Cmpound");
        Button loanBtn = new Button("Loan");
        Button mortgageBtn = new Button("Mortgage");

        GridPane quickNavigate = new GridPane();
        quickNavigate.getChildren().addAll(simpleBtn,compoundBtn,loanBtn,mortgageBtn);

        GridPane.setConstraints(simpleBtn,1,1);
        GridPane.setConstraints(compoundBtn,2,1);
        GridPane.setConstraints(loanBtn,3,1);
        GridPane.setConstraints(mortgageBtn,4,1);

      /*  simpleBtn.setOnAction(e -> {
            window.close();
            SavingMenu.display();
        });*/
    }
}
