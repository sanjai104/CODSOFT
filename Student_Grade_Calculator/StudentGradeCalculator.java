import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Student Grade Calculator");
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create and add components
        JLabel numSubjectsLabel = new JLabel("Enter the number of subjects:");
        numSubjectsLabel.setBounds(20, 20, 200, 25);
        frame.add(numSubjectsLabel);

        JTextField numSubjectsField = new JTextField();
        numSubjectsField.setBounds(220, 20, 150, 25);
        frame.add(numSubjectsField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(100, 60, 100, 25);
        frame.add(submitButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(220, 60, 100, 25);
        frame.add(clearButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(20, 100, 390, 200);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        frame.add(resultArea);

        //  Submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the number of subjects from user input
                    int numSubjects = Integer.parseInt(numSubjectsField.getText());
                    if (numSubjects <= 0) {
                        JOptionPane.showMessageDialog(frame, "Number of subjects must be greater than zero.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    int[] marks = new int[numSubjects];
                    int totalMarks = 0;

                    // Get marks for each subject
                    for (int i = 0; i < numSubjects; i++) {
                        String input = JOptionPane.showInputDialog(frame, "Enter marks obtained in subject " + (i + 1) + " (0-100):");
                        if (input != null) {
                            int mark = Integer.parseInt(input);
                            if (mark < 0 || mark > 100) {
                                JOptionPane.showMessageDialog(frame, "Marks must be between 0 and 100.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                                i--; // checks the inputs
                                continue;
                            }
                            marks[i] = mark;
                            totalMarks += mark;
                        } else {
                            JOptionPane.showMessageDialog(frame, "Input canceled. Please enter marks for all subjects.", "Input Required", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }

                    // Calculate the average percentage
                    double averagePercentage = (double) totalMarks / numSubjects;
                    int averageRange = (int) averagePercentage / 10;

                    //  grade based on the average percentage
                    char grade;
                    String gradeMessage = "";
                    switch (averageRange) {
                        case 10: // For 100% (exception case)
                        case 9: // Grade A for 90% and above
                            grade = 'A';
                            gradeMessage = "Excellent work! Keep it up!";
                            break;
                        case 8: // Grade B for 80-89%
                            grade = 'B';
                            gradeMessage = "Great job! You can aim for A next time!";
                            break;
                        case 7: // Grade C for 70-79%
                            grade = 'C';
                            gradeMessage = "Good effort, but there's room for improvement.";
                            break;
                        case 6: // Grade D for 60-69%
                            grade = 'D';
                            gradeMessage = "You passed, but you need to work harder.";
                            break;
                        default: // Grade F for below 60%
                            grade = 'F';
                            gradeMessage = "You did not pass. Don't give up, study harder!";
                            break;
                    }

                    // Display the results with grade message
                    resultArea.setText("Total Marks: " + totalMarks +
                            "\nAverage Percentage: " + averagePercentage + "%" +
                            "\nGrade: " + grade +
                            "\nFeedback: " + gradeMessage);
                } catch (NumberFormatException ex) {
                    // Handle invalid number input
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Clear button
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear the input fields and result area
                numSubjectsField.setText("");
                resultArea.setText("");
            }
        });

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}
