//a greed game specific board

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
}
