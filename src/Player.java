import java.util.ArrayList;
public class Player {

    private String name;
    private int netWorth;
    private ArrayList<Property> portfolio;
    private int xPos;
    private int yPos;
    private Turn game;
    private int railroadsOwned;

    public Player(String name, int netWorth, ArrayList<Property> portfolio) {
        this.name = name;
        this.netWorth = netWorth;
        this.portfolio = portfolio;
    }

    public String getName() {
        return name;
    }

    public int getNetWorth() {
        return netWorth;
    }
    public String toString() {
        return name;
    }

    public ArrayList<Property> getPortfolio() {
        return portfolio;
    }
    public int getX() {
        return xPos;
    }
    public void setX(int x) {
        xPos = x;
    }
    public int getY() {
        return yPos;
    }
    public void setY(int y) {
        yPos = y;

    }

    public void move(int roll) {
        int num = 0;
        while (num < roll) {
            if (canMoveRight()) {
                xPos++;
            } else if (canMoveDown()) {
                yPos++;
            } else if (canMoveLeft()) {
                xPos--;
            } else if (canMoveUp()) {
                yPos--;
            }
            num++;
        }
    }
    private boolean canMoveRight() {
        Board board = game.getBoard();
        if (xPos + 1 > 6 || board.getPointOnBoard(xPos + 1, yPos).getName().equals("X")) {
            return false;
        }
        return true;
    }
    private boolean canMoveLeft() {
        Board board = game.getBoard();
        if (xPos - 1 < 0 || board.getPointOnBoard(xPos - 1, yPos).getName().equals("X")) {
            return false;
        }
        return true;
    }
    private boolean canMoveUp() {
        Board board = game.getBoard();
        if (yPos - 1 < 0 || board.getPointOnBoard(xPos, yPos - 1).getName().equals("X")) {
            return false;
        }
        return true;
    }
    private boolean canMoveDown() {
        Board board = game.getBoard();
        if (yPos + 1 > 6 || board.getPointOnBoard(xPos, yPos + 1).getName().equals("X")) {
            return false;
        }
        return true;
    }

    public void addMoney(int deposit) {
        netWorth += deposit;
    }

    public boolean deductMoney(int money) {
        if (netWorth >= money) {
            netWorth -= money;
            return true;
        } else {
            System.out.println("Sorry, you dont have enough funds for that!");
            return false;
        }
    }

    public void addToPortfolio(Property property) {
        portfolio.add(portfolio.size(), property);
    }

    public void removeFromPortfolio(Property property) {
        for (int i = 0; i < portfolio.size(); i++) {
            if (portfolio.get(i) == property) {
                portfolio.remove(i);
                i--;
            }
        }
    }

    public void passGo() {
        netWorth += 200;
    }
    public void addRailroad() {
        railroadsOwned++;
    }

}
