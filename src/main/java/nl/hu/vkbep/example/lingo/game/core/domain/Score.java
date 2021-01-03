package nl.hu.vkbep.example.lingo.game.core.domain;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int score = 0;
    private int totelTurns = 0;
    private int turnsRoundOne;
    private int turnsRoundTwo;
    private int turnRoundThree;
    private int lengthNextRound = 0;
    private boolean roundOneAchieved = false;//6 letter word
    private boolean roundTwoAchieved = false;//7 letter word
    private boolean roundThreeAchieved = false;
    @Transient
    private boolean roundActive = true;

    public Score (String name){
        this.name = name;
    }

    public Score() {
    }

    public boolean turnsExceeded(){
        return (totelTurns >= 5 && !roundOneAchieved) || (roundOneAchieved && !roundTwoAchieved && (totelTurns - turnsRoundOne) >= 5) || (roundTwoAchieved && (totelTurns - turnsRoundOne - turnsRoundTwo) >= 5);
    }

    public void wordQuessed(){
        if (!roundOneAchieved){
            turnsRoundOne = totelTurns;
            roundOneAchieved = true;
            roundActive = false;
        }else if(!roundTwoAchieved){
            turnsRoundTwo = totelTurns - turnsRoundOne;
            roundTwoAchieved = true;
            roundActive = false;
        }else{
            turnRoundThree = totelTurns - turnsRoundOne - turnRoundThree;
            roundThreeAchieved = true;
            roundActive = false;
        }
    }

    public int nextRound(){
        if(roundTwoAchieved && !roundActive && !roundThreeAchieved){
            lengthNextRound = 7;
        }
        else if (roundOneAchieved && !roundActive && !roundThreeAchieved){
            lengthNextRound = 6;
        }else{
            lengthNextRound = 0;
        }
        return lengthNextRound;
    }

    public void nextRoundStarted(){
        lengthNextRound = 0;
        roundActive = true;
    }

    public String getScores(){
        String result = this.name + ", je scoren is: " + this.score + "\nJe heb totaal: " + this.totelTurns + " beurten gehad\n";
        if (!roundOneAchieved){
            result += "Je hebt geen ronden gehaald :(";
        }else if(!roundTwoAchieved){
            result += "Je hebt ronden 1 gehaald in " + turnsRoundOne + " beurten";
        }else if (!roundThreeAchieved){
            result += "Je hebt ronden 1 gehaald in " + turnsRoundOne + " beurten\nJe hebt ronden 2 gehaald in " + turnsRoundTwo + " beurten";
        }else{
            result += "Je hebt ronden 1 gehaald in " + turnsRoundOne + " beurten\nJe hebt ronden 2 gehaald in " + turnsRoundTwo + " beurten\nJe hebt ronden 3 gehaald in " + turnRoundThree + " beurten";
        }
        return result;
    }

    public boolean gameFinished(){
        return roundThreeAchieved;
    }
    public void invalidTurn(){
        totelTurns++;
    }
    public void validTurn(){
        score++;
        totelTurns++;
    }
}