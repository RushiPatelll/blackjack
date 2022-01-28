import java.util.concurrent.TimeUnit;
import static java.lang.Thread.currentThread;
import java.util.Scanner;
import java.util.ArrayList;
public abstract class BlackJackDriver extends Player
{
    static String playerName = "";

    static ArrayList<Player> players = new ArrayList<Player>();
    public static int cash;

    private BlackJackDriver() // abstract constructor
    {
        super("name");
    }
    public static void main(String[] args) // void method that runs the
    whole game
    {


        System.out.print('\u000C');
        System.out.print("♠ ♥ ♦ ♣");
        try{Thread.sleep(250);}catch(InterruptedException ex){}
        System.out.print(" ♠ ♥ ♦ ♣");
        try{Thread.sleep(250);}catch(InterruptedException ex){}
        System.out.print(" ♠ ♥ ♦ ♣");
        try{Thread.sleep(250);}catch(InterruptedException ex){}
        System.out.print(" ♠ ♥ ♦ ♣");
        try{Thread.sleep(250);}catch(InterruptedException ex){}
        System.out.print(" ♠ ♥ ♦ ♣");
        try{Thread.sleep(250);}catch(InterruptedException ex){}

        System.out.println("\n Welcome to blackjack!");
        try{Thread.sleep(250);}catch(InterruptedException ex){}
        System.out.print("♠ ♥ ♦ ♣");
        try{Thread.sleep(250);}catch(InterruptedException ex){}
        System.out.print(" ♠ ♥ ♦ ♣");
        try{Thread.sleep(250);}catch(InterruptedException ex){}
        System.out.print(" ♠ ♥ ♦ ♣");
        try{Thread.sleep(250);}catch(InterruptedException ex){}
        System.out.print(" ♠ ♥ ♦ ♣");
        try{Thread.sleep(250);}catch(InterruptedException ex){}
        System.out.print(" ♠ ♥ ♦ ♣");

        DeckOfCards playingDeck = new DeckOfCards();
        playingDeck.fillDeck();
        playingDeck.shuffle();
        DeckOfCards playerDeck = new DeckOfCards();
        DeckOfCards dealerDeck = new DeckOfCards();
        System.out.println("\n Please chose one of the following:");
        try{Thread.sleep(250);}catch(InterruptedException ex){}
        System.out.println("Type 1 to start a new blackjack game as a new player");
        System.out.println("Type 2 to view the rankings");
        Scanner s = new Scanner(System.in);
        int selection = s.nextInt();
        if(selection == 2)
        {
            System.out.println("BlackJack All Time Scoreboard: \n");
            System.out.println("1. Bret Clark  : +123,250 ");
            System.out.println("2. Joe Gatto   : +$25,725 ");
            System.out.println("...");
            System.out.println("572. Hayden Scotti: -$71,250 ");
            s.close();
        }
        if(selection == 1)
        {
            s.close();
            cash = 100;
            int winStreak = 0;
            boolean roundEnd = false;
            int bet = 0;
            Scanner selection1 = new Scanner(System.in);
            System.out.println("Hello! What is your name?");
            playerName = selection1.nextLine();
            while(cash > 0)
            {

                int playerScore = 0;
                int dealerScore = 0;

                System.out.println("Hello " + playerName + "! You have " + cash + " dollars. How much would you like to bet?");
                bet = selection1.nextInt();


                if(bet > cash)
                {
                    System.out.println("You can't bet more than you have. Leave");
                    break;
                }

                System.out.println("Alright. Your bet is " + bet + ". I will draw our cards.");
                dealerDeck.draw(playingDeck);
                dealerDeck.draw(playingDeck);
                playerDeck.draw(playingDeck);
                playerDeck.draw(playingDeck);
                boolean playerLost = true;
                boolean playerWon = true;
                boolean tie = true;

                while(true)
                {
                    System.out.println("The dealer has drawn " + dealerDeck.getCard(0) + "[Hidden Card]");
                    System.out.println("You have drawn  " + playerDeck.toString());


                    System.out.println("What is your next move:");
                    System.out.println(" [1] Stand        (Hold your bet and not draw any more cards)");
                    System.out.println(" [2] Draw         (Draw another card)");
                    System.out.println(" [3] Double Down  (Double your bet and draw another card)");
                    int choice1 = selection1.nextInt();

                    if(choice1 == 1 && playerDeck.cardPoints() == 21)
                    {
                        System.out.println("You've got a blackjack! Congratulations!");
                        cash += bet + bet + bet + bet;
                        break;
                    }
                    if(choice1 == 2)
                    {
                        playerDeck.draw(playingDeck);
                        System.out.println("Your deck is: " + playerDeck.toString());
                        System.out.println(playerDeck.cardPoints() + " is the worth of your deck");
                        if(playerDeck.cardPoints() > 21)
                        {
                            winStreak = 0;
                            roundEnd = true;
                            cash -= bet;
                            break;
                        }
                    }
                    if(choice1 == 3)
                    {
                        bet = bet + bet;
                        playerDeck.draw(playingDeck);
                        System.out.println("Your deck is: " + playerDeck.toString());
                        if(playerDeck.cardPoints() > 21)
                        {
                            winStreak = 0;
                            roundEnd = true;
                            cash -= bet;
                            break;
                        }
                    }
                    if(choice1 == 1)
                    {
                        break;
                    }
                }

                if(winStreak == 5)
                {
                    System.out.println("Sorry about that... I'll have to take your cards..");
                    winStreak = 0;
                    cash -= bet;
                    roundEnd = true;
                }
                System.out.println("\nThe dealers hand is: " + dealerDeck.toString());
                if(dealerDeck.cardPoints() > playerDeck.cardPoints() && roundEnd == false)
                {
                    System.out.println("The dealer has won. \n The dealers score is " + dealerDeck.cardPoints() + " vs your " + playerDeck.cardPoints());
                    System.out.println("Your cash is now " + cash);
                    roundEnd = true;
                    cash -= bet;
                    winStreak = 0;
                }
                while(dealerDeck.cardPoints() < 17 && roundEnd == false)
                {
                    System.out.println("The dealer is drawing...");
                    dealerDeck.draw(playingDeck);

                }
                System.out.println("The dealers deck is: " + dealerDeck.toString());
                if(dealerDeck.cardPoints() > 21 && playerDeck.cardPoints() == 21 && roundEnd == false)
                {
                    System.out.println("The dealer has gone bust and you have a Blackjack. Congrats!");
                    cash += bet + bet;
                    System.out.println("You now have " + cash + " dollars.");
                    roundEnd = true;
                }
                if(dealerDeck.cardPoints() == playerDeck.cardPoints() && roundEnd == false)
                {
                    System.out.println("There is a push. Returning your bet.");

                    roundEnd = true;
                }
                if(playerDeck.cardPoints() > dealerDeck.cardPoints() && roundEnd == false)
                {
                    cash += bet;
                    System.out.println("You've won. You now have " + cash + "dollars");
                    roundEnd = true;
                }
                else if(roundEnd == false)
                {
                    System.out.println("The dealer has won. You have lost your bet.");
                    cash -= bet;
                }
                playerDeck.moveCards(playingDeck);
                dealerDeck.moveCards(playingDeck);
                playingDeck.shuffle();
                System.out.println("End of game.");
            }
        }
        System.out.println("Your outta money. Please leave the table.");

    }
}
