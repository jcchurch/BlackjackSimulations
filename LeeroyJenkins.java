public class LeeroyJenkins extends BlackjackPlayer {
    public LeeroyJenkins() {
        super("Leeeeeeeeeeeeeeeeeroy Jenkins!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public void play() {
        while (this.getScore() < 21) {
            this.hit();
        }
    }
}
