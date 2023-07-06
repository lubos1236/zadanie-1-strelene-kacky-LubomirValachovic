package sk.stuba.fei.uim.oop.card.action;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.card.PlayfieldCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Scatter extends ActionCard{
    private final Random random;
    public Scatter(Board board) {
        super(board);
        random=new Random(System.nanoTime());
    }


    @Override
    public void useCard() {
        List<PlayfieldCard> tempList=new ArrayList<>(board.getPond());
        do {
            Collections.shuffle(board.getPond(),random);
        }while (board.getPond().equals(tempList));
    }
    @Override
    public boolean canPlayCard() {
        return true;
    }
}
