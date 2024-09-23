import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class DiceGame {
    public static void main(String[] args) {
        int gameRound = 1;
        Scanner scanner = new Scanner(System.in);
        List<Player> AllPlayers = new ArrayList<Player>();
        System.out.println("How many players are you?");
        int players = scanner.nextInt();
        System.out.println("How many dices should each player have?");
        int dices = scanner.nextInt();
        System.out.println("How many sides should each die have?");
        int sides = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < players; i++) {
            System.out.println("Player " + (i+1) + " what is your name?:");
            String name = scanner.nextLine();
            Player newPlayer = new Player(name);
            for(int j = 0; j < dices; j++) {
                newPlayer.addDie(sides);
            }
            AllPlayers.add(newPlayer);
        }

        int totalRounds = 1;
        System.out.println("Welcome to the Dice Game!");
        while(gameRound <= totalRounds){
            System.out.println("Round " + gameRound);
            for(Player player : AllPlayers){
                System.out.println(player.getName() +
                        " Please guess the value you think you are going to roll: ");
                player.rollDices();
                int guess = scanner.nextInt();
                player.setGuess(guess);
                System.out.println(player.getName() + "'s guess was: " + player.getGuess() +
                        ", the dice rolled: " + player.getRollResult());
                if(player.playerWonRound()){
                    player.incScore();
                    System.out.println(player.getName() + "'s guess was correct!" + System.lineSeparator() +
                            player.getName() + "'s current score is: " + player.getScore());
                }else{
                System.out.println("Wrong guess, moving on...");
                }
                player.resetTotalRollValue();
            }
            gameRound++;
        }
        int maxScore = AllPlayers.stream().mapToInt(Player::getScore).max().orElse(0);

        // Determine the winners
        List<Player> winners = new ArrayList<>();
        for (Player player : AllPlayers) {
            if (player.getScore() == maxScore && player.getScore() > 0) {
                winners.add(player);
            }
        }

        System.out.println("\nGame Over!");
        if (winners.size() == 1) {
            System.out.println("The winner is: " + winners.get(0).getName() + " with " + maxScore + " points!");
        }else if(winners.isEmpty()){
            System.out.println("No winners this time!");
        } else {
            System.out.println("It's a tie between the following players with " + maxScore + " points:");
            for (Player winner : winners) {
                System.out.println(winner.getName());
            }

        }


        scanner.close();

    }
}
