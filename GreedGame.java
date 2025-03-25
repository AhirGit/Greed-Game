public class GreedGame extends Game {
    
    public GreedGame() {
        super(makeLogic(), makeBoard(), makeMenu());
    }

    private static GreedLogic makeLogic() {
        return new GreedLogic(new HumanPlayer("Player1"));
    }

    private static GreedBoard makeBoard() {
        return new GreedBoard();
    }

    private static Menu makeMenu() {
        Menu menu = new Menu();
        menu.setMessage("Welcome to Greed"); //initial message

        //add menu options
        menu.addItem(new MenuItems("1", "Play Game") {
            @Override
            public boolean select(Viewable v, GameLogical gl) {
                return true;
            }
        });

        menu.addItem(new MenuItems("2", "Quit game") {
            @Override
            public boolean select(Viewable v, GameLogical gl) {
                System.out.println("Quitting program successfully.....");
                System.exit(0);
                return false;
            }
        });

        return menu;
    }

    public static void main(String[] args) {
        new GreedGame().run();
    }
}
