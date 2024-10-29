import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class NumberGame {
    private static JTextField guessField;
    private static JLabel resultLabel;
    private static int randomNumber;
    private static int attempts;
    private static int currentRound = 1;
    private static final int TOTAL_ROUNDS = 3;

    private static final String ENTER_GUESS_MESSAGE = "Enter your guess (1-100):";
    private static final String WIN_MESSAGE = "Correct! You win round %d!";
    private static final String NEXT_ROUND_MESSAGE = "Starting round %d...";
    private static final String GAME_OVER_MESSAGE = "Game over! You've completed all rounds.";
    private static final String INVALID_INPUT_MESSAGE = "Please enter a valid number.";
    private static final String TOO_HIGH_MESSAGE = "Too high! Attempts left: %d";
    private static final String TOO_LOW_MESSAGE = "Too low! Attempts left: %d";
    private static final String ROUND_LOSS_MESSAGE = "Game over! The number was %d. You didn't win this round.";

    public static void main(String[] args) {
        startNewRound();
        createGUI();
    }

    private static void startNewRound() {
        randomNumber = new Random().nextInt(100) + 1;
        attempts = 5; // Reset attempts for each round
    }

    private static void createGUI() {
        JFrame frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));

        frame.add(new JLabel(ENTER_GUESS_MESSAGE));

        guessField = new JTextField();
        frame.add(guessField);

        resultLabel = new JLabel("");
        frame.add(resultLabel);

        guessField.addActionListener(e -> checkGuess(frame)); // Check guess when Enter is pressed

        frame.setPreferredSize(new Dimension(400, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void checkGuess(JFrame frame) {
        try {
            int guessNumber = Integer.parseInt(guessField.getText());
            attempts--;

            if (guessNumber == randomNumber) {
                handleWin(frame);
            } else if (attempts > 0) {
                resultLabel.setText(guessNumber > randomNumber ?
                    String.format(TOO_HIGH_MESSAGE, attempts) :
                    String.format(TOO_LOW_MESSAGE, attempts));
            } else {
                handleLoss(frame);
            }
        } catch (NumberFormatException e) {
            resultLabel.setText(INVALID_INPUT_MESSAGE);
        }

        guessField.setText(""); // Clear the input field for the next guess
    }

    private static void handleWin(JFrame frame) {
        resultLabel.setText(String.format(WIN_MESSAGE, currentRound));
        if (currentRound < TOTAL_ROUNDS) {
            currentRound++;
            resultLabel.setText(String.format(WIN_MESSAGE, currentRound) + " " + String.format(NEXT_ROUND_MESSAGE, currentRound));
            Timer nextRoundTimer = new Timer(2000, e -> {
                startNewRound();
                resultLabel.setText(""); // Clear the message for the next round
            });
            nextRoundTimer.setRepeats(false);
            nextRoundTimer.start();
        } else {
            resultLabel.setText(GAME_OVER_MESSAGE);
            scheduleFrameClose(frame);
        }
    }

    private static void handleLoss(JFrame frame) {
        resultLabel.setText(String.format(ROUND_LOSS_MESSAGE, randomNumber));
        scheduleFrameClose(frame);
    }

    private static void scheduleFrameClose(JFrame frame) {
        Timer timer = new Timer(2000, e -> frame.dispose());
        timer.setRepeats(false);
        timer.start();
    }
    
}
