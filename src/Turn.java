import java.util.ArrayList;

public class Turn {
    private int d1;
    private int d2;
    private int doubles;
    private ArrayList<Player> players;

    public Turn(Player player) {

    }

    public int getRoll() {
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
}
