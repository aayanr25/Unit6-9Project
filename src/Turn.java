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
        scan = new Scanner(System.in);
        board = new Board();
        while (!isGameOver) {
            for (Player player : board.getSetup().getPlayerList()) {
                this.player = player;
                menu();
            }
        }
    }


    private void playTurn() {
        menu();
    }

    private void menu() {
        System.out.println("It's your turn, " + player.getName());
        board.printBoard();
        System.out.println("1. View your portfolio");
        System.out.println("2. Roll the dice and move");
        System.out.print("Enter your choice: ");

        String input = scan.nextLine();
        if (input.equals("1")) {
            player.printPortfolio();
        } else if (input.equals("2")) {
            int roll = getRoll();
            System.out.println("You rolled a " + roll);
            player.move(roll);
            handleLanding();
            board.printBoard();
        } else {
            System.out.println("Invalid choice. Please choose again.");
            menu();
        }
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

    private void handleLanding() {
        Property landedProperty = board.getPointOnBoard(player.getX(), player.getY());
        // check to make sure the landed property is not empty or a corner.
        if (landedProperty != null && !landedProperty.getName().equals("X") && !landedProperty.getName().contains("GO") && !landedProperty.getName().contains("JAIL") && !landedProperty.getName().contains("PARKING")) {
            System.out.println(player.getName() + " landed on " + landedProperty.getName());
            if (landedProperty.getOwner() != player.getPlayerNum()) {
                boolean paidRent = landedProperty.chargeRent(player);
                if (paidRent) {
                    System.out.println(player.getName() + " paid rent for " + landedProperty.getName());
                } else {
                    System.out.println(player.getName() + " couldn't afford the rent for " + landedProperty.getName());
                    // need to add consequence here
                }
            } else {
                if (landedProperty.getOwner() != player.getPlayerNum()) {
                    boolean bought = landedProperty.buyProperty(player);
                    if (bought) {
                        System.out.println(player.getName() + " bought " + landedProperty.getName());
                    } else {
                        System.out.println(landedProperty.getName() + " remains available.");
                    }
                }
            }
        }
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
