package com.example.game;

import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

public class Player {
    int id;
    String name;
    int budget;
    Field[] fields = new Field[40];
    InputStream image;

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
}
