import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements Menuable {
    private String message; //unique menu header message
    private List<MenuItems> selectableItems; //all selectable options in the menu
    private Scanner userinput; // user input for menu options

    public Menu(){
        selectableItems = new ArrayList<MenuItems>();
        userinput = new Scanner(System.in); //take user input
    }

    //set the unique menu message
    public void setMessage(String message){
        this.message = message;
    }

    //add a selectable item to the list
    public void addItem(MenuItems item) {
        this.selectableItems.add(item);
    }

    //return of false implies there is no next state
    //Viewable v is game menu
    public boolean nextState(Viewable v){
        String input = userinput.next().trim();

        for (int i = 0; i < selectableItems.size(); i++) {
            MenuItems item = selectableItems.get(i); //
    
            // if available, select the option user picked
            if (item.getCommand().equals(input)) {
                return item.select(v, this);
            }
        }

        System.out.println("Invalid option. Try again.");
        return false;
    }
    public void reset(){

    }

    //Prints to System.out (Display the menu)
    @Override
    public void view() {

        //display current header message of the menu
        System.out.println("\n" + message);

        //display each currently selectable items
        for (int i = 0; i < selectableItems.size(); i++) {
            MenuItems item = selectableItems.get(i);
            System.out.println(item.getCommand() + ": " + item.getDescription() + "?");
        }

        //user input prompt
        System.out.print("Enter menu option: ");
    }
}
