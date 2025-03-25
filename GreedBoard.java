//a greed game specific board

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GreedBoard implements GameBoard{

    //size of the board 80x20
    private final int rows = 20;
    private final int cols = 80;
    private char[][] board; //store the numbers of current state
    private int playerRow, playerCol; //store the player position of current state

    //initialize new board with ascii numbers (0-9) by resetting the current
    public GreedBoard() {
        board = new char[rows][cols];
        reset();
    }

    //reset the board state by generating random number in each cell
    @Override
    public void reset() {
        Random rand = new Random();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                //rand.nextInt(9) generates from 0 to 8 in integer
                //'1' + the random number = ascii of 1 to 9
                board[r][c] = (char) ('1' + rand.nextInt(9)); // '1' to '9' as ascii
            }
        }

        //start the player at center initially
        playerRow = rows / 2;
        playerCol = cols / 2;
        board[playerRow][playerCol] = '@'; // Place player
    }

    //Display the 2d gameboard with randomized number on the console
    @Override
    public void view() {
        for (char[] row : board) {
            System.out.println(row); //print the entire row on each line
        }
    }

    //steps in the direction of moveX and moveY
    public int getStepsInDirection(int moveX, int moveY) {
        int newRow = playerRow + moveX;
        int newCol = playerCol + moveY;

        if (inBounds(newRow, newCol)) {
            char ch = board[newRow][newCol];
            if (Character.isDigit(ch)) {
                return ch - '0';
            }
        }
        return 0;
    }

    //apply the move to the board and update the state
    public void applyMove(int moveX, int moveY, int steps) {
        int currentRow = playerRow;
        int currentCol = playerCol;

        for (int i = 1; i <= steps; i++) {
            int nextRow = currentRow + moveY * i;
            int nextCol = currentCol + moveX * i;

            if (!inBounds(nextRow, nextCol)) return; //dont move if outside of bound

            board[nextRow][nextCol] = ' '; // Clear path
        }

        board[playerRow][playerCol] = ' '; // clear old player position
        playerRow += moveY * steps;
        playerCol += moveX * steps;
        board[playerRow][playerCol] = '@';
    }

    //look around the player for selectable moves
    public List<GreedMove> getValidMoves(GreedLogic logic) {
        List<GreedMove> moves = new ArrayList<>();

        //directions around the player
        int[][] directions = {
            {-1, -1}, {0, -1}, {1, -1},
            {-1,  0},          {1,  0},
            {-1,  1}, {0,  1}, {1,  1}
        };

        //keys to select the specific direction
        String[] keys = {
            "q", "w", "e", 
            "a",      "d", 
            "z", "s", "x"
        };

        //small description of the move direction to view for the player
        String[] labels = {
            "Up-Left",    "Up",   "Up-Right",
            "Left",                  "Right",
            "Down-Left", "Down", "Down-Right"
        };

        for (int i = 0; i < directions.length; i++) {
            int dx = directions[i][0];
            int dy = directions[i][1];
            int steps = getStepsInDirection(dx, dy);
            if (steps == 0) continue;

            // Check path validity
            boolean valid = true;
            for (int s = 1; s <= steps; s++) {
                int nr = playerRow + dy * s;
                int nc = playerCol + dx * s;

                //move is not valid if there is an empty spot on the way or out of the board
                if (!inBounds(nr, nc) || board[nr][nc] == ' ') {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                moves.add(new GreedMove(keys[i], labels[i], dx, dy));
            }
        }

        return moves;
    }

    //check if next position is within bounds of the board
    private boolean inBounds(int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols;
    }
}
