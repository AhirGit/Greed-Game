//game logic more specific to greed game

import java.util.ArrayList;
import java.util.List;

public class GreedLogic extends GameLogic{

    private Player player;
    List<GreedMove> availableMoves; //store available moves neighbouring the player

    public GreedLogic(Player player) {
        super();
        this.player = player;
        availableMoves = new ArrayList<GreedMove>();
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
        availableMoves = greedBoard.getValidMoves(this); //get list a for valid selectable moves around the player
        if (availableMoves.isEmpty()) {
            System.out.println("Game Over! No valid moves left.");
            return false;
        }

        //Get the player choice from the available move list
        List<Selectable> options = new ArrayList<Selectable>(); //store all available options for player
        for (int i = 0; i < availableMoves.size(); i++) {
            options.add(availableMoves.get(i)); //add available moves to player options list
        }
        Selectable choice = player.playerChoice(options); //let player decide which option to pick
        return choice.select(greedBoard, this); //select and proceed with the player choice
    }
}
