package cardgame.blackjack;

public class BlackjackDeckBuilder {
    private int numdecks;

    public BlackjackDeckBuilder(int numdecks) {
        if (numdecks < 1) {
            throw new IllegalArgumentException("Non-positive number of decks.");
        }

        this.numdecks = numdecks;
    }

    public BlackjackDeck getDeck() {
        int[] cards = new int[52*this.numdecks];
        for (int i = 0; i < this.numdecks; i++) {
            for (int j = 0; j < 52; j++) {
                cards[i*52+j] = j;
            }
        }

        return new BlackjackDeck(cards);
    }
}
