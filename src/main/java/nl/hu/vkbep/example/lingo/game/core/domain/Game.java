package nl.hu.vkbep.example.lingo.game.core.domain;

import java.util.Random;

public class Game {
    private int key;
    String name;
    private LingoWord word;
    public Game(String name, String word){
        Random r = new Random();
        this.name = name;
        this.key = 100000 + r.nextInt(900000);
        this.word = new LingoWord(word, name);
    };
    public boolean authenticate(int givenKey){
        return key == givenKey;
    };
    public Score getScore(){
        return this.word.getScore();
    };
    public String getKey(){
        return "Hallo " + name + " , jouw key is: " + key + ", succes!\n De eerste letter van jouw woord is: " + word.getFirstCharacterOfWord().toString();
    };
    public int getIntKey(){return key;}
    public String play(String word){
        return this.word.play(word);
    };
    public String nieuweRonde(String word){
        return this.word.nieuweRonde(word);
    }
    public int volgendeRonde(){
        return this.word.volgendeRonde();
    }
}
