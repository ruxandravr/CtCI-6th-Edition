package Q7_01_Deck_of_Cards;

import java.util.ArrayList;

import CtCILibrary.AssortedMethods;

public class Deck <T extends Card> {
	private ArrayList<T> cards;
	private int dealtIndex = 0; // marks first undealt card
	
	public Deck() {
	}
	
	public void setDeckOfCards(ArrayList<T> deckOfCards) {
		cards = deckOfCards;
	}
	
	public void shuffle() {
		for (int i = 0; i < cards.size(); i++) {
			int j = AssortedMethods.randomIntInRange(i, cards.size() - i - 1);
			T card1 = cards.get(i);
			T card2 = cards.get(j);
			cards.set(i, card2);
			cards.set(j, card1);
		}
	}
	
	public int remainingCards() {
		return cards.size() - dealtIndex;
	}
	
	public T dealCard() {
		if (remainingCards() == 0) {
			return null;
		}
		
		T card = cards.get(dealtIndex);
		card.markUnavailable();
		dealtIndex++;
		
		return card;		
	}
	
	public void print() {
		for (Card card : cards) {
			card.print();
		}
	}
}
