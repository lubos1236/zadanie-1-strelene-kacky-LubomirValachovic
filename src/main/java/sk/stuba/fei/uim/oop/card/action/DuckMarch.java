package sk.stuba.fei.uim.oop.card.action;

import sk.stuba.fei.uim.oop.board.Board;

public class DuckMarch extends ActionCard{
    public DuckMarch(Board board) {
        super(board);
    }

    @Override
    public void useCard() {
        board.moveCardToDuckDeck();
        board.moveCardToPound();
    }
    @Override
    public boolean canPlayCard() {
        return true;
    }
}
