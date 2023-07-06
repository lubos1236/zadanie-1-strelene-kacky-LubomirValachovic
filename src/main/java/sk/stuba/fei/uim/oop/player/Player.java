package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.card.Duck;
import sk.stuba.fei.uim.oop.card.action.ActionCard;
import sk.stuba.fei.uim.oop.deck.ActionDeck;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private boolean isAlive;
    private final int ID;


    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";


    private final List<ActionCard> cardList=new ArrayList<>();
    private final List<Duck> duckList=new ArrayList<>();

    public Player(int id)
    {
        this.ID=id;
        this.isAlive=true;
        createDuckList();
    }

    private void createDuckList()
    {
        for(int x=0;x<5;x++)
            duckList.add(new Duck(this));
    }


    public void takeCard(ActionDeck deck)
    {
        this.cardList.add((ActionCard)deck.getCardList().remove(0));
    }

    public void playerTurn(Board board)
    {
        boolean[] usableArray =new boolean[3];
        int count=0;
        for (ActionCard card: cardList)
        {
            usableArray[cardList.indexOf(card)]=card.canPlayCard();
            String color=usableArray[cardList.indexOf(card)]? ANSI_BLUE:ANSI_RED;
            System.out.println(color+"Card "+(cardList.indexOf(card)+1)+": "+card);
        }
        System.out.print(ANSI_RESET);

        for (boolean b:usableArray)
        {
            if (b)
            {
                count++;
            }
        }
        if (count==0)
        {
            int trashCardIndex;
            do {
                trashCardIndex=ZKlavesnice.readInt("You cannot play any of yours cards. Which one do you want to return to the card deck(1-3)?: ")-1;
            }while (trashCardIndex<0 || trashCardIndex>2);
            board.getActionDeck().getCardList().add(cardList.remove(trashCardIndex));
        }
        else {
            int cardIndex;
            while (true)
            {
                cardIndex=ZKlavesnice.readInt("Enter number which card you want to use (1-3): ")-1;
                if (cardIndex>-1 && cardIndex<3)
                    if (usableArray[cardIndex])
                        break;
            }
            cardList.get(cardIndex).useCard();
            board.getActionDeck().getCardList().add(cardList.remove(cardIndex));
        }
        this.cardList.add((ActionCard) board.getActionDeck().getCardList().remove(0));
    }

    public void destoyDuck(Duck duck)
    {
        duckList.remove(duck);
    }
    public void killPlayer() {
        this.isAlive = false;
    }
    public boolean isAlive() {
        return isAlive;
    }
    public List<Duck> getDuckList() {
        return duckList;
    }
    public int getId() {
        return ID;
    }
}
