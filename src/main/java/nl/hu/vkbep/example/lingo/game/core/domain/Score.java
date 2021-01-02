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
    private int beurtenTotaal = 0;
    private int beurtenRondenEen;
    private int beurtenRondenTwee;
    private int beurtenRondenDrie;
    private int lengteVolgendeRonden = 0;
    private boolean rondenEenGehaald = false;//6 letter woord
    private boolean rondenTweeGehaald = false;//7 letter woord
    private boolean rondenDrieGehaald = false;
    @Transient
    private boolean rondenBezig = true;
    public Score (String name){
        this.name = name;
    }

    public Score() {

    }

    public boolean beurdenOverschreden(){// kan korter
        if(beurtenTotaal >= 5 && !rondenEenGehaald){
            return true;
        }else if(rondenEenGehaald && (beurtenTotaal - beurtenRondenEen) >= 5){
            return true;
        }else if (rondenTweeGehaald && (beurtenTotaal - beurtenRondenEen - beurtenRondenTwee) >= 5){
            return true;
        }else{
            return false;
        }
    }
    public void woordGeraden(){
        if (!rondenEenGehaald){
            beurtenRondenEen = beurtenTotaal;
            rondenEenGehaald = true;
            rondenBezig = false;
        }else if(rondenEenGehaald && !rondenTweeGehaald){
            beurtenRondenTwee = beurtenTotaal - beurtenRondenEen;
            rondenTweeGehaald = true;
            rondenBezig = false;
        }else{
            beurtenRondenDrie = beurtenTotaal - beurtenRondenEen - beurtenRondenDrie;
            rondenDrieGehaald = true;
        }
    }
    public int volgendeRonde(){
        if(rondenTweeGehaald && !rondenBezig){
            lengteVolgendeRonden = 7;
        }
        else if (rondenEenGehaald && !rondenBezig){
            lengteVolgendeRonden = 6;
        }else{
            lengteVolgendeRonden = 0;
        }
        return lengteVolgendeRonden;
    }
    public void volgendeRondeGestart(){
        lengteVolgendeRonden = 0;
        rondenBezig = true;
    }
    public String getScores(){
        String result = this.name + ", je scoren is: " + this.score + "\nJe heb totaal: " + this.beurtenTotaal + " beurten gehad\n";
        if (!rondenEenGehaald){
            result += "Je hebt geen ronden gehaald :(";
        }else if(rondenEenGehaald && !rondenTweeGehaald){
            result += "Je hebt ronden 1 gehaald in " + beurtenRondenEen + " beurten";
        }else if (rondenTweeGehaald && !rondenDrieGehaald){
            result += "Je hebt ronden 1 gehaald in " + beurtenRondenEen + " beurten\nJe hebt ronden 2 gehaald in " + beurtenRondenTwee + " beurten";
        }else{
            result += "Je hebt ronden 1 gehaald in " + beurtenRondenEen + " beurten\nJe hebt ronden 2 gehaald in " + beurtenRondenTwee + " beurten\nJe hebt ronden 3 gehaald in " + beurtenRondenDrie + " beurten";
        }
        return result;
    }
    public boolean spelGewonnen(){
        return rondenDrieGehaald;
    }
    public void ongeldigeBeurd(){
        beurtenTotaal++;
    }
    public void goedeBeurd(){
        score++;
        beurtenTotaal++;
    }
}
//http://zetcode.com/springboot/postgresql/