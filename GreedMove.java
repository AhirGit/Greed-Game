//generate selectable moves based on player's and board's current state

public class GreedMove implements Selectable {

    private int directionX, directionY; //move in the x, y directions
    private String description; //where will this move take the player?
    private String command; //command/key to press to select this move

    public GreedMove(String command, String description, int directionX, int directionY) {
        this.command = command;
        this.description = description;
        this.directionX = directionX;
        this.directionY = directionY;
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

        int steps = greedBoard.getStepsInDirection(directionX, directionY);
        if (steps == 0) return true; //dont apply move

        //apply move
        greedBoard.applyMove(directionX, directionY, steps);
        greedLogic.addToScore(steps);
        return true;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }

    public int getDirectionX(){
        return directionX;
    }

    public int getDirectionY(){
        return directionY;
    }
}
