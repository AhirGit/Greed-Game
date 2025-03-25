//a generic game logic with specific rules for the some common games

public abstract class GameLogic implements GameLogical{
    protected int score; //store the score in current state for view

    public GameLogic() {
        this.score = 0;
    }

    @Override
    public void reset() {
        score = 0;
    }

    @Override
    public void view() {
        System.out.println("Player Score: " + score);
    }

    //increase score of this game logic
    public void addToScore(int points) {
        score += points;
    }

    // nextState remains abstract
    @Override
    public abstract boolean nextState(Viewable v);

}
