import java.util.ArrayList;
public class Player {

    private String name;
    private int netWorth;
    private ArrayList<Property> portfolio;
    private int xPos;
    private int yPos;
    private int railroadsOwned;
    private boolean freeEscape;
    private  int playerNum;

    public Player(String name, int playerNum) {
        this.name = name;
        this.playerNum = playerNum;
        netWorth = 1500;
        portfolio = new ArrayList<>();
        freeEscape = false;
    }

    public String getName() {
        return name;
    }
    public int getPlayerNum() {
        return playerNum;
    }

    public int getNetWorth() {
        return netWorth;
    }
    public String toString() {
        return name;
    }
    public void setFreeEscape() {
        if (freeEscape == false) {
            freeEscape = true;
        } else {
            freeEscape = false;
        }
    }

    public boolean escapeJail() {
        return false;
    }

    public ArrayList<Property> getPortfolio() {
        return portfolio;
    }
    public void printPortfolio() {
        for (int i = 0; i < portfolio.size(); i++) {
            System.out.println("- " + portfolio.get(i));
        }
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
    public int getRailroadsOwned() {
        return railroadsOwned;
    }

    public void move(int roll) {
        for (int num = 0; num < roll; num++) {
            if (yPos == 0 && xPos < 6) {
                xPos++;
                if (checkForGo()) {
                    passGo();
                }
            }
            else if (xPos == 6 && yPos < 6) {
                yPos++;
                if (checkForGo()) {
                    passGo();
                }
            }
            else if (yPos == 6 && xPos > 0) {
                xPos--;
                if (checkForGo()) {
                    passGo();
                }
            }
            else if (xPos == 0 && yPos > 0) {
                yPos--;
                if (checkForGo()) {
                    passGo();
                }
            }
        }
    }
    private boolean checkForGo() {
        if (xPos == 0 && yPos == 0) {
            return true;
        }
        return false;
    }

    public void passGo() {
        addMoney(200);
        System.out.println("Passed Go! $200 added.");
    }

    public void addMoney(int deposit) {
        netWorth += deposit;
    }

    public boolean deductMoney(int money) {
        if (netWorth >= money) {
            netWorth -= money;
            return true;
        } else {
            System.out.println("Sorry, you don't have enough funds for that!");
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

    public void addRailroad() {
        railroadsOwned++;
    }

}
