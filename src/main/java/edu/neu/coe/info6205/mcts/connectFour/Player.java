package edu.neu.coe.info6205.mcts.connectFour;

import java.util.Objects;

public class Player {
    private final char token;

    public Player(char token){
        this.token = token;
    }

    public char getToken(){
        return this.token;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Player player = (Player) obj;
        return token == player.token;
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}


