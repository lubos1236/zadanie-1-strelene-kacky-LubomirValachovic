package sk.stuba.fei.uim.oop.card.action;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.card.PlayfieldCard;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.Collections;

public class TurboDuck extends ActionCard{
    public TurboDuck(Board board) {
        super(board);
    }

    @Override
    public void useCard() {
        int index;
        while (true)
        {
            int targetIndex = ZKlavesnice.readInt("Enter position of Duck you want to move: ")-1;
            if (targetIndex>0 && targetIndex<7)
            {
                PlayfieldCard target=board.getPond().get(targetIndex);
                if (target.toString().equals("Duck"))
                {
                    while ((index=board.getPond().indexOf(target))!=0)
                        Collections.swap(board.getPond(),index,index-1);
                    return;
                }
            }

        }
    }

    @Override
    public boolean canPlayCard() {
        return true;
    }
}
