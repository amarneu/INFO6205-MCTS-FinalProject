package edu.neu.coe.info6205.mcts.connectFour;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testInitialBoardIsEmpty() {
        Board board = new Board();
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                assertEquals('.', board.getGameBoard()[row][col]);
            }
        }
    }

    @Test
    public void testPlaceToken() {
        Board board = new Board();
        board.placeToken(0, 'A');
        assertEquals('A', board.getGameBoard()[5][0]);
    }

    @Test
    public void testIsGridFull() {
        Board board = new Board();
        for (int i = 0; i < board.getNumRows(); i++) {
            for (int j = 0; j < board.getNumColumns(); j++) {
                board.placeToken(j, 'A');
            }
        }
        assertTrue(board.isGridFull());
    }

    @Test
    public void testCheckVictory() {
        Board board = new Board();
        board.placeToken(0, 'A');
        board.placeToken(1, 'A');
        board.placeToken(2, 'A');
        board.placeToken(3, 'A');
        assertTrue(board.checkVictory('A'));
    }

    @Test
    public void testHorizontalVictoryDifferentRows() {
        Board board = new Board();
        for (int row = 0; row < board.getNumRows(); row++) {
            board.placeToken(0, 'A');
            board.placeToken(1, 'A');
            board.placeToken(2, 'A');
            board.placeToken(3, 'A');
            assertTrue(board.checkVictory('A'));
            board = new Board(); // Reset the board for the next iteration
        }
    }

    @Test
    public void testVerticalVictory() {
        Board board = new Board();
        board.placeToken(0, 'A');
        board.placeToken(0, 'A');
        board.placeToken(0, 'A');
        board.placeToken(0, 'A');
        assertTrue(board.checkVictory('A'));
    }

    @Test
    public void testPlaceTokenInvalidColumn() {
        Board board = new Board();
        assertFalse(board.placeToken(-1, 'A'));  // Test negative column index
        assertFalse(board.placeToken(7, 'A'));   // Test column index beyond the last valid column (assuming 0-6 are valid)
    }

    @Test
    public void testFullColumn() {
        Board board = new Board();
        for (int i = 0; i < board.getNumRows(); i++) {
            assertTrue(board.placeToken(0, 'A'));
        }
        assertFalse(board.placeToken(0, 'A'));  // This should fail as column 0 is now full
    }

    @Test
    public void testMajorDiagonalVictory() {
        Board board = new Board();
        board.placeToken(0, 'A');
        board.placeToken(1, 'O');
        board.placeToken(1, 'A');
        board.placeToken(2, 'O');
        board.placeToken(2, 'O');
        board.placeToken(2, 'A');
        board.placeToken(3, 'O');
        board.placeToken(3, 'O');
        board.placeToken(3, 'O');
        board.placeToken(3, 'A');
        assertTrue(board.checkVictory('A'));
    }

    @Test
    public void testMinorDiagonalVictory() {
        Board board = new Board();
        board.placeToken(3, 'A');
        board.placeToken(2, 'O');
        board.placeToken(2, 'A');
        board.placeToken(1, 'O');
        board.placeToken(1, 'O');
        board.placeToken(1, 'A');
        board.placeToken(0, 'O');
        board.placeToken(0, 'O');
        board.placeToken(0, 'O');
        board.placeToken(0, 'A');
        assertTrue(board.checkVictory('A'));
    }

}