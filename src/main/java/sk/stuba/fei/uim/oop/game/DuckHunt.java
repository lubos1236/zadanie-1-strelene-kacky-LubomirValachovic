package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.List;

public class DuckHunt {
    private Board board;
    private List<Player> players;

    public DuckHunt() {
        System.out.println("------Welcome in DuckHunt Lite------");
        int numberOfPlayers;
        do {
            numberOfPlayers = ZKlavesnice.readInt("Enter number of players: (2-6): ");
        }while (numberOfPlayers < 2 || numberOfPlayers > 6);

        startNewGame(numberOfPlayers);
    }
    public void startNewGame(int numberOfPlayers)
    {
        board=new Board(numberOfPlayers);
        players=board.getPlayers();
        play();
    }
    public void play()
    {
        while (countAlivePlayers()!=1)
        {
            for (Player p:players)
            {
                if (!p.isAlive())
                    continue;
                System.out.println("Player: "+p.getId()+"\t Duck(s) alive: "+p.getDuckList().size());
                board.printBoard();
                p.playerTurn(board);
                checkPlayersHpAndKill();
                if (countAlivePlayers()==1)
                    break;
                System.out.println("---------------------------------------------------------------------");
            }
        }

        Player winner=players.stream().filter(player -> player.isAlive()).findFirst().get();

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--------------------CONGRATULATION Player "+winner.getId()+" Win---------------------------");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("\n\n");
        System.out.println("    |@@@@|     |####|");
        System.out.println("    |@@@@|     |####|");
        System.out.println("    |@@@@|     |####|");
        System.out.println("    \\@@@@|     |####/");
        System.out.println("     \\@@@|     |###/");
        System.out.println("      `@@|_____|##'");
        System.out.println("           (O)");
        System.out.println("        .-'''''-.");
        System.out.println("      .'  * * *  `.");
        System.out.println("     :  *       *  :");
        System.out.println("    : ~   PLAYER  ~ :");
        System.out.println("    : ~     "+winner.getId()+"     ~ :");
        System.out.println("     :  *       *  :");
        System.out.println("      `.  * * *  .'");
        System.out.println("        `-.....-'");
    }
    private void checkPlayersHpAndKill()
    {
        players.forEach(p ->{ if(p.getDuckList().size() == 0) p.killPlayer();});
    }
    private int countAlivePlayers()
    {
        return (int) players.stream().filter(p -> p.isAlive()).count();
    }

}