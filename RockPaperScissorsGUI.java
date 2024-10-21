import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorsGUI {
    private static RockPaperScissors game = new RockPaperScissors();
    private static JLabel resultLabel = new JLabel("", JLabel.CENTER);
    private static JLabel computerChoiceLabel = new JLabel("", JLabel.CENTER);
    private static JLabel userChoiceLabel = new JLabel("", JLabel.CENTER);
    private static JLabel userScoreLabel = new JLabel("You: 0", JLabel.CENTER);
    private static JLabel computerScoreLabel = new JLabel("Computer: 0", JLabel.CENTER);
    private static int userScore = 0;
    private static int computerScore = 0;

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Please choose rock, paper or scissors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Create the title label
        JLabel titleLabel = new JLabel("Please choose rock, paper or scissors", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Create the panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Load and resize images
        ImageIcon rockIcon = new ImageIcon("/Users/callumoreilly/Library/CloudStorage/OneDrive-TechnologicalUniversityDublin/Personal/RockPaperScissors/RockPaperScissors/src/Dwayne_\"The_Rock\"_Johnson_Visits_the_Pentagon_(41)_(cropped).jpg");
        ImageIcon paperIcon = new ImageIcon("/Users/callumoreilly/Library/CloudStorage/OneDrive-TechnologicalUniversityDublin/Personal/RockPaperScissors/RockPaperScissors/src/paper_111691001.jpg");
        ImageIcon scissorsIcon = new ImageIcon("/Users/callumoreilly/Library/CloudStorage/OneDrive-TechnologicalUniversityDublin/Personal/RockPaperScissors/RockPaperScissors/src/student-scissors-right-handedcm26-1012-550x688h.jpg");

        Image rockImg = rockIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        Image paperImg = paperIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        Image scissorsImg = scissorsIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);

        rockIcon = new ImageIcon(rockImg);
        paperIcon = new ImageIcon(paperImg);
        scissorsIcon = new ImageIcon(scissorsImg);

        // Create buttons with images
        JButton rockButton = new JButton(rockIcon);
        JButton paperButton = new JButton(paperIcon);
        JButton scissorsButton = new JButton(scissorsIcon);

        // Add action listeners to buttons
        rockButton.addActionListener(new ChoiceListener("Rock"));
        paperButton.addActionListener(new ChoiceListener("Paper"));
        scissorsButton.addActionListener(new ChoiceListener("Scissors"));

        // Add buttons to panel
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);

        // Add button panel to frame
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Create the panel to hold score labels and reset button
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(userScoreLabel, BorderLayout.WEST);
        topPanel.add(computerScoreLabel, BorderLayout.EAST);

        // Create the reset button
        JButton resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(80, 30)); // Set preferred size
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetScores();
            }
        });
        topPanel.add(resetButton, BorderLayout.CENTER);

        // Add top panel to frame
        frame.add(topPanel, BorderLayout.NORTH);

        // Add result labels to frame
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(3, 1));
        resultPanel.add(userChoiceLabel);
        resultPanel.add(computerChoiceLabel);
        resultPanel.add(resultLabel);
        frame.add(resultPanel, BorderLayout.SOUTH);

        // Set the frame to be visible
        frame.setVisible(true);
    }

    static class ChoiceListener implements ActionListener {
        private String userChoice;

        public ChoiceListener(String choice) {
            this.userChoice = choice;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            game.userChoice(userChoice);
            game.computerChoice();
            game.validateWinner();
            userChoiceLabel.setText("You chose: " + game.getUserOption());
            computerChoiceLabel.setText("The computer chose: " + game.getComputerOption());
            int winner = game.getWinner();
            if (winner == 1) {
                resultLabel.setText("The user won!");
                userScore++;
                userScoreLabel.setText("You: " + userScore);
            } else if (winner == 2) {
                resultLabel.setText("The computer won!");
                computerScore++;
                computerScoreLabel.setText("Computer: " + computerScore);
            } else {
                resultLabel.setText("It was a draw!");
            }
        }
    }

    private static void resetScores() {
        userScore = 0;
        computerScore = 0;
        userScoreLabel.setText("You: " + userScore);
        computerScoreLabel.setText("Computer: " + computerScore);
        resultLabel.setText("");
        userChoiceLabel.setText("");
        computerChoiceLabel.setText("");
    }
}
