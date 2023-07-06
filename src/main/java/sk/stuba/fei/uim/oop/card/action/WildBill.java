package sk.stuba.fei.uim.oop.card.action;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.card.PlayfieldCard;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class WildBill extends ActionCard{
    Shoot shoot;
    public WildBill(Board board) {
        super(board);
        this.shoot=new Shoot(board);
    }

    @Override
    public void useCard()
    {
        while (true)
        {

            int targetIndex = ZKlavesnice.readInt("Enter position where you want to shoot (1-6): ")-1;
            if (targetIndex>-1 && targetIndex<6)
            {
                PlayfieldCard target=board.getPond().get(targetIndex);
                if (shoot.doShoot(target,targetIndex))
                    return;
            }
        }
    }

    @Override
    public boolean canPlayCard() {
        return true;
    }
}
