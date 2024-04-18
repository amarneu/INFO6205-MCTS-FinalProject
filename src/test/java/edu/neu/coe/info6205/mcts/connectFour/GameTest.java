package edu.neu.coe.info6205.mcts.connectFour;

import org.junit.Test;
import static org.junit.Assert.*;
public class GameTest {

    @Test
    public void testGameInitialization() {
        Game game = new Game();
        assertNotNull(game.getBoard());
        assertNotNull(game.getFirstPlayer());
        assertNotNull(game.getSecondPlayer());
        assertNotNull(game.getActivePlayer());
    }

    @Test
    public void testTakeTurn() {
        Game game = new Game();
        Board board = game.getBoard();
        Player firstPlayer = game.getFirstPlayer();
        // Simulate a series of turns to create a winning condition
        for (int i = 0; i < 4; i++) {
            board.placeToken(i, firstPlayer.getToken());
        }

        // Check if the active player has won
        assertTrue(board.checkVictory(firstPlayer.getToken()));
    }
    @Test
    public void testSwitchActivePlayer() {
        Game game = new Game();
        Board board = game.getBoard();
        Player firstPlayer = game.getFirstPlayer();
        Player secondPlayer = game.getSecondPlayer();

        // Simulate a sequence of moves
        board.placeToken(0, firstPlayer.getToken());
        board.placeToken(1, secondPlayer.getToken());
        board.placeToken(0, firstPlayer.getToken());
        board.placeToken(1, secondPlayer.getToken());
        board.placeToken(0, firstPlayer.getToken());

        // Switch the active player
        game.switchActivePlayer();

        // Now, check if the active player is the second player
        assertEquals(secondPlayer, game.getActivePlayer());
    }

}
