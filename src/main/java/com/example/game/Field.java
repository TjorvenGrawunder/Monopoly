package com.example.game;

public class Field {
    private String name;
    private int groupID;
    private int price;
    private double x;
    private double y;
    private int owner;

    /**
     *
     * @param name
     * @param groupID
     * 0 = Los
     * 1 = Ereignisfeld
     * 2 = Gemeinschaftsfeld
     * 3 = Gefängnis gehen
     * 4 = Gefängnis
     * 5 = Frei Parken
     * 6 = Braun
     * 7 = Hellblau
     * 8 = Pink
     * 9 = Orange
     * 10 = Rot
     * 11 = Gelb
     * 12 = Grün
     * 13 = Dunkelblau
     * 14 = Bahnhof
     * 15 = Steuer
     * 16 = Werk
     * @param price
     * @param x
     * @param y
     */
    public Field(String name, int groupID, int price, double x, double y){
        this.name = name;
        this.groupID = groupID;
        this.price = price;
        this.x = x;
        this.y = y;
        this.owner = 0;
    }

    public void setOwner(int playerID){
        this.owner = playerID;
    }
}
