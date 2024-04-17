package edu.neu.coe.info6205.mcts.connectFour;

import edu.neu.coe.info6205.mcts.connectFour.Board;
import org.junit.Before;
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
        for (int i = 0; i < 42; i++) {
            board.placeToken(0, 'A');
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
}
