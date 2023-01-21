package com.example.game;

public class Street {
    private String name;
    private String color;
    private int count;
    private double x;
    private double y;
    private int owner;

    public Street(String name, String color, int count, double x, double y){
        this.name = name;
        this.color = color;
        this.count = count;
        this.x = x;
        this.y = y;
        this.owner = 0;
    }

    public void setOwner(int playerID){
        this.owner = playerID;
    }
}
