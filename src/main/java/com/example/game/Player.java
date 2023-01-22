package com.example.game;

public class Player {
    int id;
    String name;
    int budget;
    Field[] fields = new Field[40];

    public Player(int id, String name){
        this.id = id;
        this.name = name;
        budget = 1500;
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
