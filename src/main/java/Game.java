import java.util.Scanner;

public class Game {

    Deck deck = new Deck();
    Hand dealerHand = new Hand();
    Hand playerHand = new Hand();
    Card drawnCard;
    Dealer dealer = new Dealer(deck);
    boolean isPlaying = false;
    Scanner sc = new Scanner(System.in);
    int userInputInt;
    String userInput;


    public void startGame(){

        do{
            System.out.println("Welcome to the Black Jack Table. What would you like to do?\n" +
                    "1. Play Black Jack\n" +
                    "2. Quit game");
            userInput = sc.nextLine();

            switch (userInput){
                case 1:
                    break;
                case 2:
                    break;
                default:
                    break;
            }








        } while(isPlaying);

    }
}
