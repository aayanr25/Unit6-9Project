import java.util.ArrayList;
public class Player {

    private String name;
    private int netWorth;
    private ArrayList<Property> portfolio;
    private int xPos;
    private int yPos;
    private int railroadsOwned;

    public Player(String name) {
        this.name = name;
        netWorth = 0;
        portfolio = new ArrayList<>();
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
        for (int num = 0; num < roll; num++) {
            if (yPos == 0 && xPos < 6) {
                xPos++;
            }
            else if (xPos == 6 && yPos < 6) {
                yPos++;
            }
            else if (yPos == 6 && xPos > 0) {
                xPos--;
            }
            else if (xPos == 0 && yPos > 0) {
                yPos--;
            }
        }
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

    public void passGo() {
        netWorth += 200;
    }
    public void addRailroad() {
        railroadsOwned++;
    }

}
