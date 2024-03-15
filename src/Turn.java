import java.util.ArrayList;

public class Turn {
    private boolean isGameOver = false;
    private int d1;
    private int d2;
    private int doubles;
    private Player player;
    private ArrayList<Player> playerList = new ArrayList<>();


    public Turn() {
        while (!isGameOver) {
            for (Player player : playerList) {
                this.player = player;
                playTurn();
            }
        }
    }

    private void playTurn() {
        menu();
    }

    private int getRoll() {
        d1 = (int) (Math.random() * 6) + 1;
        d2 = (int) (Math.random() * 6) + 1;
        isDouble();
        return d1 + d2;
    }

    private boolean isDouble() {
        if (d1 == d2) {
            doubles++;
        }
        return d1 == d2;
    }

    private void menu() {
        System.out.println("It's your turn, " + player.getName());
    }
}
