import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {

    // computer's choice
    public static String getComputerChoice() {
        Random random = new Random();
        int choice = random.nextInt(3);
        // Generates a random number between 0 and 2
        switch (choice) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                return "rock";
        }
    }
    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "tie";
        }

        // Check all possible winning conditions for the user
        if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "user";
        } else {
            return "computer";
        }
    }

    // Method to start game
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int userScore = 0;
        int computerScore = 0;
        int rounds = 3;

        System.out.println("Welcome to Rock, Paper, Scissors Game!");
        System.out.println("Best of 3 rounds. Let’s begin!");


        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round);
            String userChoice;
            String computerChoice = getComputerChoice();

            // Getting and validating the user's input
            while (true) {
                System.out.print("Enter your choice (rock/paper/scissors): ");
                userChoice = scanner.next().toLowerCase();
                if (userChoice.equals("rock") || userChoice.equals("paper") || userChoice.equals("scissors")) {
                    break;
                } else {
                    System.out.println("Invalid input! Please enter rock, paper, or scissors.");
                }
            }

            System.out.println("Computer chose: " + computerChoice);

            // Determine the winner of the round
            String winner = determineWinner(userChoice, computerChoice);

            // Update scores
            if (winner.equals("user")) {
                userScore++;
                System.out.println("You win this round!");
            } else if (winner.equals("computer")) {
                computerScore++;
                System.out.println("Computer wins this round!");
            } else {
                System.out.println("This round is a tie.");
            }

            // Display the current score
            System.out.println("Current Score -> You: " + userScore + ", Computer: " + computerScore);
        }

        // Determine the overall winner
        if (userScore > computerScore) {
            System.out.println("\nCongratulations! You won the match!");
        } else if (computerScore > userScore) {
            System.out.println("\nComputer wins the match! Better luck next time.");
        } else {
            System.out.println("\nIt's a tie match!");
        }

        // Ask if the user wants to play again
        System.out.print("\nDo you want to play again? (yes/no): ");
        String playAgain = scanner.next().toLowerCase();
        if (playAgain.equals("yes")) {
            playGame();
        } else {
            System.out.println("Thanks for playing! Goodbye.");
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}
