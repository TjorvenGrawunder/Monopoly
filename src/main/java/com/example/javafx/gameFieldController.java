package com.example.javafx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class gameFieldController implements Initializable {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        diceImages = new Image[6];
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

    public static void setPlayers(){

    }
}

