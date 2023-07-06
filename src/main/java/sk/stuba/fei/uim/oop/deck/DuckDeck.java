package sk.stuba.fei.uim.oop.deck;

import sk.stuba.fei.uim.oop.card.Water;
import sk.stuba.fei.uim.oop.player.Player;

import java.util.List;

public class DuckDeck extends Deck{

    public DuckDeck(List<Player>players)
    {
        for(int x=0;x<5;x++)
            this.cardList.add(new Water());
        for(Player player: players)
            player.getDuckList().forEach(duck -> cardList.add(duck));
        this.shuffleDeck();
    }
}
