package com.example.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
    @FXML
    Button startButton;

    String[] playerNames = new String[5];

    private int playerCount = 0;

    public void startGame() throws IOException {
        calcPlayers();
        Stage stage;
        Parent root;
        if(playerCount < 2){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter at least two players!");
            alert.showAndWait();
        }else{
            stage = (Stage) startButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("gamefield.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

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
