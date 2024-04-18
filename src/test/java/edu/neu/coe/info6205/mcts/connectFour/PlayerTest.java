package edu.neu.coe.info6205.mcts.connectFour;

import edu.neu.coe.info6205.mcts.connectFour.Player;
import org.junit.Test;
import static org.junit.Assert.*;
public class PlayerTest {

    @Test
    public void testPlayerToken() {
        Player player = new Player('A');
        assertEquals('A', player.getToken());
    }

    @Test
    public void testEquals() {
        Player player1 = new Player('X');
        Player player2 = new Player('X');
        assertTrue(player1.equals(player2));
    }

    @Test
    public void testNotEquals() {
        Player player1 = new Player('X');
        Player player2 = new Player('O');
        assertFalse(player1.equals(player2));
    }

    @Test
    public void testHashCode() {
        Player player1 = new Player('X');
        Player player2 = new Player('X');
        assertEquals(player1.hashCode(), player2.hashCode());
    }

}

