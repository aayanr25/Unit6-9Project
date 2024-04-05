import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Turn {
    private boolean isGameOver = false;
    private int d1;
    private int d2;
    private int doubles;
    private Player player;
    private Player otherPlayer;
    private Scanner scan;
    private Board board;


    public Turn() {
        scan = new Scanner(System.in);
        board = new Board();
        ArrayList<Player> playerList = board.getSetup().getPlayerList();
        while (!isGameOver) {
            for (int i = 0; i < playerList.size(); i++) {
                this.player = playerList.get(i);
                if (i == 0) {
                    this.otherPlayer = playerList.get(1);
                } else {
                    this.otherPlayer = playerList.get(0);
                }
                menu();
            }
        }
    }


    private void menu() {
        System.out.println("It's your turn, " + player.getName());
        board.printBoard();
        pause(1000);
        System.out.println("1. View your portfolio");
        System.out.println("2. Roll the dice and move");
        System.out.print("Enter your choice: ");
        String input = scan.nextLine();
        if (input.equals("1")) {
            player.printPortfolio();
            pause(2500);
        } else if (input.equals("2")) {
            int roll = getRoll();
            System.out.println("You rolled a " + roll);
            player.move(roll);
            pause(1000);
            board.printBoard();
            handleLanding();
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
            if (landedProperty instanceof Railroad) {
                Railroad railroad = (Railroad) landedProperty;
                handleRailroadLanding(railroad);
            } else {
                if (landedProperty.getOwner() > 0 && landedProperty.getOwner() != player.getPlayerNum()) {
                    boolean paidRent = landedProperty.chargeRent(player, otherPlayer);
                    if (paidRent) {
                        System.out.println(player.getName() + " paid rent for " + landedProperty.getName());
                    } else {
                        System.out.println(player.getName() + " couldn't afford the rent for " + landedProperty.getName());
                        // need to add consequence here
                    }
                } else {
                    if (landedProperty.getOwner() != player.getPlayerNum()) {
                        System.out.println("Do you want to buy " + landedProperty.getName() + " for $" + landedProperty.getCost() + "? (y/n)");
                        String input = scan.nextLine().toLowerCase();
                        if (input.equals("y")) {
                            boolean bought = landedProperty.buyProperty(player);
                            if (bought) {
                                System.out.println(player.getName() + " bought " + landedProperty.getName());
                            } else {
                                System.out.println("You don't have enough funds to buy " + landedProperty.getName() + ".");
                            }
                        } else if (input.equals("n")) {
                            System.out.println(player.getName() + " chose not to buy " + landedProperty.getName() + ".");
                        } else {
                            System.out.println("Invalid input. Assuming you chose not to buy.");
                        }
                    }
                }
            }
        }
    }

    private void handleRailroadLanding(Railroad railroad) {
            // Check if the railroad is owned by the other player and charge rent accordingly
            if (railroad.getOwner() == otherPlayer.getPlayerNum()) {
                boolean paidRent = railroad.chargeRent(player, otherPlayer);
                if (paidRent) {
                    System.out.println(player.getName() + " paid rent to " + otherPlayer.getName() + " for landing on " + railroad.getName());
                } else {
                    System.out.println(player.getName() + " couldn't afford the rent for " + railroad.getName());
                }
            }
        }


    private void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // set the interrupt flag
            System.out.println("Failed to pause the program.");
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


}
