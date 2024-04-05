import java.util.ArrayList;
import java.util.Scanner;

public class Setup {
    private Scanner scan;
    private ArrayList<Player> playerList;

    public Setup() {
        scan = new Scanner(System.in);
        initializePlayers();

    }
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
    public Player getP1() {
        return playerList.get(0);
    }
    public Player getP2() {
        return playerList.get(1);
    }

    public void initializePlayers() {
        playerList = new ArrayList<>();
        System.out.print("Player 1 Name: ");
        Player p1 = new Player(scan.nextLine(), 1);
        System.out.print("Player 2 Name: ");
        Player p2 = new Player(scan.nextLine(), 2);
        playerList.add(p1);
        playerList.add(p2);
    }
}
