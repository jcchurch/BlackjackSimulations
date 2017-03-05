package cardgame.blackjack;

import cardgame.*;

public class BlackjackCard extends Card {

    public BlackjackCard(int id) {
        super(id);
    }

    public int getGameValue() {
         int value = 10;
         CardValue cardvalue = this.getValue();
         if (cardvalue == CardValue.ACE) { value = 11; }
         else if (cardvalue == CardValue.TWO) { value = 2; }
         else if (cardvalue == CardValue.THREE) { value = 3; }
         else if (cardvalue == CardValue.FOUR) { value = 4; }
         else if (cardvalue == CardValue.FIVE) { value = 5; }
         else if (cardvalue == CardValue.SIX) { value = 6; }
         else if (cardvalue == CardValue.SEVEN) { value = 7; }
         else if (cardvalue == CardValue.EIGHT) { value = 8; }
         else if (cardvalue == CardValue.NINE) { value = 9; }
         return value;
    }
}
