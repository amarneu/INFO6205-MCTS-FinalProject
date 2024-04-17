package edu.neu.coe.info6205.mcts.connectFour;

import edu.neu.coe.info6205.mcts.connectFour.Game;
import edu.neu.coe.info6205.mcts.connectFour.Player;
import org.junit.Before;
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
        Player secondPlayer = game.getSecondPlayer();

        // Simulate a turn
        board.placeToken(0, firstPlayer.getToken());

        // Check if the active player has won
        assertTrue(board.checkVictory(firstPlayer.getToken()));
    }

    @Test
    public void testSwitchActivePlayer() {
        Game game = new Game();
        Board board = game.getBoard();
        Player firstPlayer = game.getFirstPlayer();
        Player secondPlayer = game.getSecondPlayer();

        // Simulate a turn for the first player
        board.placeToken(0, firstPlayer.getToken());

        // Switch the active player
        game.switchActivePlayer();

        // Check if the second player has won
        assertTrue(board.checkVictory(secondPlayer.getToken()));
    }
}
