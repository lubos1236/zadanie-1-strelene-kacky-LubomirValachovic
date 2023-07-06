package sk.stuba.fei.uim.oop.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract  class Deck {
    protected List<Object> cardList=new ArrayList<>();
    private final Random random=new Random(System.nanoTime());

    public List<Object> getCardList() {
        return cardList;
    }

    public void shuffleDeck()
    {
        List<Object> tempList=new ArrayList<>(cardList);
        do {
            Collections.shuffle(cardList,random);
        }while (cardList.equals(tempList));
    }
}



