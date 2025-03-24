public interface GameLogical extends Viewable {
    //Methods
    boolean nextState(Viewable v);//return of false implies there is no next state
    void reset();
}
