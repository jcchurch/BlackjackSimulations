package cardgame.blackjack;

import java.util.ArrayList;
import cardgame.*;

public class BlackjackHand {
    private ArrayList<BlackjackCard> hand;
    private BlackjackDeck deck;
    private int aceCount;
    private int softAces;

    public BlackjackHand(BlackjackDeck deck) {
        if (deck == null) {
            throw new IllegalArgumentException("Deck is null");
        }

        this.hand = new ArrayList<>();
        this.deck = deck;
        this.aceCount = 0;
        this.softAces = 0;
    }

    public void hit() {
        if (this.deck.size() == 0) {
            throw new IllegalArgumentException("Deck is out of cards. Cannot hit.");
        }

        BlackjackCard card = this.deck.deal();

        if (card.getValue() == CardValue.ACE) {
            this.aceCount += 1;
        }

        this.hand.add(card);
    }

    public ArrayList<BlackjackCard> getCards() {
        return this.hand;
    }

    public boolean isSoft() {
        return this.softAces > 0;
    }

    private int getRawScore() {
        int score = 0;

        for (BlackjackCard card : this.hand) {
            score += card.getGameValue();
        }

        return score;
    }

    public int getScore() {
        int score = this.getRawScore();

        this.softAces = this.aceCount;
        while (score > 21 && this.softAces > 0) {
            score -= 10;
            this.softAces -= 1;
        }

        return score;
    }

    public BlackjackCard getFirstCard() {
        return this.hand.get(0);
    }

    public String toString() {
        String s = this.getScore() + " [ " + this.hand.get(0).toString();

        for (int i = 1; i < this.hand.size(); i++) {
            s += ":" + this.hand.get(i).toString();
        }

        return s + " ]";
    }
}
