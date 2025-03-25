import java.util.List;

public interface Player {
    Selectable playerChoice(List<Selectable> options);
    void setPlayerName(String name);
    String getName();
}
