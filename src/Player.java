import java.util.ArrayList;
public class Player {

    private String name;
    private int netWorth;
    private ArrayList<Property> portfolio;

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

    public ArrayList<Property> getPortfolio() {
        return portfolio;
    }

    public void addMoney(int deposit) {
        netWorth += deposit;
    }

    public void deductMoney(int money) {
        if (netWorth >= money) {
            netWorth -= money;
        } else {
            System.out.println("Sorry, you dont have enough funds for that!");
        }
    }

    public void addToPortfolio(Property property) {
        portfolio.add(portfolio.size(), property);
    }

    public void removeFromPortfolio(Property property) {
        for (Property prop : portfolio) {

        }
    }

}
