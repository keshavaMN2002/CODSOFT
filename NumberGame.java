package firstprogram.com;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxAttempts = 8;

        int roundsWon = 0;
        int totalAttempts = 0;

        while (true) {
            // Random class
            Random random = new Random();

            // random number between 1 and 100
            int generatedNumber = random.nextInt(100) + 1;

            int userGuess = 0;
            boolean roundWon = false;

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.println("Attempt " + attempt + " of " + maxAttempts + ": Guess the generated number between 1 and 100:");

                userGuess = scanner.nextInt();
                totalAttempts++;

                if (userGuess < generatedNumber) {
                    System.out.println("Your guess is too low. Try again!");
                } else if (userGuess > generatedNumber) {
                    System.out.println("Your guess is too high. Try again!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    roundWon = true;
                    break;
                }

                if (attempt == maxAttempts) {
                    System.out.println("Sorry, you've used all your attempts. The correct number was " + generatedNumber + ".");
                }
            }

            if (roundWon) {
                roundsWon++;
            }

            // Display user score
            System.out.println("Your current score: " + roundsWon + " round(s) won, " + totalAttempts + " total attempts.");

            // Another round
            System.out.println("Would you like to play again? (yes/no):");
            String playAgain = scanner.next();

            // If no exit the loop
            if (playAgain.equalsIgnoreCase("no")) {
                System.out.println("Thanks for playing! You won " + roundsWon + " round(s) and took " + totalAttempts + " attempts in total.");
                break;
            }
        }

        scanner.close();
    }
}
