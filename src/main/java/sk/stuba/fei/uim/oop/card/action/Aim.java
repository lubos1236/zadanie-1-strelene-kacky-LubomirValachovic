package sk.stuba.fei.uim.oop.card.action;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.board.Crosshair;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Aim extends ActionCard{

    public Aim(Board board) {
        super(board);
    }

    @Override
    public void useCard() {
        while (true)
        {
            int targetIndex = ZKlavesnice.readInt("Enter number of crosshair where you want to aim (1-6): ")-1;
            if (targetIndex>-1 && targetIndex<6)
                if (!board.getCrosshairs()[targetIndex].isAimed())
                {
                    board.getCrosshairs()[targetIndex].setIfIsAimed(true);
                    return;
                }
        }
    }

    @Override
    public boolean canPlayCard() {
        for (Crosshair c:board.getCrosshairs())
        {
            if (!c.isAimed())
                return true;
        }
        return false;
    }
}
