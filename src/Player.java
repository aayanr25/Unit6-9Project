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
            }
        }
    }

}
