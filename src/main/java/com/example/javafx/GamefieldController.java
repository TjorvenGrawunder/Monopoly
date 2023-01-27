package com.example.javafx;

import com.example.game.Game;
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

public class GamefieldController {
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
    @FXML
    private Label playerLabel;

    private Random rand;
    private int rollCount;
    private Timeline rollTimeline;
    private int dice1Value;
    private int dice2Value;
    private Image[] diceImages;
    private Game game;
    private List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }



    public void init() {
        diceImages = new Image[6];
        players = game.getPlayers();
        genPlayerImg();
        playerLabel.setText("Player: " + game.getCurrentPlayer().getName());
        game.getCurrentPlayer().setField(game.getGameField()[0]);
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
                playerLabel.setText("Player: " + game.nextPlayer());
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


    public void genPlayerImg(){
        if(players.size() >= 2){
            playerOneImage.setImage(new Image(players.get(0).getImage()));
            playerTwoImage.setImage(new Image(players.get(1).getImage()));
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



    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public ImageView getPlayerOneImage() {
        return playerOneImage;
    }

    public ImageView getPlayerTwoImage() {
        return playerTwoImage;
    }

    public ImageView getPlayerThreeImage() {
        return playerThreeImage;
    }

    public ImageView getPlayerFourImage() {
        return playerFourImage;
    }

    public ImageView getPlayerFiveImage() {
        return playerFiveImage;
    }
}

