package cardgame.blackjack;

import java.util.ArrayList;

public class BlackjackDeck {
    private ArrayList<BlackjackCard> deck;

    public BlackjackDeck(int[] ids) {
        this.deck = new ArrayList<>();

        for (int id : ids) {
            this.deck.add(new BlackjackCard(id));
        }
    }

    public BlackjackCard deal() {
        if (this.deck.size() == 0) {
            throw new IllegalStateException("Deck has been dealt.");
        }
        else if (this.deck.size() < 5) {
            System.out.println("Shuffle sooner! "+this.deck.size());
        }
        BlackjackCard top = this.deck.get(0);
        this.deck.remove(0);
        return top;
    }

    public void shuffle() {

        int predecksize = this.deck.size();
        ArrayList<BlackjackCard> deckprime = new ArrayList<>();
        ArrayList<Double> randomvalues = new ArrayList<>();

        for (BlackjackCard card : this.deck) {
            randomvalues.add(Math.random());
        }

        while (randomvalues.size() > 0) {
            int minindex = this.findMinIndex(randomvalues);
            deckprime.add(deck.get(minindex));
            this.deck.remove(minindex);
            randomvalues.remove(minindex);
        }

        this.deck = deckprime;

        int postdecksize = this.deck.size();

        if (predecksize != postdecksize) {
            throw new IllegalStateException("Shuffling algorithm error. Pre: "+predecksize+" Post: "+postdecksize);
        }
    }

    private int findMinIndex(ArrayList<Double> values) {
        int minindex = 0;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) < values.get(minindex)) {
                 minindex = i;
            }
        }
        return minindex;
    }

    public int size() {
        return this.deck.size();
    }
}
