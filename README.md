# Monte Carlo Tree Search (MCTS) for Tic-tac-toe and Connect Four

## Overview
This project implements the Monte Carlo Tree Search (MCTS) algorithm for two classic games: Tic-tac-toe and Connect Four. MCTS is a search technique used in decision processes, notably in AI applications for game-playing. This repository contains the implementation details, optimizations, performance evaluations, and all associated code.

## Team Members
- Pranav Arun Kapse (NUID: 002871241)
- Khushank Mistry (NUID: 002209157)
- Amar Nagargoje (NUID: 002273113)

## GitHub Repository
[Link to GitHub Repository](https://github.com/amarneu/INFO6205-MCTS-FinalProject)

## Games
- **Tic-tac-toe:** A well-known, simple game often played on a 3x3 grid.
- **Connect Four:** A more complex game played on a vertical board where players drop tokens to get four in a row.

## Structure
The project is structured into several packages, reflecting the core components and the two games implemented:
- **mcts**
  - **core:** Contains generic classes for the MCTS implementation.
  - **tictactoe:** Contains classes specific to the Tic-tac-toe implementation.
  - **connectFour:** Contains classes specific to the Connect Four implementation.
- **tests**
  - **core:** Contains tests for the generic MCTS components.
  - **tictactoe:** Contains tests for the Tic-tac-toe specific components.
  - **connectFour:** Contains tests for the Connect Four specific components.

## Approach
The implementation involves several steps including game representation, node structure, selection, expansion, simulation, backpropagation, and more. For detailed instructions and explanations, please refer to the project report and in-code documentation.

## Invariants
The project maintains a set of invariants to ensure the correct and robust execution of the games. These include board dimensions, token placement, win conditions, and player equality checks.

## How to Run
1. Clone the repository using `git clone https://github.com/amarneu/INFO6205-MCTS-FinalProject`.
2. Ensure Java JDK and Maven are installed on your system.
3. Navigate to the project directory and run `mvn clean install` to build the project.
4. To run Tic-tac-toe, execute `java -cp target/mcts-1.0-SNAPSHOT.jar edu.neu.coe.info6205.mcts.tictactoe.TicTacToeApplication`.
5. To run Connect Four, execute `java -cp target/mcts-1.0-SNAPSHOT.jar edu.neu.coe.info6205.mcts.connectFour.ConnectFourApplication`.

## Testing
Comprehensive unit tests are provided for both games and the core MCTS logic. To run the tests, use the command `mvn test`.

## Contributions
Contributions are welcome. Please submit a pull request or open an issue if you have suggestions or identify bugs.

## References
- Connect Four - MIT Lecture Slides
- How to win games according to data scientists - Washington Post
- MCTS - Harry He's Blog
- Learning to Play Connect 4 using MCTS - Pranav Agarwal's Medium
