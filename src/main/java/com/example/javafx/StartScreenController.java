package com.example.javafx;

import com.example.game.Game;
import com.example.game.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    List<Player> players = new ArrayList<>();
    Game game;

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gamefield.fxml"));
            root = loader.load();
            GamefieldController gamefieldController = loader.getController();
            game = new Game(playerNames);
            gamefieldController.setGame(game);
            gamefieldController.init();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        //fieldControllerInstance.setPlayers(players);
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
