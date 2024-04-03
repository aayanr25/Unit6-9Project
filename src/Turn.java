import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Turn {
    private boolean isGameOver = false;

    private int d1;
    private int d2;
    private int doubles;
    private Player player;
    private Scanner scan;
    private Board board;



    public Turn() {
        board = new Board();
        board.printBoard();
//        while (!isGameOver) {
//            for (Player player : setup.getPlayerList()) {
//                this.player = player;
//                playTurn();
//            }
//        }
    }


    private void playTurn() {
        menu();

    }

    private void menu() {
        System.out.println("It's your turn, " + player.getName());

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




    public Property getProperty(String propName) {
        for (Property prop : board.getAllProperties()) {
            if (prop.getName().equals(propName)) {
                return prop;
            }
        }
        return null;
    }

    private void chance(Player player) {

    }

    public void passGo() {
        player.addMoney(200);
    }
}
