import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Turn {
    private boolean isGameOver = false;
    private ArrayList<Property> allProperties;
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
        board = new String[9][9];
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                board[i][j] = "X";
            }
        }

        initializePropList();
        
    }

    private void menu() {
        System.out.println("It's your turn, " + player.getName());

    }

    private void initializePropList() {
        allProperties = new ArrayList<>();
        allProperties.add(new Property("World Trade Center", 600, 50));
        allProperties.add(new Property("JFK Airport", 600, 50));
        allProperties.add(new Property("Broadway", 600, 50));
        allProperties.add(new Property("Brooklyn Tech", 500, 40));
        allProperties.add(new Property("Brighton Boardwalk", 500, 40));
        allProperties.add(new Property("Rockaway Beach", 500, 40));
        allProperties.add(new Property("The Met", 450, 35));
        allProperties.add(new Property("Bronx Zoo", 400, 30));
        allProperties.add(new Property("Coney Island", 400, 30));
        allProperties.add(new Property("Bryant Park Library", 400, 30));
        allProperties.add(new Property("Coney Island Aquarium", 300, 20));
        allProperties.add(new Property("Rockefeller Plaza", 300, 20));
        allProperties.add(new Property("AMC Times Square", 300, 20));
        allProperties.add(new Property("La Bagel", 250, 15));
        allProperties.add(new Property("Dave & Busters", 200, 10));
        allProperties.add(new Property("The Strand Bookstore", 200, 10));
        allProperties.add(new Property("Petco", 200, 10));
        allProperties.add(new Property("Rocky's", 100, 5));
        allProperties.add(new Property("Pizza Parlor", 100, 5));
        allProperties.add(new Property("Toys-R-Us", 100, 5));
    }
}
