package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class StartScreenController {
    @FXML
    TextField playerOneInputField;
    @FXML
    TextField playerTwoInputField;
    @FXML
    TextField playerThreeInputField;
    @FXML
    TextField playerFourInputField;
    @FXML
    TextField playerFiveInputField;

    String[] playerNames = new String[5];

    private int playerCount = 0;

    public void startGame(){
        calcPlayers();
        if(playerCount < 2){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter at least two players!");
            alert.showAndWait();
        }else{

        }
    }

    private void calcPlayers(){
        playerCount = 0;
        if(!(playerOneInputField.getText().equals(""))){
            playerCount++;
            playerNames[0] = playerOneInputField.getText();
        }
        if(!(playerTwoInputField.getText().equals(""))){
            playerCount++;
            playerNames[1] = playerTwoInputField.getText();
        }
        if(!(playerThreeInputField.getText().equals(""))){
            playerCount++;
            playerNames[2] = playerThreeInputField.getText();
        }
        if(!(playerFourInputField.getText().equals(""))){
            playerCount++;
            playerNames[3] = playerFourInputField.getText();
        }
        if(!(playerFiveInputField.getText().equals(""))){
            playerCount++;
            playerNames[4] = playerFiveInputField.getText();
        }
    }
}
