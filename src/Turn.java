import java.util.ArrayList;
import java.util.Scanner;

public class Turn {
    private boolean isGameOver = false;
    private int d1;
    private int d2;
    private int doubles;
    private Player player;
    private Scanner scan;
    private String[][] board;
    private ArrayList<Player> playerList = new ArrayList<>();


    public Turn() {
        scan = new Scanner(System.in);
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

    private void setupBoard() {
        board = new String[7][7];
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                board[i][j] = "X";
            }
        }
    }

    private void menu() {
        System.out.println("It's your turn, " + player.getName());

    }
}
