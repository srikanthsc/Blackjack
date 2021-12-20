import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
public class Deck{

    private LinkedList<Card> cardList;
public Deck(int nbBox){
    cardList =new LinkedList<Card>();
    Value[] valuesArray = Value.values();
    Color[] colorsArray = Color.values();
    for (int i = 0; i < nbBox ; i++) {
        for (int j = 0; j < colorsArray.length; j++) {
            for (int k = 0; k < valuesArray.length ; k++) {
                cardList.add(new Card(valuesArray[k], colorsArray[j]));
            }

        }
          
    }
    Collections.shuffle(cardList);
    
}
public String toString(){
     Card[] cards=cardList.toArray(new Card[cardList.size()]);
     return Arrays.asList(cards).toString();
}

public Card draw() throws EmptyDeckException {
      if (cardList.isEmpty()) throw new EmptyDeckException( "the deck is empty"); 
    return cardList.pollFirst();
}
     
}