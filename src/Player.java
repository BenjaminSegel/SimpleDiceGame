import java.util.List;
import java.util.ArrayList;
public class Player {
    private String name;
    private int guess;
    private int score;
    private int totalRollValue;
    List<Die> dices;

    public Player(String name){
        this.name = name;
        dices = new ArrayList<Die>();
    }

    public void setGuess(int guess){
        this.guess = guess;
    }
    public int getGuess(){
        return guess;
    }
    public String getName(){
        return name;
    }
    public int getScore(){
        return score;
    }
    public void rollDices(){
        for(Die dice : dices) {
            dice.roll();
        }
    }
    public int getRollResult(){
        for(Die dice : dices){
         totalRollValue += dice.getCurrentValue();
        }
         return totalRollValue;
    }
    public void incScore(){
        score++;
    }
    public void addDie(int sides){
        Die newDie = new Die(sides);
        dices.add(newDie);
    }
    public void resetTotalRollValue(){
       totalRollValue = 0;
    }

    public boolean playerWonRound(){
        return totalRollValue == guess;
    }

}
