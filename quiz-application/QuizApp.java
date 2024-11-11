import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp {
    private int score = 0;
    private int currentQuestionIndex = 0;
    private int correctAnswersCount = 0;
    private int incorrectAnswersCount = 0;
    private char[] correctAnswers = {'C', 'B', 'B', 'A', 'D'};
    private String[][] questions = {
            {"What is the capital of France?", "A. Berlin", "B. Madrid", "C. Paris", "D. Rome"},
            {"Which planet is known as the Red Planet?", "A. Earth", "B. Mars", "C. Jupiter", "D. Saturn"},
            {"What is the largest mammal?", "A. Elephant", "B. Blue Whale", "C. Giraffe", "D. Rhinoceros"},
            {"Which country is known as the Land of the Rising Sun?", "A. Japan", "B. China", "C. South Korea", "D. India"},
            {"Who developed the theory of relativity?", "A. Isaac Newton", "B. Nikola Tesla", "C. Galileo Galilei", "D. Albert Einstein"}
    };
    private Timer timer;
    private JLabel questionLabel;
    private JRadioButton[] options;
    private JButton submitButton, restartButton;
    private ButtonGroup buttonGroup;
    private JLabel timerLabel;
    private JProgressBar progressBar;
    private JFrame frame;

    public QuizApp() {
        try {
            frame = new JFrame("Quiz App");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            
            // Center on the screen
            frame.setLocationRelativeTo(null);

            questionLabel = new JLabel();
            questionLabel.setBounds(50, 30, 500, 30);
            frame.add(questionLabel);

            options = new JRadioButton[4];
            buttonGroup = new ButtonGroup();

            for (int i = 0; i < 4; i++) {
                options[i] = new JRadioButton();
                options[i].setBounds(50, 70 + (i * 30), 500, 30);
                buttonGroup.add(options[i]);
                frame.add(options[i]);
            }

            submitButton = new JButton("Submit");
            submitButton.setBounds(50, 220, 100, 30);
            frame.add(submitButton);

            restartButton = new JButton("Restart");
            restartButton.setBounds(160, 220, 100, 30);
            frame.add(restartButton);
            restartButton.setEnabled(false);

            timerLabel = new JLabel("Time left: 10");
            timerLabel.setBounds(400, 220, 150, 30);
            frame.add(timerLabel);

            progressBar = new JProgressBar(0, questions.length);
            progressBar.setBounds(50, 260, 500, 20);
            frame.add(progressBar);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        checkAnswer();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "An error occurred while checking the answer: " + ex.getMessage());
                    }
                }
            });

            restartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        resetQuiz();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "An error occurred while restarting the quiz: " + ex.getMessage());
                    }
                }
            });

            frame.setVisible(true);
            loadQuestion();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while initializing the quiz app: " + ex.getMessage());
        }
    }

    private void loadQuestion() {
        try {
            if (currentQuestionIndex < questions.length) {
                questionLabel.setText("Q" + (currentQuestionIndex + 1) + ": " + questions[currentQuestionIndex][0]);
                for (int i = 0; i < 4; i++) {
                    options[i].setText(questions[currentQuestionIndex][i + 1]);
                    options[i].setSelected(false);
                }
                startTimer();
            } else {
                showResults();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "An error occurred while loading the question: " + ex.getMessage());
        }
    }

    private void startTimer() { //Timer Starts here.
        try {
            timer = new Timer(1000, new ActionListener() {
                int timeLeft = 10;

                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        timerLabel.setText("Time left: " + timeLeft);
                        timeLeft--;

                        if (timeLeft < 0) {
                            ((Timer) e.getSource()).stop();
                            JOptionPane.showMessageDialog(null, "Time's up! Moving to next question.");
                            currentQuestionIndex++;
                            progressBar.setValue(currentQuestionIndex);
                            loadQuestion();
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "An error occurred while managing the timer: " + ex.getMessage());
                    }
                }
            });
            timer.start();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "An error occurred while starting the timer: " + ex.getMessage());
        }
    }

    private void checkAnswer() throws Exception {
        try {
            timer.stop();
            for (int i = 0; i < 4; i++) {
                if (options[i].isSelected()) {
                    char selectedOption = (char) ('A' + i);
                    if (selectedOption == correctAnswers[currentQuestionIndex]) {
                        score++;
                        correctAnswersCount++;
                        JOptionPane.showMessageDialog(null, "Correct!");
                    } else {
                        incorrectAnswersCount++;
                        JOptionPane.showMessageDialog(null, "Wrong! The correct answer was: " + correctAnswers[currentQuestionIndex]);
                    }
                    currentQuestionIndex++;
                    progressBar.setValue(currentQuestionIndex);
                    loadQuestion();
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Please select an option.");
        } catch (Exception ex) {
            throw new Exception("Error checking the answer: " + ex.getMessage());
        }
    }

    private void showResults() {
        try {
            JOptionPane.showMessageDialog(null, "Quiz Completed! Your score is: " + score + "/" + questions.length +
                    "\nCorrect answers: " + correctAnswersCount + "\nIncorrect answers: " + incorrectAnswersCount);
            restartButton.setEnabled(true); // Enable restart button after quiz completed
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "An error occurred while displaying the results: " + ex.getMessage());
        }
    }

    private void resetQuiz() throws Exception {
        try {
            score = 0;
            currentQuestionIndex = 0;
            correctAnswersCount = 0;
            incorrectAnswersCount = 0;
            restartButton.setEnabled(false); // Disable the restart button during the quiz
            progressBar.setValue(0); // Reset the progress bar
            loadQuestion();
        } catch (Exception ex) {
            throw new Exception("Error resetting the quiz: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}
