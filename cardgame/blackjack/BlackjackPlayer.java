package cardgame.blackjack;

public abstract class BlackjackPlayer {
    private String name;
    private BlackjackHand hand;
    private BlackjackDealer dealer;

    public BlackjackPlayer(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        this.name = name;
        this.hand = null;
        this.dealer = null;
    }

    public void setHand(BlackjackHand hand) {
        if (hand == null) {
            throw new IllegalArgumentException("hand is null");
        }

        this.hand = hand;
    }

    public void setDealer(BlackjackDealer dealer) {
        if (dealer == null) {
            throw new IllegalArgumentException("dealer is null");
        }

        this.dealer = dealer;
    }

    public void hit() {
        this.checkForSetHand();
        this.hand.hit();
    }

    public boolean isSoft() {
        this.checkForSetHand();
        return this.hand.isSoft();
    }

    public int getScore() {
        this.checkForSetHand();
        return this.hand.getScore();
    }

    public BlackjackCard getFirstCard() {
        this.checkForSetHand();
        return this.hand.getFirstCard();
    }

    public BlackjackCard getDealerFirstCard() {
        if (dealer == null) {
            throw new IllegalArgumentException("Dealer not set for "+this.name);
        }

        return this.dealer.getFirstCard();
    }

    public void deal() {
        this.checkForSetHand();
        this.hit();
        this.hit();
    }

    public void play() {
        this.checkForSetHand();
    }

    private void checkForSetHand() {
        if (hand == null) {
            throw new IllegalArgumentException("Hand is not set for "+this.name);
        }
    }

    public String toString() {
        return this.name+" = "+this.hand.toString();
    }
}
