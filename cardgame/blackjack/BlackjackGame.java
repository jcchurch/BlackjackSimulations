package cardgame.blackjack;

public class BlackjackGame {

    private BlackjackDeck deck;
    private BlackjackDealer dealer;
    private BlackjackPlayer human;

    public BlackjackGame(BlackjackDeck deck, BlackjackDealer dealer, BlackjackPlayer human) {
        if (deck == null) {
            throw new IllegalArgumentException("Deck is null");
        }

        if (dealer == null) {
            throw new IllegalArgumentException("Dealer is null");
        }

        if (human == null) {
            throw new IllegalArgumentException("Human is null");
        }

        this.deck = deck;
        this.dealer = dealer;
        this.human = human;
    }

    public void play() {
        BlackjackHand dealerHand = new BlackjackHand(this.deck);    
        BlackjackHand humanHand = new BlackjackHand(this.deck);    

        this.dealer.setHand(dealerHand);
        this.human.setHand(humanHand);

        this.human.deal();
        this.dealer.deal();

        this.human.play();
        this.dealer.play();
    }

    public int getResolution() {
        if (this.human.getScore() > 21) {
            return -1;
        }

        if (this.dealer.getScore() > 21) {
            return 1;
        }

        if (this.human.getScore() > this.dealer.getScore()) {
            return 1;
        }

        if (this.dealer.getScore() > this.human.getScore()) {
            return -1;
        }

        return 0;
    }
}
