package nl.hu.vkbep.example.lingo.game.core.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LingoWord {
    private String word;
    private int wordLength;
    private ArrayList<Character> wordArray = new ArrayList<Character>();
    private ArrayList<Character> inputWord = new ArrayList<Character>();
    private ArrayList<String> inputWordFeedback = new ArrayList<String>();
    private LocalDateTime localDateTimeLastPlay = LocalDateTime.now();
    private Score score;

    public LingoWord(String word, String name){
        this.word = word;
        this.score = new Score(name);
        this.wordLength = word.length();
        for(char c : word.toCharArray()){
            wordArray.add(c);
        }
    }

    public Score getScore(){
        return score;
    }
    public int volgendeRonde(){
        return this.score.volgendeRonde();
    }
    public String nieuweRonde(String word){
        this.word = word;
        this.wordArray.clear();
        this.wordLength = word.length();
        for(char c : word.toCharArray()){
            wordArray.add(c);
        }
        score.volgendeRondeGestart();
        return "Deze ronden word er met " + wordLength + " letters gespeeld.\nDe eerste letter is: " + getFirstCharacterOfWord();
    }

    public String play(String word) {
        if (validateInputWord(word) && validateTime() && !score.beurdenOverschreden() && !score.spelGewonnen()){
            setInputWord(word);
            generateFeedback();
            localDateTimeLastPlay = LocalDateTime.now();
            score.goedeBeurd();
            return getFeedback();
        }else if (!validateInputWord(word)){
            localDateTimeLastPlay = LocalDateTime.now();
            return "Geef alleen woorden met de lengte: " + wordLength + " , en het word moet in kleine letters zijn zonder speciale tekens of spaties";
        }else if (!validateTime()){
            score.ongeldigeBeurd();
            localDateTimeLastPlay = LocalDateTime.now();
            return "Oei je hebt niet binnen de tijd geantwoord!";
        }else if(score.spelGewonnen()){
            return "Gefeliciteerd! je heb gewonnen!\n" + score.getScores();
        }else{
            return "Oei je hebt niet binnen 5 ronden het woord geraden!\nHet woord was: " + word + "\n" + score.getScores();

        }
    }

    public boolean validateInputWord(String wd){
        return wd.matches("^[a-z]{5,7}$") && wordLength == wd.length();
    }

    public boolean validateTime(){
        return LocalDateTime.now().isBefore(localDateTimeLastPlay.plusSeconds(10));
    }

    public boolean setInputWord(String inputWordString){
        inputWord.clear();
        for(char c : inputWordString.toCharArray()){
            inputWord.add(c);
        }
        return true;
    }

    public List<String> generateFeedback(){
        int index = 0;
        inputWordFeedback.clear();
        for(char c : inputWord){
            if(wordArray.get(index).equals(c))
                inputWordFeedback.add("Correct");
            else if(wordArray.contains(c)){
                inputWordFeedback.add("Present");
            }else{
                inputWordFeedback.add("Absent");
            }
            index++;
        }
        return inputWordFeedback;
    }

    public String getFeedback(){
        int index = 0;
        String resultString = "";
        System.out.println("Het woord is : " + word.toString());
        for (Character c : inputWord) {
            resultString =  resultString + "Gegeven letter: " + c.toString() + " , feedback: " + inputWordFeedback.get(index) + "\n";
            index++;
        }
        inputWordFeedback.removeIf(feedback -> feedback.equals("Correct"));
        if(inputWordFeedback.size() == 0){
            score.goedeBeurd();
            score.woordGeraden();
            return "Gefeliciteerd, het woord was: " + word + ", en dit heb je goed geraden! Op naar de volgende ronden!";
        }
        return resultString;
    }

    public Character getFirstCharacterOfWord(){
        return wordArray.get(0);
    }
}
