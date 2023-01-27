package com.example.game;

import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

public class Player {
    private int id;
    private String name;
    private int budget;

    private Field field;

    private Player next;

    private ImageView playerView;

    private InputStream image;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
        budget = 1500;
        switch(id){
            case 1:
                image = Objects.requireNonNull(getClass().getResourceAsStream("/img/player/batman.png"));
                break;
            case 2:
                image = Objects.requireNonNull(getClass().getResourceAsStream("/img/player/spongebob.png"));
                break;
            case 3:
                image = Objects.requireNonNull(getClass().getResourceAsStream("/img/player/captain_america.png"));
                break;
            case 4:
                image = Objects.requireNonNull(getClass().getResourceAsStream("/img/player/mario.png"));
                break;
            case 5:
                image = Objects.requireNonNull(getClass().getResourceAsStream("/img/player/velma.png"));
                break;
            default:
                System.exit(-1);
                break;
        }
    }

    public int addMoney(int amount){
        this.budget += amount;
        return this.budget;
    }

    public int remMoney(int amount){
        this.budget -= amount;
        return this.budget;
    }
    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Player getNext() {
        return next;
    }

    public void setNext(Player next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public ImageView getPlayerView() {
        return playerView;
    }

    public void setPlayerView(ImageView playerView) {
        this.playerView = playerView;
    }

}
