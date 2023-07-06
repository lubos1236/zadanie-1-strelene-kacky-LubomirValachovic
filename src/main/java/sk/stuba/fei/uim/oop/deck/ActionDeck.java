package sk.stuba.fei.uim.oop.deck;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.card.action.*;

public class ActionDeck extends Deck{

    public ActionDeck(Board board)
    {

        for(int x=0;x<10;x++)
            this.cardList.add(new Aim(board));
        for(int x=0;x<12;x++)
            this.cardList.add(new Shoot(board));
        for(int x=0;x<2;x++)
            this.cardList.add(new WildBill(board));
        for(int x=0;x<6;x++)
            this.cardList.add(new DuckMarch(board));
        for(int x=0;x<2;x++)
            this.cardList.add(new Scatter(board));

        this.cardList.add(new TurboDuck(board));
        this.cardList.add(new DuckDance(board));

        this.shuffleDeck();


    }
}
