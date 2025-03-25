//game logic more specific to greed game

import java.util.List;
import java.util.Scanner;

public class GreedLogic extends GameLogic{

    private Scanner scanner;

    public GreedLogic() {
        super();
        scanner = new Scanner(System.in);
    }
    
    //handles the next state of the current game and updates accordingly
    //Viewable v is game board
    @Override
    public boolean nextState(Viewable v) {

        if(!( v instanceof GreedBoard)){
            System.out.println("Error: not correct instance for GreedLogic selection");
            return false;
        }

        GreedBoard greedBoard = (GreedBoard) v;

        List<GreedMove> moves = greedBoard.getValidMoves(this); //get list a for valid selectable moves around the player

        if (moves.isEmpty()) {
            System.out.println("Game Over! No valid moves left.");
            return false;
        }

        //show available move options
        //select the move that the user chooses
        for (int i = 0; i < moves.size(); i++) {
            GreedMove move = moves.get(i);
            System.out.println(move.getCommand() + ": " + move.getDescription());
        }

        System.out.print("Enter move option (0 to give up) : ");
        String input = scanner.next().trim(); //get the next option from user

        //if player selects 0, player has given up
        if (input.equals("0")) {
            return false; // exit game mode
        }

        //select the move that the user chooses
        for (int i = 0; i < moves.size(); i++) {
            GreedMove move = moves.get(i);
            if (input.equals(String.valueOf(move.getCommand()))) {
                move.select(greedBoard, this);
                return true;
            }
        }

        System.out.println("Invalid move. (Game logic not yet implemented)");
        return true; // stay in game mode
    }
}
