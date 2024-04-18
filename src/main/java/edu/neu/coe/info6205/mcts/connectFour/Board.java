package edu.neu.coe.info6205.mcts.connectFour;

public class Board {
    private final int numRows = 6; // Number of rows in the game board
    private final int numColumns = 7; // Number of columns in the game board
    private char[][] gameBoard; // 2D array representing the game board

    public Board() {
        // Initialize the game board with empty cells
        gameBoard = new char[numRows][numColumns];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                gameBoard[row][col] = '.';
            }
        }
    }

    public void displayBoard() {
        // Print the current state of the game board
        for (char[] row : gameBoard) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public boolean placeToken(int column, char token) {
        // Place a token in the specified column
        if (column < 0 || column >= numColumns) {
            // Invalid column, return false
            return false;
        }
        for (int row = numRows - 1; row >= 0; row--) {
            if (gameBoard[row][column] == '.') {
                gameBoard[row][column] = token;
                return true; // Token placed successfully
            }
        }
        return false; // Column is full, token cannot be placed
    }

    public boolean isGridFull() {
        // Check if the game board is completely filled
        for (int col = 0; col < numColumns; col++) {
            if (gameBoard[0][col] == '.') {
                return false; // At least one cell is empty
            }
        }
        return true; // All cells are filled
    }

    public boolean checkVictory(char token) {
        // Check if the specified token has achieved a winning condition
        // Check for horizontal wins
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns - 3; col++) {
                if (gameBoard[row][col] == token && gameBoard[row][col + 1] == token &&
                        gameBoard[row][col + 2] == token && gameBoard[row][col + 3] == token) {
                    return true; // Horizontal win detected
                }
            }
        }

        // Check for vertical wins
        for (int col = 0; col < numColumns; col++) {
            for (int row = 0; row < numRows - 3; row++) {
                if (gameBoard[row][col] == token && gameBoard[row + 1][col] == token &&
                        gameBoard[row + 2][col] == token && gameBoard[row + 3][col] == token) {
                    return true; // Vertical win detected
                }
            }
        }

        // Check for positive diagonal wins
        for (int row = 3; row < numRows; row++) {
            for (int col = 0; col < numColumns - 3; col++) {
                if (gameBoard[row][col] == token && gameBoard[row - 1][col + 1] == token &&
                        gameBoard[row - 2][col + 2] == token && gameBoard[row - 3][col + 3] == token) {
                    return true; // Positive diagonal win detected
                }
            }
        }

        // Check for negative diagonal wins
        for (int row = 0; row < numRows - 3; row++) {
            for (int col = 0; col < numColumns - 3; col++) {
                if (gameBoard[row][col] == token && gameBoard[row + 1][col + 1] == token &&
                        gameBoard[row + 2][col + 2] == token && gameBoard[row + 3][col + 3] == token) {
                    return true; // Negative diagonal win detected
                }
            }
        }

        return false; // No winning condition found
    }

    public char[][] getGameBoard() {
        // Get the game board
        return gameBoard;
    }

    public int getNumRows() {
        // Get the number of rows in the game board
        return numRows;
    }

    public int getNumColumns() {
        // Get the number of columns in the game board
        return numColumns;
    }

    public void setGameBoard(char[][] gameBoard) {
        // Set the game board with a new 2D character array
        this.gameBoard = gameBoard;
    }
}