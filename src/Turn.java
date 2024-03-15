import java.util.ArrayList;

public class Turn {
    private int d1;
    private int d2;
    private ArrayList<Player> players;

    public Turn(Player player) {

    }

    private int getRoll() {
        d1 = (int) (Math.random() * 6) + 1;
        d2 = (int) (Math.random() * 6) + 1;
        return d1 + d2;
    }

    private boolean isDouble() {
        return d1 == d2;
    }
}
