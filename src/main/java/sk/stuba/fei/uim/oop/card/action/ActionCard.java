package sk.stuba.fei.uim.oop.card.action;

import sk.stuba.fei.uim.oop.board.Board;

public abstract class ActionCard {
    public abstract void useCard();
    public abstract boolean canPlayCard();
    protected final Board board;
    public ActionCard(Board board)
    {
        this.board=board;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
