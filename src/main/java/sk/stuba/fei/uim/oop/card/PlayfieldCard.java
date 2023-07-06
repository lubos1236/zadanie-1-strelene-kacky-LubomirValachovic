package sk.stuba.fei.uim.oop.card;

public abstract class PlayfieldCard {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
