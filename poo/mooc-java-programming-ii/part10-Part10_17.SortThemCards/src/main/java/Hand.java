import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand>{
    private List<Card> handCards;

    public Hand(){
        handCards = new ArrayList<>();
    }

    public void add(Card card){
        handCards.add(card);
    }

    public void print(){
        handCards.forEach(card -> System.out.println(card.toString()));
    }

    public void sort(){
        Collections.sort(handCards);
    }
    
    public int sum(){
        return this.handCards.stream()
                    .mapToInt(i -> i.getValue())
                    .sum();
    }

    @Override
    public int compareTo(Hand hand){
        if(this.sum() == hand.sum()){
            return 0;
        }else if(this.sum() > hand.sum()){
            return 1;
        }else{
            return -1;
        }
    }

    public void sortBySuit(){
        Collections.sort(handCards, new BySuitInValueOrder());
    }
}
