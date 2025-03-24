//game logic more specific to greed game

import java.util.Scanner;

public class GreedLogic extends GameLogic{

    private Scanner scanner;

    public GreedLogic() {
        super();
        scanner = new Scanner(System.in);
    }
    
    //handles the next state of the current game and updates accordingly
    @Override
    public boolean nextState(Viewable v) {
        System.out.println("Enter move option (0 to give up) : ");
        String input = scanner.next().trim(); //get the next option from user

        //if player selects 0, player has given up
        if (input.equals("0")) {
            return false; // exit game mode
        }

        System.out.println("Invalid move. (Game logic not yet implemented)");
        return true; // stay in game mode
    }
}
