import java.util.ArrayList;
public class DeckOfCards implements CardNums
{
    public ArrayList<Card> deck;

    public DeckOfCards() // Constructs a deck of cards
    {
        this.deck = new ArrayList<Card>();
    }
    public void fillDeck() // method that fills an arraylist with 52 cards
    {
        for(Suit s : Suit.values())
        {
            for(Value v : Value.values())
            {
                deck.add(new Card(s, v));
            }
        }
    }

    public void shuffle() // shuffles the deck randomly
    {
        ArrayList<Card> temporaryDeck = new ArrayList<Card>();
        temporaryDeck = deck;
        int m = deck.size();
        for(int i = 0; i < m; i++)     // 1. Relational Operator
        {
            int k = (int)(Math.random() * 51);
            temporaryDeck.add(deck.get(k));
            deck.remove(k);
        }
    }

    public void removeCard(int i ) // removes a card at the i-th position
    {
        this.deck.remove(i);
    }

    public Card getCard(int i) // gets the card at the i-th position
    {
        return this.deck.get(i);
    }

    public void draw(DeckOfCards receiver) // takes a card from a deck
    and sends it to another deck
    {
        this.deck.add(receiver.getCard(0));
        receiver.removeCard(0);
    }



    public void addCard(Card addCard) // adds a card
    {
        this.deck.add(addCard);
    }

    public void moveCards(DeckOfCards d) // moves all cards to another
    deck
    {
        int deckSize = this.deck.size();
        for(int i = 0; i < deckSize; i++)
        {
            d.addCard(this.getCard(i));
        }
        for(int i = 0; i < deckSize; i++)
        {
            this.removeCard(0);
        }
    }
    public int cardPoints() // returns the value of a deck
    {
        int totalValue = 0;
        int aces = 0;
        for(Card aCard : this.deck)
        {

            switch(a.getValue())
            {
                case TWO: totalValue += 2; break;
                case THREE: totalValue += 3; break;
                case FOUR: totalValue += 4; break;
                case FIVE: totalValue += 5; break;
                case SIX: totalValue += 6; break;
                case SEVEN: totalValue += 7; break;
                case EIGHT: totalValue += 8; break;
                case NINE: totalValue += 9; break;
                case TEN: totalValue += 10; break;
                case JACK: totalValue += 10; break;
                case QUEEN: totalValue += 10; break;
                case KING: totalValue += 10; break;
                case ACE: aces += 1; break;
            }
        }


        for(int i = 0; i < aces; i++)
        {
            if (totalValue > 10)
            {
                totalValue += 1;
            }
            else{
                totalValue += 11;
            }
        }
        return totalValue;
    }

    public String toString() // returns a string of the cards in the deck
    {
        String s = "";

        for(Card c : this.deck)
        {
            s += "\n"  + c.toString();

        }
        return s;
    }
}
