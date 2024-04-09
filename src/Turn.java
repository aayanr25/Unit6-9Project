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
    private Chance chance;


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
                if (!checkJail()) {
                    pause(1000);
                    menu();
                } else {
                    System.out.println(player.getName() + " is in jail!");
                    pause(1000);
                }
            }
        }
    }


    private void menu() {
        chance = new Chance(player);
        System.out.println("It's your turn, " + player.getName());
        System.out.println("Current net worth: $" + player.getNetWorth());
        board.printBoard();
        pause(1000);
        System.out.println("1. View your portfolio");
        System.out.println("2. Roll the dice and move");
        System.out.println("3. End game");
        System.out.print("Enter your choice (1, 2 or 3): ");
        String input = scan.nextLine();
        if (input.equals("1")) {
            player.printPortfolio();
            pause(2500);
            System.out.println("Now rolling the dice...");
            pause(500);
            roll();
        } else if (input.equals("2")) {
            roll();

        } else if (input.equals("3")) {
            isGameOver = true;
            System.out.println("Game over./n" + player.getName() + " net worth: " + player.getNetWorth());
            System.out.println(otherPlayer.getName() + " net worth: " + otherPlayer.getNetWorth());
        }
        else {
            System.out.println("Invalid choice. Please choose again.");
            menu();
        }
        pause(1000);
    }

    private void roll() {
        int roll = getRoll();
        System.out.println("You rolled a " + roll);
        player.move(roll);
        pause(1000);
        board.printBoard();
        handleLanding();
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
        if (landedProperty instanceof Jail) {
            System.out.println("Just visiting jail!");
        }
        if (landedProperty.getName().contains("PARKING")) {
            player.addMoney(100);
            System.out.println("You landed on free parking! $100 added.");
        }
        if (landedProperty.getName().contains("GO TO JAIL")) {
            sendPlayerToJail();
        }
        // check to make sure the landed property is not empty or a corner.
        if (landedProperty != null && !landedProperty.getName().equals("X") && !landedProperty.getName().contains("GO") && !landedProperty.getName().contains("JAIL") && !landedProperty.getName().contains("PARKING")) {
            System.out.println(player.getName() + " landed on " + landedProperty.getName());
            if (landedProperty instanceof Railroad) {
                Railroad railroad = (Railroad) landedProperty;
                handleRailroadLanding(railroad);
                handleBuy(railroad);
            } else {
                if (landedProperty.getOwner() > 0 && landedProperty.getOwner() != player.getPlayerNum()) {
                    boolean paidRent = landedProperty.chargeRent(player, otherPlayer);
                    if (paidRent) {
                        System.out.println(player.getName() + " paid rent for " + landedProperty.getName());
                    } else {
                        System.out.println(player.getName() + " couldn't afford the rent for " + landedProperty.getName());
                        // need to add consequence here
                        isGameOver = true;
                        System.out.println(player.getName() + " is now bankrupt! " + otherPlayer.getName() + " has won the game!");
                    }
                } else {
                    handleBuy(landedProperty);
                }
            }
        }
        int num = (int) (Math.random() * 6) + 1;
        if (num == 1) {
            chance.chancePull();
            pause(1500);
        }
    }

    private void handleBuy(Property landedProperty) {
        if (landedProperty.getOwner() != player.getPlayerNum()) {
            System.out.print("Do you want to buy " + landedProperty.getName() + " for $" + landedProperty.getCost() + "? (y/n) ");
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
            System.out.println("Failed to pause the program.");
        }
    }

    private void sendPlayerToJail() {
        System.out.println(player.getName() + " must go to jail!");
        System.out.println("3 turns until you're back.");

        player.setX(6);
        player.setY(0);
        player.setJail(true);

        // handle any additional logic for a player going to jail

    }
    private boolean checkJail() {
        if (player.inJail()) {
            if (player.getTurnsInJail() == 3) {
                return false;
            } else {
                player.incrementTurnsInJail();
            }
            return true;
        }
        return false;
    }



    public Property getProperty(String propName) {
        for (Property prop : board.getAllProperties()) {
            if (prop.getName().equals(propName)) {
                return prop;
            }
        }
        return null;
    }


}
