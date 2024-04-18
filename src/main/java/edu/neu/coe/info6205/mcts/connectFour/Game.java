package edu.neu.coe.info6205.mcts.connectFour;

import java.util.Random;

public class Game {
    private Board board; // The game board
    private Player firstPlayer; // The first player
    private Player secondPlayer; // The second player
    private Player activePlayer; // The currently active player
    private Random rng = new Random(); // Random number generator for making random moves

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        // Initialize the game components
        board = new Board();
        firstPlayer = new Player('A');
        secondPlayer = new Player('O');
        chooseStartingPlayer();
    }

    private void chooseStartingPlayer() {
        // Randomly choose the starting player
        activePlayer = rng.nextBoolean() ? firstPlayer : secondPlayer;
        System.out.println("Player " + activePlayer.getToken() + " starts the game");
    }

    public void start() {
        // Start the game loop
        boolean isGameOver = false;
        while (!isGameOver) {
            isGameOver = takeTurn();
        }
    }

    boolean takeTurn() {
        // Take a turn in the game
        board.displayBoard(); // Display the current board state
        int columnChoice = rng.nextInt(7); // Randomly choose a column (assuming 7 columns)
        if (!board.placeToken(columnChoice, activePlayer.getToken())) {
            // If the chosen column is full, try again
            System.out.println("Column " + columnChoice + " is full, try again.");
            return false;
        }

        System.out.println("Player " + activePlayer.getToken() + " placed a token in column " + columnChoice);

        if (board.checkVictory(activePlayer.getToken())) {
            // If the active player has won, display the board and announce the winner
            board.displayBoard();
            System.out.println("Player " + activePlayer.getToken() + " wins!");
            return true;
        } else if (board.isGridFull()) {
            // If the board is full and no one has won, it's a draw
            board.displayBoard();
            System.out.println("The game is a draw!");
            return true;
        }

        // Switch to the next player
        switchActivePlayer();
        return false;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public Random getRng() {
        return rng;
    }

    public void setRng(Random rng) {
        this.rng = rng;
    }

    void switchActivePlayer() {
        // Switch the active player
        activePlayer = (activePlayer == firstPlayer) ? secondPlayer : firstPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }
}