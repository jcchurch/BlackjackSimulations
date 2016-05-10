public class Application {

    public static int playOne(BlackjackDeck deck, BlackjackDealer dealer, BlackjackPlayer player) {
        BlackjackGame game = new BlackjackGame(deck, dealer, player);
        game.play();
        return game.getResolution();
    }

    public static void single() {
        BlackjackDealer dealer = new BlackjackDealer();
        BlackjackJames player = new BlackjackJames(16, 14, 8);

        BlackjackDeckBuilder builder = new BlackjackDeckBuilder(8);
        BlackjackDeck deck = builder.getDeck();
        deck.shuffle();

        int resolution = Application.playOne(deck, dealer, player);
        System.out.println(dealer);
        System.out.println(player);
        System.out.println(resolution);
        System.out.println("Deck size: "+deck.size());
    }

    public static void battery(int numtests, int x) {
        BlackjackDealer dealer = new BlackjackDealer();
        BlackjackJames player = new BlackjackJames(x, 13, 5);
        player.setDealer(dealer);

        int gamesPlayed = 0;
        int sum = 0;

        while (gamesPlayed < numtests) {
            BlackjackDeckBuilder builder = new BlackjackDeckBuilder(8);
            BlackjackDeck deck = builder.getDeck();
            deck.shuffle();

            while (deck.size() > 20) {
                sum += Application.playOne(deck, dealer, player);
                gamesPlayed += 1;
            }
        }

        System.out.printf("Resolution %7.4f out of %d games (%d, %d, %d).\n", sum / (double) gamesPlayed, gamesPlayed, player.getStandOnA(), player.getStandOnB(), player.getWeakDealer());
    }

    public static void main(String[] args) {
        //single();
        for (int x = 11; x <= 20; x++) {
            battery(20000, x);
        }
    }
}
