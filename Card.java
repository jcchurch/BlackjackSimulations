public class Card {
     private int id;

     public Card(int id) {
         if (id < 0 || id >= 52) {
             throw new IllegalArgumentException("Card id is out of bounds.");
         }

         this.id = id;
     }

     public CardValue getValue() {
         int value = this.id / 4;
         CardValue cardvalue = CardValue.ACE;
         if (value == 1) { cardvalue = CardValue.TWO; }
         else if (value == 2) { cardvalue = CardValue.THREE; }
         else if (value == 3) { cardvalue = CardValue.FOUR; }
         else if (value == 4) { cardvalue = CardValue.FIVE; }
         else if (value == 5) { cardvalue = CardValue.SIX; }
         else if (value == 6) { cardvalue = CardValue.SEVEN; }
         else if (value == 7) { cardvalue = CardValue.EIGHT; }
         else if (value == 8) { cardvalue = CardValue.NINE; }
         else if (value == 9) { cardvalue = CardValue.TEN; }
         else if (value == 10) { cardvalue = CardValue.JACK; }
         else if (value == 11) { cardvalue = CardValue.QUEEN; }
         else if (value == 12) { cardvalue = CardValue.KING; }
         return cardvalue;
     }

     public CardSuit getSuit() {
         int suit = this.id / 4;
         CardSuit cardsuit = CardSuit.SPADE;
         if (suit == 1) { cardsuit = CardSuit.CLUB; }
         else if (suit == 2) { cardsuit = CardSuit.HEART; }
         else if (suit == 3) { cardsuit = CardSuit.DIAMOND; }
         return cardsuit;
     }

     public String toString() {
         CardValue cardvalue = this.getValue();
         CardSuit cardsuit = this.getSuit();
         return cardvalue+"-"+cardsuit;
     }
}
