package sk.stuba.fei.uim.oop.card.action;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.board.Crosshair;
import sk.stuba.fei.uim.oop.card.Duck;
import sk.stuba.fei.uim.oop.card.PlayfieldCard;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Shoot extends ActionCard{

    public Shoot(Board board) {
        super(board);
    }

    @Override
    public void useCard()
    {
        while (true)
        {
            int targetIndex = ZKlavesnice.readInt("Enter position where you want to shoot (1-6): ")-1;
            if (targetIndex>-1 && targetIndex<6)
                if (board.getCrosshairs()[targetIndex].isAimed())
                {
                    PlayfieldCard target=board.getPond().get(targetIndex);
                    if (doShoot(target,targetIndex))
                        return;
                }
        }
    }
    @Override
    public boolean canPlayCard()
    {
        for (Crosshair c:board.getCrosshairs())
        {
            if (c.isAimed())
                return true;
        }
        return false;
    }
    public boolean doShoot(PlayfieldCard target,int targetIndex)
    {
        if (target.toString().equals("Duck"))
        {
            Duck d=(Duck) target;
            d.getPlayer().destoyDuck(d);
            board.getPond().remove(d);
            board.moveCardToPound();
        }
        board.getCrosshairs()[targetIndex].setIfIsAimed(false);
        return true;
    }
}
