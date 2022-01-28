import java.util.ArrayList;
public abstract class Player
{
    String name;
    ArrayList<Player> players = new ArrayList<Player>();
    public Player(String name) // creates a player with a String name param
    {
        this.name = name;
    }
    public String getName() // returns the name of the player
    {
        return this.name;
    }
}
