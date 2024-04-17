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
}

