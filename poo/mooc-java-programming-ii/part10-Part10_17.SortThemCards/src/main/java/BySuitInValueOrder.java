import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {
    public int compare(Card c1, Card c2) {
        int flag = c1.getSuit().ordinal() - c2.getSuit().ordinal();

        if(flag == 0){
            return c1.compareTo(c2);
        }

        return flag;
    }
}