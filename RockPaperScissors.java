import java.util.Random;

public class RockPaperScissors {
    private Random rand = new Random();
    private String computerOption, userOption;
    private int winner; // 1 = user, 2 = computer, 3 = draw

    // Method to get computer's choice
    public void computerChoice() {
        int randomNumber = rand.nextInt(3) + 1;
        if (randomNumber == 1) {
            computerOption = "Rock";
        } else if (randomNumber == 2) {
            computerOption = "Paper";
        } else if (randomNumber == 3) {
            computerOption = "Scissors";
        }
    }

    // Method to set user's choice
    public void userChoice(String choice) {
        userOption = choice;
    }

    // Method to validate the winner
    public void validateWinner() {
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
    }

    public int getWinner() {
        return winner;
    }

    public String getComputerOption() {
        return computerOption;
    }

    public String getUserOption() {
        return userOption;
    }
}
