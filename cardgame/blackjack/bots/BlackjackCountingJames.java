package cardgame.blackjack.bots;
import cardgame.blackjack.BlackjackPlayer;
import cardgame.blackjack.BlackjackHand;
import cardgame.blackjack.BlackjackCard;

public class BlackjackCountingJames extends BlackjackPlayer {
    private int standOnA;
    private int standOnB;
    private int weakdealer;
    private int count;
    private int bet;

    public BlackjackCountingJames(int standOnA, int standOnB, int weakdealer) {
        super("James");

        this.standOnA = standOnA;
        this.standOnB = standOnB;
        this.weakdealer = weakdealer;
        this.resetBet();
    }

    public int getStandOnA() {
        return this.standOnA;
    }

    public int getStandOnB() {
        return this.standOnB;
    }

    public int getWeakDealer() {
        return this.weakdealer;
    }

    public int getCount() {
        return this.count;
    }

    public int getBet() {
        return this.bet;
    }

    public void viewHand(BlackjackHand hand) {
        for (BlackjackCard card : hand.getCards()) {
            this.countCard(card);
        }
    }

    public void play() {
        this.updateBet();

        int standOn = this.standOnA;
        int dealerFirst = this.getDealerFirstCard().getGameValue();

        if (dealerFirst <= this.weakdealer) {
            standOn = this.standOnB;
        }

        while (this.getScore() < standOn || (this.getScore() == standOn && this.isSoft())) {
            this.hit();
        }
    }

    public void resetBet() {
        this.bet = 1;
        this.count = 0;
    }

    private void countCard(BlackjackCard card) {
        if (card.getGameValue() >= 10) {
            this.count -= 1;
        }
        else if (card.getGameValue() <= 6) {
            this.count += 1;
        }
    }

    private void updateBet() {
        if (this.count > 20) {
            this.bet = 2;
        }
        if (this.count < -15) {
            this.count = -1000; // Walk away
            this.bet = 0;
        }
    }
}
