package edu.neu.coe.info6205.mcts.connectFour;

import java.util.Objects;

public class Player {
    private final char token; // The character token representing the player

    public Player(char token) {
        this.token = token;
    }

    public char getToken() {
        // Returns the character token associated with the player
        return this.token;
    }

    @Override
    public boolean equals(Object obj) {
        // Overrides the equals method to compare two Player objects based on their token values
        if (this == obj) return true; // If the objects are the same instance, return true
        if (obj == null || getClass() != obj.getClass()) return false; // If the other object is null or not a Player, return false
        Player player = (Player) obj;
        return token == player.token; // Compare the token values of the two Player objects
    }

    @Override
    public int hashCode() {
        // Overrides the hashCode method to generate a hash code based on the player's token
        return Objects.hash(token);
    }
}