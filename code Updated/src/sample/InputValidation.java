package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class InputValidation {

    //to check if user has left alone more than one text field
    public static void inputMissing(){
        Alert inputMissing = new Alert(Alert.AlertType.WARNING);
        inputMissing.setHeaderText("Input Missing");
        inputMissing.setContentText("Too many empty fields.\n" +"Only one field can be left empty.");
        inputMissing.showAndWait();
    }

    //to traverse through text fields and to check empty fields
    public static int checkAll(TextField... textFields){
        int i = 0;
        for(TextField textField : textFields){
            if (textField.getText().trim().isEmpty()){
                i+=1;
            }
        }
        return i;
    }

    //to traverse through text fields and to check if all filled
    public static int tooManyInput(TextField... textFields){
        int count = 0;
        for(TextField textField : textFields){
            if (textField.getText() != null){
                count+=1;
            }
        }
        return count;
    }

    //to check if user has entered more than one decimal place
    public static void wrongDecimalPlace(){
        Alert wrongInput = new Alert(Alert.AlertType.WARNING);
        wrongInput.setHeaderText("Wrong Input.");
        wrongInput.setContentText("You cannot enter more than one decimal place.");
        wrongInput.showAndWait();
    }

    //to check if user has entered more than one minus operator
    public static void minusValueError(){
        Alert wrongInput = new Alert(Alert.AlertType.WARNING);
        wrongInput.setHeaderText("Wrong Input.");
        wrongInput.setContentText("You cannot enter more than one minus place.");
        wrongInput.showAndWait();
    }

    //to check if user has filled all fields
    public static void allFieldsFilled(){
        Alert wrongInput = new Alert(Alert.AlertType.INFORMATION);
        wrongInput.setHeaderText("Too many inputs.");
        wrongInput.setContentText("You have filled all fields.\nThe field that need to be calculated should be left empty.");
        wrongInput.showAndWait();
    }

}
