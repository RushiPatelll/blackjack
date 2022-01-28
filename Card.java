import java.util.ArrayList;
public class Card
{
    private Suit s;
    private Value v;

    public Suit getSuit() // getter method returning suit
    {
        return this.s;
    }
    public Value getValue() // getter method return value
    {
        return this.v;
    }
    public Suit getSuit(Card c) // getter method for a certain card
    {
        return c.getSuit();
    }
    public Value getValue(Card c) // getter method for a certain card
    {
        return c.getValue();
    }
    public Card(Suit s, Value v) // Card constructor class
    {
        this.s = s;
        this.v = v;
    }
    public String toString() // toString that returns the cards info
    {
        return v.toString() + " of " + s.toString();
    }
}
