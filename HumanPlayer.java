//this class lets the human player instances make their own choices
import java.util.List;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private Scanner scanner;
    private String playerName;

    public HumanPlayer() {
        scanner = new Scanner(System.in);
        this.playerName = "No name";
    }

    public HumanPlayer(String playerName) {
        scanner = new Scanner(System.in);
        this.playerName = playerName;
    }

    //let this player pick the choice from selectables
    //player only have access to options, not the entire game state
    @Override
    public Selectable playerChoice(List<Selectable> options) {

        //keep asking for a valid command
        while (true) {
            System.out.println("["+ getName() +"]"+"Choose a move:" );

            //display the available options for this player
            for (int i = 0; i < options.size(); i++) {
                Selectable option = options.get(i);
                if (option instanceof GreedMove) {
                    GreedMove gm = (GreedMove) option;
                    System.out.println("[" + gm.getCommand() + "] " + gm.getDescription());
                } else if (option instanceof MenuItems) {
                    MenuItems mi = (MenuItems) option;
                    System.out.println("[" + mi.getCommand() + "] " + mi.getDescription());
                }
            }

            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();

            for (int i = 0; i < options.size(); i++) {
                Selectable option = options.get(i);
                String cmd = null;

                if (option instanceof GreedMove) {
                    cmd = ((GreedMove) option).getCommand();
                } else if (option instanceof MenuItems) {
                    cmd = ((MenuItems) option).getCommand();
                }

                if (cmd != null && cmd.equalsIgnoreCase(input)) {
                    return option;
                }
            }

            System.out.println("Invalid command. Try again.");
        }
    }

    public void setPlayerName(String name){
        this.playerName = name;
    }

    public String getName(){
        return this.playerName;
    }
}