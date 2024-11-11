# QuizApp - A Simple Java Quiz Application

## Overview

**QuizApp** is a basic multiple-choice quiz application developed using **Java** and **Swing** for graphical user interface (GUI).
The app presents a series of multiple-choice questions to the user, tracks their responses, and calculates their score in real-time. 
Each question has a time limit of 10 seconds. The application includes features like score tracking, a restart button, 
a progress bar, and exception handling to ensure smooth functioning.

## Features

- **Multiple-Choice Questions**: The quiz consists of five questions, each with four options (A, B, C, D).
- **Timer**: A 10-second countdown timer for each question, adding a challenge to the quiz.
- **Score Tracking**: The app keeps track of correct and incorrect answers, displaying the final score at the end of the quiz.
- **Restart Functionality**: After completing the quiz, users can restart the quiz with a reset button.
- **Progress Bar**: A visual progress bar shows the user's progression through the quiz.
- **Exception Handling**: The app is designed to handle errors gracefully, ensuring that any unexpected issues (e.g., timer, user input) are captured and displayed in a user-friendly manner.

## Prerequisites

Before running the **QuizApp**, ensure that you have the following:

- **Java 8+** or later installed on your computer.
- An Integrated Development Environment (**IDE**) like **Eclipse**, **IntelliJ IDEA**, or **NetBeans**, or a simple text editor for editing and compiling Java code.

You can download and install Java from the official Oracle website or use an OpenJDK distribution.

## Installation Instructions

Follow these steps to clone and set up **QuizApp** on your local machine:

### 1. Clone the Repository

Open a terminal and run the following command to clone the project repository to your local machine:

```bash
git clone https://github.com/sanjai104/CODSOFT.git

```

2. **Navigate** to the project directory:

    ```bash
    cd QuizApp

    ```

3. **Compile** the Java program using the following command:

    ```bash
    javac java QuizApp

    ```
## Usage
# How the quiz works

 - **Start the Quiz**: When you launch the app, it will display the first question with four possible answers (A, B, C, D).
 - **Select an Answer**: Click on one of the radio buttons corresponding to your choice (A, B, C, or D).
 - **Submit Answer**: After selecting an option, click the Submit button. If your answer is correct, your score will increase by 1.
 - **Timer**: Each question is timed for 10 seconds. If you do not select an answer within this time, the app will automatically move to the next question, and you will not get a score for that question.
 - **Progress Bar**: As you answer questions, the progress bar will show how far along you are in the quiz.
 - **Final Score**: At the end of the quiz, your score, along with the number of correct and incorrect answers, will be displayed.
 - **Restart Quiz**: After finishing, you can click the Restart button to reset the quiz and try again.

## Acknowledgements
- This project was developed as a simple practice for learning Java Swing and handling GUI-based applications.
- Swing library for GUI.
