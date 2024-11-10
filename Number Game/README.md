# Number Guessing Game

This is a simple Number Guessing Game built using Java and Swing. 
The objective of the game is to guess a randomly generated number within a range of 1 to 100. 
The game consists of multiple rounds, and the player has limited attempts to guess the correct number in each round.

## Features

- **3 Rounds**: The game consists of 3 rounds, with a new number to guess in each round.
- **Limited Attempts**: Players have 5 attempts per round to guess the number correctly.
- **Feedback**: After each guess, the game provides feedback whether the guess is too high, too low, or correct.
- **Round Transition**: Upon winning a round, the game moves to the next round, providing a countdown before starting the next round.
- **Game Over**: The game ends when the player finishes all rounds or runs out of attempts in any round.
- **Simple GUI**: The game features a user-friendly GUI built using Java Swing.

## Requirements

- **Java Development Kit (JDK)** version 8 or higher.
- A Java Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or any text editor.
- Basic knowledge of Java programming and GUI development.

## How to Run

1. **Clone or Download** the repository to your local machine:

    ```bash
    git clone https://github.com/your-username/number-guessing-game.git
    ```

2. **Navigate** to the project directory:

    ```bash
    cd number-guessing-game
    ```

3. **Compile** the Java program using the following command:

    ```bash
    javac NumberGame.java
    ```

4. **Run** the game:

    ```bash
    java NumberGame
    ```

Alternatively, you can open the project in your preferred Java IDE and run the `NumberGame.java` file.

## Gameplay

1. Upon starting the game, the player is prompted to guess a number between 1 and 100.
2. After each guess, the game will display feedback:
   - If the guess is too high, the player will be told: "Too high! Attempts left: x".
   - If the guess is too low, the player will be told: "Too low! Attempts left: x".
   - If the guess is correct, the player wins the round and moves to the next one.
3. The player has 5 attempts per round. If the player does not guess correctly within 5 attempts, the game shows the correct number and ends that round.
4. After completing all 3 rounds, the game will display the message: "Game over! You've completed all rounds."

## Example Gameplay

1. **Round 1 starts**. A random number is generated.
2. The user enters a guess, for example, `50`.
   - If the number is too high or low, a message will show with the remaining attempts.
3. If the user guesses correctly within 5 attempts, they win the round, and the game proceeds to Round 2.
4. The game continues this way until all rounds are completed or the user runs out of attempts.

## Game Over

- If the user completes all rounds, they will see the message: `"Game over! You've completed all rounds."`.
- If the user fails to guess the correct number in any round, the game will show the correct number and end the round with a loss.


Feel free to contribute, report bugs, or suggest improvements. Happy playing!
