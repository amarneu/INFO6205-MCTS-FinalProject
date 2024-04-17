package edu.neu.coe.info6205.mcts.tictactoe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import edu.neu.coe.info6205.mcts.core.Move;
import edu.neu.coe.info6205.mcts.core.Node;
import edu.neu.coe.info6205.mcts.core.State;

/**
 * Class to represent a Monte Carlo Tree Search for TicTacToe.
 */
public class MCTS {

    // Defining the simulation limit
    static final int SIMULATION_LIMIT = 1000; 
    // Defining the exploration parameter
    private static final double EXPLORATION_PARAM = Math.sqrt(2); 
    // Defining the root node
    static TicTacToeNode root;

    public static void main(String[] args) {

        // Machine vs Machine

        TicTacToe game = new TicTacToe();
        root = new TicTacToeNode(game.start());
        MCTS mcts = new MCTS(root);

        for (int i = 0; i < SIMULATION_LIMIT; i++) {
            // Selection
            Node<TicTacToe> node = mcts.selectOptimalChildNode(root);
            // Simulation
            int result = mcts.simulate(node);
            // Backpropagation
            mcts.backpropagate(node, result);
            // Determine the winning node
            if (root.children().isEmpty()) {
                System.out.println("No moves available.");
            } else {
                Node<TicTacToe> bestMove = mcts.selectOptimalChildNode(root);
                if (bestMove != null) {
                    System.out.println("Recommended move: " + bestMove.state().toString());
                } else {
                    System.out.println("No best move could be determined.");
                }
            }
            Node<TicTacToe> winningNode = mcts.determineWinningNode(root);
            int winningPlayer = mcts.determineWinner(winningNode);
            System.out.println("Winner: " + (winningPlayer == -1 ? "Draw" : "Player " + winningPlayer));
          
        }
    }
    public Node<TicTacToe> determineWinningNode(Node<TicTacToe> root) {
        return root.children().stream().max(Comparator.comparingDouble(node -> UCTFormula(node))).orElse(root);
    }
    
    // Method to determine the winner based on the winning node
    public int determineWinner(Node<TicTacToe> winningNode) {
        return winningNode.state().winner().orElse(-1); // Return -1 for draw
    }


    public MCTS(TicTacToeNode root) {
        MCTS.root = root;
    }


    // Method to backpropagate the result
    public void backpropagate(Node<TicTacToe> node, int result) {
        while (node != null) {
            int playout = node.playouts();
            node.setPlayouts(playout + 1);
            int wins = node.wins();
            if ((node.state().player() == 1 && result == 1) ||
                    (node.state().player() == 0 && result == -1)) {
                node.setWins(wins + 2);
            } else if (result == 0) {
                node.setWins(wins + 1);
            }
            node = node.getParent();
        }
    }

    // Method to simulate the game
    public Integer simulate(Node<TicTacToe> node) {
        State<TicTacToe> state = node.state();
        Random random = new Random();
        while (!state.isTerminal()) {
            List<Move<TicTacToe>> moves = new ArrayList<>(state.moves(state.player()));
            Move<TicTacToe> move = moves.get(random.nextInt(moves.size()));
            state = state.next(move);
        }
        return state.winner().orElse(0);
    }

    // Method to select the optimal node
    public Node<TicTacToe> selectOptimalChildNode(Node<TicTacToe> node) {
        while (!node.isLeaf()) {
            if (!node.children().isEmpty()) {
                node = node.children().stream().max((n1, n2) -> {
                    double ucb1 = UCTFormula(n1);
                    double ucb2 = UCTFormula(n2);
                    return Double.compare(ucb1, ucb2);
                }).get();
            } else {
                // If the node is not a leaf node, then explore the node
                node.explore();
                return node;
            }
        }
        return node;
    }

    // formula to find successor node
    double UCTFormula(Node<TicTacToe> node) {
        if (node.playouts() == 0)
            return Double.MAX_VALUE;
        return (double) node.wins() / node.playouts()
                + EXPLORATION_PARAM * Math.sqrt(Math.log(node.playouts()) / node.playouts());
    }
}