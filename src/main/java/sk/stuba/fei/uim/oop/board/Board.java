package sk.stuba.fei.uim.oop.board;

import sk.stuba.fei.uim.oop.card.Duck;
import sk.stuba.fei.uim.oop.card.PlayfieldCard;
import sk.stuba.fei.uim.oop.card.Water;
import sk.stuba.fei.uim.oop.deck.ActionDeck;
import sk.stuba.fei.uim.oop.deck.DuckDeck;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Crosshair[] crosshairs;
    private final List<PlayfieldCard> pond;
    private DuckDeck duckDeck;
    private ActionDeck actionDeck;
    private List<Player>players;

    public Crosshair[] getCrosshairs() {
        return crosshairs;
    }

    public Board(int numberOfPlayers)
    {
        crosshairs= new Crosshair[]{new Crosshair(1), new Crosshair(2),new Crosshair(3), new Crosshair(4),new Crosshair(5), new Crosshair(6)};
        pond=new ArrayList<>();
        boardSetUp(numberOfPlayers);
    }

    private void boardSetUp(int numberOfPlayers)
    {
        createPlayers(numberOfPlayers);
        createCardDecks();
        layOutDuckDeckCards();
        dealCards();
    }

    public void printBoard()
    {
        for (int x=0;x< pond.size();x++)
        {
            String s=(x+1)+".\t"+crosshairs[x].isAimedString()+" - "+pond.get(x).toString();
            if (pond.get(x).toString().equals("Duck"))
                s=s+" player "+((Duck) pond.get(x)).getPlayer().getId();
            System.out.println(s);
        }
        System.out.println();
    }

    private void createPlayers(int numberOfPlayers)
    {
        this.players=new ArrayList<>();
        for(int x=0;x<numberOfPlayers;x++)
            this.players.add(new Player(x+1));
    }

    private void createCardDecks()
    {
        duckDeck=new DuckDeck(players);
        actionDeck=new ActionDeck(this);
    }
    private void layOutDuckDeckCards()
    {
        for (int x=0;x<6;x++)
        {
            PlayfieldCard card= (PlayfieldCard) duckDeck.getCardList().remove(0);
            pond.add(card);
        }
    }

    private void dealCards()
    {
        for (int x=0;x<3;x++) {
            for (Player p : players)
            {
                p.takeCard(actionDeck);
            }
        }
    }
    public void moveCardToPound()
    {
        pond.add((PlayfieldCard) duckDeck.getCardList().remove(0));
    }
    public void moveCardToDuckDeck()
    {
        duckDeck.getCardList().add(pond.remove(0));
    }


    public ActionDeck getActionDeck() {
        return actionDeck;
    }

    public List<PlayfieldCard> getPond() {
        return pond;
    }

    public DuckDeck getDuckDeck() {
        return duckDeck;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
