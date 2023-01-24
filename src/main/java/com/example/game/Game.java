package com.example.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Field[] gameField = new Field[40];
    List<Player> players = new ArrayList<>();

    public Game(String[] playerNames){
        for(int i = 0; i < playerNames.length; i++){
            if(playerNames[i] != null){
                players.add(new Player(i+1,playerNames[i]));
            }
        }
        createGameField();
    }

    public void createGameField(){
        gameField[0] = new Field("Los", 0, 0, 0, 0);
        gameField[1] = new Field("Badstraße", 6, 60, 0, 0);
        gameField[2] = new Field("Gemeinschaftsfeld", 2, 0, 0, 0);
        gameField[3] = new Field("Turmstraße", 6, 60, 0, 0);
        gameField[4] = new Field("Einkommensteuer", 15, 200, 0, 0);
        gameField[5] = new Field("Südbahnhof", 14, 200, 0, 0);
        gameField[6] = new Field("Chausseestraße", 7, 100, 0, 0);
        gameField[7] = new Field("Ereignisfeld", 1, 0, 0, 0);
        gameField[8] = new Field("Elisenstraße", 7, 100, 0, 0);
        gameField[9] = new Field("Poststraße", 7, 120, 0, 0);
        gameField[10] = new Field("Gefängnis", 4, 0, 0, 0);
        gameField[11] = new Field("Seestraße", 8, 140, 0, 0);
        gameField[12] = new Field("Elektrizitätswerk", 16, 150, 0, 0);
        gameField[13] = new Field("Hafenstraße", 8, 140, 0, 0);
        gameField[14] = new Field("Neue Straße", 8, 160, 0, 0);
        gameField[15] = new Field("Westbahnhof", 14, 200, 0, 0);
        gameField[16] = new Field("Münchener Straße", 9, 180, 0, 0);
        gameField[17] = new Field("Gemeinschaftsfeld", 2, 0, 0, 0);
        gameField[18] = new Field("Wiener Straße", 9, 180, 0, 0);
        gameField[19] = new Field("Berliner Straße", 9, 200, 0, 0);
        gameField[20] = new Field("Frei Parken", 5, 0, 0, 0);
        gameField[21] = new Field("Theaterstraße",10,220,0, 0);
        gameField[22] = new Field("Ereignisfeld",1,0,0,0);
        gameField[23] = new Field("Museumsstraße",10,220,0,0);
        gameField[24] = new Field("Opernplatz",10,240,0,0);
        gameField[25] = new Field("Nordbanhof", 14,200,0,0);
        gameField[26] = new Field("Lessingstraße", 11,260,0,0);
        gameField[27] = new Field("Schillerstraße",11,260,0,0);
        gameField[28] = new Field("Wasserwerk",16,150,0,0);
        gameField[29] = new Field("Goethestraße",11,280,0,0);
        gameField[30] = new Field("Gefängnis gehen",3,0,0,0);
        gameField[31] = new Field("Rathausplatz",12,300,0,0);
        gameField[32] = new Field("Hauptstraße", 12,0,0,0);
        gameField[33] = new Field("Gemeinschaftsfeld", 2,0,0,0);
        gameField[34] = new Field("Bahnhofstraße",12,320,0,0);
        gameField[35] = new Field("Hauptbahnhof",14,200,0,0);
        gameField[36] = new Field("Ereignisfeld",1,0,0,0);
        gameField[37] = new Field("Parkstraße",13,350,0,0);
        gameField[38] = new Field("Zusatzsteuer",15,100,0,0);
        gameField[39] = new Field("Schlossalle",13,400,0,0);
    }



    public List<Player> getPlayers(){
        return this.players;
    }
}
