package edu.neu.coe.info6205.mcts.connectFour;

public class Board {
    private final int numRows = 6;
    private final int numColumns = 7;
    private char[][] gameBoard;

    public Board() {
        gameBoard = new char[numRows][numColumns];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                gameBoard[row][col] = '.';
            }
        }
    }

    public void displayBoard() {
        for (char[] row : gameBoard) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public boolean placeToken(int column, char token) {
        if (column < 0 || column >= numColumns) {
            return false;
        }
        for (int row = numRows - 1; row >= 0; row--) {
            if (gameBoard[row][column] == '.') {
                gameBoard[row][column] = token;
                return true;
            }
        }
        return false;
    }

    public boolean isGridFull() {
        for (int col = 0; col < numColumns; col++) {
            if (gameBoard[0][col] == '.') {
                return false;
            }
        }
        return true;
    }

    public boolean checkVictory(char token) {

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns - 3; col++) {
                if (gameBoard[row][col] == token && gameBoard[row][col + 1] == token &&
                        gameBoard[row][col + 2] == token && gameBoard[row][col + 3] == token) {
                    return true;
                }
            }
        }

        for (int col = 0; col < numColumns; col++) {
            for (int row = 0; row < numRows - 3; row++) {
                if (gameBoard[row][col] == token && gameBoard[row + 1][col] == token &&
                        gameBoard[row + 2][col] == token && gameBoard[row + 3][col] == token) {
                    return true;
                }
            }
        }

        for (int row = 3; row < numRows; row++) {
            for (int col = 0; col < numColumns - 3; col++) {
                if (gameBoard[row][col] == token && gameBoard[row - 1][col + 1] == token &&
                        gameBoard[row - 2][col + 2] == token && gameBoard[row - 3][col + 3] == token) {
                    return true;
                }
            }
        }

        for (int row = 0; row < numRows - 3; row++) {
            for (int col = 0; col < numColumns - 3; col++) {
                if (gameBoard[row][col] == token && gameBoard[row + 1][col + 1] == token &&
                        gameBoard[row + 2][col + 2] == token && gameBoard[row + 3][col + 3] == token) {
                    return true;
                }
            }
        }

        return false;
    }
}