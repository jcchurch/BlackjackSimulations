public class BlackjackJames extends BlackjackPlayer {
    private int standOnA;
    private int standOnB;
    private int weakdealer;

    public BlackjackJames(int standOnA, int standOnB, int weakdealer) {
        super("James");

        this.standOnA = standOnA;
        this.standOnB = standOnB;
        this.weakdealer = weakdealer;
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

    public void play() {
        int standOn = this.standOnA;
        int dealerFirst = this.getDealerFirstCard().getGameValue();

        if (dealerFirst <= this.weakdealer) {
            standOn = this.standOnB;
        }

        while (this.getScore() < standOn || (this.getScore() == standOn && this.isSoft())) {
            this.hit();
        }
    }
}
