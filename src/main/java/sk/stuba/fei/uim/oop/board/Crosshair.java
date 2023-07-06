package sk.stuba.fei.uim.oop.board;

public class Crosshair{
    private boolean aimed;
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Crosshair(int pos)
    {
        this.aimed=false;
    }

    public String isAimedString() {
        return aimed?ANSI_YELLOW+"  Aimed at  "+ANSI_RESET:ANSI_RESET+"Not aimed at";
    }

    public boolean isAimed() {
        return aimed;
    }

    public void setIfIsAimed(boolean aimed) {
        this.aimed = aimed;
    }
}
