package nl.hu.vkbep.example.lingo.game.core.application;

import nl.hu.vkbep.example.lingo.game.core.domain.Game;
import nl.hu.vkbep.example.lingo.game.core.domain.Score;

public class LingoService {
    private Game currentGame;
    public LingoService(){};

    public String createGame(String name, String word){
        currentGame = new Game(name ,word);
        return currentGame.getKey();
    }

    public boolean authenticate(int givenKey){
        return currentGame.authenticate(givenKey);
    }

    public String play(String word){
        return currentGame.play(word);
    }

    public String newRound(String word){
        return currentGame.newRound(word);
    }

    public Score getScore(){
        return currentGame.getScore();
    }

    public void InvalidTurn(){
        this.currentGame.invalidTurn();
    }

    public boolean currentGameActive(){
        return currentGame != null;
    }

    public int nextRound(){
        return currentGame.nextRound();
    }

    public void clearCurrentGame(){
        currentGame = null;
    }
}
