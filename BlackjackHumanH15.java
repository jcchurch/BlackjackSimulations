public class BlackjackHumanH15 extends BlackjackPlayer {
    public BlackjackHumanH15() {
        super("Hit on 15");
    }

    public void play() {
        while (this.getScore() < 16) {
            this.hit();
        }
    }
}
