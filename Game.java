public abstract class Game implements RunnableGame {
        //Variables
        private GameLogic game;
        private GameBoard board;
        private Menu menu;
        private boolean isGamemode;
        //Constructor
        Game(GameLogic gl, GameBoard gb, Menu m){
            game = gl;
            board = gb;
            menu = m;
        }
        //Methods
        @Override
        public void run() {
            while (true) {
                menu.view();
                isGamemode = menu.nextState(menu);
                while ( isGamemode ) {
                    game.view();
                    board.view();   
                    isGamemode = game.nextState(board);
                }
                menu.setMessage("Welcome back!");
                menu.reset();
                board.reset();
                game.reset();
            }
        }
}
