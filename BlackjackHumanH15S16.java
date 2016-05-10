public class BlackjackHumanH15S16 extends BlackjackPlayer {
    public BlackjackHumanH15S16() {
        super("Hit on 15, Soft 16");
    }

    public void play() {
        while (this.getScore() < 16 || (this.getScore() == 16 && this.isSoft())) {
            this.hit();
        }
    }
}
