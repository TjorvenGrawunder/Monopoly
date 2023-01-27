package com.example.game;

import com.example.javafx.GamefieldController;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Field[] gameField = new Field[40];
    private Player currentPlayer;
    List<Player> players = new ArrayList<>();

    public Game(String[] playerNames){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gamefield.fxml"));
        GamefieldController gamefieldController = loader.getController();
        for(int i = 0; i < playerNames.length; i++){
            if(playerNames[i] != null){
                players.add(new Player(i+1,playerNames[i]));
            }
        }
        for(int i = 0; i < players.size()-1; i++){
            players.get(i).setNext(players.get(i+1));
        }
        players.get(players.size()-1).setNext(players.get(0));
        createGameField();
        currentPlayer = players.get(0);
    }

    public void createGameField(){
        gameField[0] = new Field("Los", 0, 0, 676, 676);
        gameField[1] = new Field("Badstraße", 6, 60, 598, 676);
        gameField[2] = new Field("Gemeinschaftsfeld", 2, 0, 537, 676);
        gameField[3] = new Field("Turmstraße", 6, 60, 476, 676);
        gameField[4] = new Field("Einkommensteuer", 15, 200, 415, 676);
        gameField[5] = new Field("Südbahnhof", 14, 200, 354, 676);
        gameField[6] = new Field("Chausseestraße", 7, 100, 293, 676);
        gameField[7] = new Field("Ereignisfeld", 1, 0, 232, 676);
        gameField[8] = new Field("Elisenstraße", 7, 100, 171, 676);
        gameField[9] = new Field("Poststraße", 7, 120, 110, 676);
        gameField[10] = new Field("Gefängnis", 4, 0, 14, 696);
        gameField[11] = new Field("Seestraße", 8, 140, 21, 600);
        gameField[12] = new Field("Elektrizitätswerk", 16, 150, 21, 539);
        gameField[13] = new Field("Hafenstraße", 8, 140, 21, 478);
        gameField[14] = new Field("Neue Straße", 8, 160, 21, 417);
        gameField[15] = new Field("Westbahnhof", 14, 200, 21, 356);
        gameField[16] = new Field("Münchener Straße", 9, 180, 21, 295);
        gameField[17] = new Field("Gemeinschaftsfeld", 2, 0, 21, 234);
        gameField[18] = new Field("Wiener Straße", 9, 180, 21, 173);
        gameField[19] = new Field("Berliner Straße", 9, 200, 21, 112);
        gameField[20] = new Field("Frei Parken", 5, 0, 21, 30);
        gameField[21] = new Field("Theaterstraße",10,220,110, 30);
        gameField[22] = new Field("Ereignisfeld",1,0,171,30);
        gameField[23] = new Field("Museumsstraße",10,220,232,30);
        gameField[24] = new Field("Opernplatz",10,240,293,30);
        gameField[25] = new Field("Nordbanhof", 14,200,354,30);
        gameField[26] = new Field("Lessingstraße", 11,260,415,30);
        gameField[27] = new Field("Schillerstraße",11,260,476,30);
        gameField[28] = new Field("Wasserwerk",16,150,537,30);
        gameField[29] = new Field("Goethestraße",11,280,598,30);
        gameField[30] = new Field("Gefängnis gehen",3,0,680,0);
        gameField[31] = new Field("Rathausplatz",12,300,680,112);
        gameField[32] = new Field("Hauptstraße", 12,0,680,173);
        gameField[33] = new Field("Gemeinschaftsfeld", 2,0,680,234);
        gameField[34] = new Field("Bahnhofstraße",12,320,680,295);
        gameField[35] = new Field("Hauptbahnhof",14,200,680,356);
        gameField[36] = new Field("Ereignisfeld",1,0,680,417);
        gameField[37] = new Field("Parkstraße",13,350,680,478);
        gameField[38] = new Field("Zusatzsteuer",15,100,680,539);
        gameField[39] = new Field("Schlossalle",13,400,680,600);
    }

    public String nextPlayer(){
        currentPlayer = currentPlayer.getNext();
        return currentPlayer.getName();
    }

    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }



    public List<Player> getPlayers(){
        return this.players;
    }

    public Field[] getGameField() {
        return gameField;
    }

}
