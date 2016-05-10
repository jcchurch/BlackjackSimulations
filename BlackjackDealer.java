public class BlackjackDealer extends BlackjackPlayer {
    public BlackjackDealer() {
        super("The Dealer");
    }

    public void play() {
        while (this.getScore() < 17 || (this.getScore() == 17 && this.isSoft())) {
            this.hit();
        }
    }
}
