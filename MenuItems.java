public class MenuItems implements Selectable{
    private String description; //what will this option do to the current state?
    private String command; //command/key to press to select this move

    //this is a selectable item from the game menu
    public MenuItems(String command, String description) {
        this.command = command;
        this.description = description;
    }
    
    //get the current command
    public String getCommand() {
        return command;
    }

    //get the description of this command
    public String getDescription() {
        return description;
    }

    //updates v, returns bool game mode
    @Override
    public boolean select(Viewable v, GameLogical gl) {
        // Default behavior; override or enhance later
        System.out.println("Selected: " + description);


        return false; // By default, not entering game mode
    }
}