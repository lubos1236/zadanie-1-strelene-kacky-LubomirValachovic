package sk.stuba.fei.uim.oop.card;

import sk.stuba.fei.uim.oop.player.Player;


public class Duck extends PlayfieldCard {
    private final Player player;

    public Duck(Player p)
    {
        this.player=p;
    }

    public Player getPlayer() {
        return player;
    }
}
