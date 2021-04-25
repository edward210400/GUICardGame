import java.util.ArrayList;
import java.util.Random;

/**
 * Shuffle is the base class to shuffle the card deck
 * 
 * @author Edward Suryajaya
 *
 */

public class Shuffle {
	
	/**
	 * The purpose of this function of this function is to shuffle the card deck
	 * @param cardCollection  the collection of cards that will be shuffled
	 * @return 				  a shuffled deck of cards.
	 */

	public static ArrayList<String> shuffleDeck(ArrayList<String> cardCollection){
		ArrayList<String> ShuffledDeck = new ArrayList<>();
		ArrayList<String> cardCollection2 = new ArrayList<String>(cardCollection);
		Random rn = new Random();
		for(int i=0; i<52; i++) {
			int random = rn.nextInt(52-i);
			ShuffledDeck.add(cardCollection2.get(random));
			cardCollection2.remove(random);
		}
		return ShuffledDeck;
	}
}
