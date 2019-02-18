import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.core.IsEqual.equalTo;

import static org.junit.Assert.*;

public class HandTest {

    private Hand hand;

    @Before
    public void create(){
        hand = new Hand();
    }



    @Test
    public void shouldAddValuesOfCardsInHand() {
       // Card numCard = new Card( 1,  3);
       // Card faceCard = new Card(3, 12);
        Card aceCard = new Card(2,0);
        Card aceCard2 = new Card(3,0);

      // hand.addCardToHand(numCard);
      //  hand.addCardToHand(faceCard);
        hand.addCardToHand(aceCard);
        hand.addCardToHand(aceCard2);
        int resultOfMethodCall = hand.checkFor21();
        int expected = 12;
        assertThat(resultOfMethodCall, equalTo(expected));


    }
}