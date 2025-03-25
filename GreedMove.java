//generate selectable moves based on player's and board's current state

public class GreedMove implements Selectable {

    private int moveX, moveY; //postion of player if this move is selected
    private String description; //where will this move take the player?
    private String command; //command/key to press to select this move

    public GreedMove(String command, String description, int moveX, int moveY) {
        this.command = command;
        this.description = description;
        this.moveX = moveX;
        this.moveY = moveY;
    }
    
    //v is greedboard and gl is greedlogic
    @Override
    public boolean select(Viewable v, GameLogical gl) {

        if(!( v instanceof GreedBoard && gl instanceof GreedLogic)){
            System.out.println("Error: not correct instance for GameMove selection");
            return false;
        }

        GreedBoard greedBoard = (GreedBoard) v;
        GreedLogic greedLogic = (GreedLogic) gl;

        int steps = greedBoard.getStepsInDirection(moveX, moveY);
        if (steps == 0) return true;

        greedLogic.addToScore(steps);
        greedBoard.applyMove(moveX, moveY, steps);
        return true;
        //return false; // By default, not entering game mode
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}
