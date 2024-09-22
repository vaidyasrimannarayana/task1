import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MAX_ATTEMPTS = 5; // Maximum number of attempts per game
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain;
        do {
            int numberToGuess = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess a number between " + MIN_RANGE + " and " + MAX_RANGE + ".");
            
            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.println("You have " + attemptsLeft + " attempts left.");
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number correctly.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
                
                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
            } else {
                score += (MAX_ATTEMPTS - attemptsLeft); // Score based on remaining attempts
            }
            
            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);
        
        System.out.println("Thanks for playing! Final score: " + score);
        scanner.close();
    }
}