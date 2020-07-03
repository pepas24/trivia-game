# Trivia game with JavaFX

This is a triva game developed with JavaFX library.

It is a game for one player, the user can choose a category for the questions, then she select an answer from a list of posible options. Each correct asnwer give her 10 point. When she has answer all questions, she is presented with a resume of correct and incorrect answers and total points achived.

The categories and answers can be configurated via a txt file, and placed in resources/questions folder, the game will load them all.


# Project structure

- `src`: source code of game
- `lib`: external libraries


# Setup

Follow instructions in the official documentation of JavaFX to setup a JavaFX environment.
Be sure to include JavaFX and JUnit libraries.

For VS Code add JavaFX ans JUnit jars in `lib` folder. And create a `launch.json` file in `.vscode` folder, there is a sample file called `launch.sample.json`.

Configure your IDE to include `.editorconfig` rules to keep the same code style.


# Documentation

Use Javadoc to include the necesary documentation.

You can generate Javadocs using your IDE, be sure to exclude it from git.
