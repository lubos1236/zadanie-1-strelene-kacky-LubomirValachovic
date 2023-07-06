package sk.stuba.fei.uim.oop.card.action;

import sk.stuba.fei.uim.oop.board.Board;

public class DuckDance extends ActionCard{
    public DuckDance(Board board) {
        super(board);
    }

    @Override
    public void useCard() {
        while (board.getPond().size()!=0)
            board.moveCardToDuckDeck();
        board.getDuckDeck().shuffleDeck();
        while (board.getPond().size()!=6)
            board.moveCardToPound();
    }
    @Override
    public boolean canPlayCard() {
        return true;
    }
}
