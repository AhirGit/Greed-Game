public class GreedGame extends Game {
    
    public GreedGame() {
        super(makeLogic(), makeBoard(), makeMenu());
    }

    private static GreedLogic makeLogic() {
        return new GreedLogic();
    }

    private static GreedBoard makeBoard() {
        return new GreedBoard();
    }

    private static Menu makeMenu() {
        Menu menu = new Menu();
        menu.setMessage("Welcome to Greed");
        menu.addItem(new MenuItems("1", "Play Game") {
            @Override
            public boolean select(Viewable v, GameLogical gl) {
                return true;
            }
        });

        return menu;
    }

    public static void main(String[] args) {
        new GreedGame().run();
    }
}
