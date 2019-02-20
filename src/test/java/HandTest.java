import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;

import static org.junit.Assert.*;

public class HandTest {

    private Hand hand;

    @Before
    public void create(){
        hand = new Hand();
       // Card aceCard = new Card(2,0);
        //Card aceCard2 = new Card(3,0);
        Card numCard4 = new Card( 1,  3);
        Card faceCard = new Card(3, 12);
      //  hand.addCardToHand(aceCard);
      //  hand.addCardToHand(aceCard2);
        hand.addCardToHand(numCard4);
        hand.addCardToHand(faceCard);
    }



    @Test
    public void shouldAddValuesOfCardsInHand() {
        int resultOfMethodCall = hand.addValuesOfCardsInHandWithoutAceCards();
        int expected = 12;
        assertThat(resultOfMethodCall, equalTo(expected));


    }

    @Test
    public void shouldCheckFor21(){
        int expected = 21;
        String resultOfMethodCall = hand.checkFor21(expected);
        String expectedString = "You win.";
        assertThat(resultOfMethodCall,equalTo(expectedString));


    }

    @Test
    public void shouldAddOneToSumAfterCheckingForAce(){

    }
}