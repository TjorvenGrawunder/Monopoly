package com.example.javafx;

import com.example.game.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;

public class GamefieldController implements Initializable {
    @FXML
    private ImageView dice1Image;
    @FXML
    private ImageView dice2Image;
    @FXML
    private Label sumLabel;
    @FXML
    private ImageView playerOneImage;
    @FXML
    private ImageView playerTwoImage;
    @FXML
    private ImageView playerThreeImage;
    @FXML
    private ImageView playerFourImage;
    @FXML
    private ImageView playerFiveImage;

    private Random rand;
    private int rollCount;
    private Timeline rollTimeline;
    private int dice1Value;
    private int dice2Value;
    private Image[] diceImages;
    private static GamefieldController instance;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    private List<Player> players = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        diceImages = new Image[6];
        genPlayerImg();
        try {
            diceImages[0] = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/dice/1.png")));
            diceImages[1] = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/dice/2.png")));
            diceImages[2] = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/dice/3.png")));
            diceImages[3] = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/dice/4.png")));
            diceImages[4] = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/dice/5.png")));
            diceImages[5] = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/dice/6.png")));
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
        rand = new Random();
        rollCount = 0;
        rollTimeline = new Timeline();
        rollTimeline.setCycleCount(Timeline.INDEFINITE);
        rollTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(50), event -> {
            rollCount++;
            if (rollCount > 20) {
                rollTimeline.stop();
                dice1Value = rand.nextInt(6) + 1;
                dice2Value = rand.nextInt(6) + 1;
                dice1Image.setImage(diceImages[dice1Value - 1]);
                dice2Image.setImage(diceImages[dice2Value - 1]);
                sumLabel.setText(Integer.toString(dice1Value + dice2Value));
            } else {
                int dice1 = rand.nextInt(6) + 1;
                int dice2 = rand.nextInt(6) + 1;
                dice1Image.setImage(diceImages[dice1 - 1]);
                dice2Image.setImage(diceImages[dice2 - 1]);
            }
        }));

    }


    @FXML
    public void rollDice() {
        rollCount = 0;
        rollTimeline.playFromStart();
    }

    public static synchronized GamefieldController getFieldControllerInstance(){
        if(instance == null){
            instance = new GamefieldController();
        }
        return instance;
    }

    public void genPlayerImg(){
        if(players.size() >= 2){
            playerOneImage.setImage(new Image(players.get(0).getImage()));
            playerTwoImage.setImage(new Image(players.get(1).getImage()));
            System.out.println("Test");
        }
        if(players.size() >= 3){
            playerThreeImage.setImage(new Image(players.get(2).getImage()));
        }
        if(players.size() >= 4){
            playerFourImage.setImage(new Image(players.get(3).getImage()));
        }
        if(players.size() == 5){
            playerFiveImage.setImage(new Image(players.get(4).getImage()));
        }
    }
}

