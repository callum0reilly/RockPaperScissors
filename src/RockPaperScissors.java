import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {// start of class RockPaperScissors
    Random rand = new Random();

    public RockPaperScissors() {// start of constructor
        wipe();
        computerChoice();
        userChoice();
        displayChoices();
        validateWinner();
        playAgain();

    }// end of constructor

    // variables

    String computerOption, userOption;

    // methods
    public void computerChoice() {// Start of computer choice
        int randomNumber = rand.nextInt(3) + 1;

        if (randomNumber == 1) {
            computerOption = "Rock";
        }
        if (randomNumber == 2) {
            computerOption = "Paper";
        }
        if (randomNumber == 3) {
            computerOption = "Scissors";
        }

    }// end of computerChoice

    public void wipe() {
        System.out.println("\f");
    }

    public void userChoice() {
        Scanner scan = new Scanner(System.in);
        wipe();
        // Prompt user until they enter a valid option
        while (true) {
            System.out.println("\nPlease enter Rock, Paper, or Scissors!");
            userOption = scan.nextLine();

            if (userOption.equalsIgnoreCase("Rock") ||
                    userOption.equalsIgnoreCase("Paper") ||
                    userOption.equalsIgnoreCase("Scissors")) {
                break; // Exit loop if input is valid
            } else {
                wipe();
                System.out.println("\nAnswer must be Rock, Paper, or Scissors");
            }
        } // end of while
    } // end of userChoice

    public void displayChoices() {// start of displayChoices
        wipe();
        countdown();
        wipe();
        System.out.println("\nYou chose: " + userOption);
        System.out.println("The computer chose: " + computerOption);
    }// end of displayChoices

    public void validateWinner() {// start of validateWinner
        int winner;

        if (userOption.equalsIgnoreCase("Rock") && computerOption.equalsIgnoreCase("Scissors")) {
            winner = 1;
        } else if (userOption.equalsIgnoreCase("Scissors") && computerOption.equalsIgnoreCase("Paper")) {
            winner = 1;
        } else if (userOption.equalsIgnoreCase("Paper") && computerOption.equalsIgnoreCase("Rock")) {
            winner = 1;
        } else if (userOption.equalsIgnoreCase(computerOption)) {
            winner = 3;
        } else {
            winner = 2;
        }

        // display the winner
        if (winner == 1) {
            System.out.println("\nThe user won!");
        } else if (winner == 2) {
            System.out.println("\nThe computer won");
        } else {
            System.out.println("\nIt was a draw!");
        }
    }// end of validateWinner

    public void countdown() {// start of countdown
        wipe();
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            try {
                // Pause execution for 1000 milliseconds (1 second)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle the exception
                System.err.println("Thread was interrupted");
            }
        }

    }// end of countdown

    public void playAgain() {// start of playAgain
        Scanner scan = new Scanner(System.in);
        String repeat;
        do {
            System.out.println("\nPress enter to play for a rematch!");
            repeat = scan.nextLine();

            if (!repeat.equalsIgnoreCase("")) {
                wipe();
                System.out.println("ERROR: PRESS ENTER TO PLAY AGAIN");
            }
            ;

        } while (!repeat.equalsIgnoreCase(""));// end of do while

        wipe();
        new RockPaperScissors();
    }// end of playAgain

    public static void main(String[] args) {// start of main method
        new RockPaperScissors();// call constructor
    }// end of main method

}// end of class
