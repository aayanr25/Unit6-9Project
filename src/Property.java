import java.util.ArrayList;

public class Property {
    private String name;
    private int cost;
    private int rent;
    private ArrayList<Property> allProperties;
    public Property(String name, int cost, int rent) {
        this.name = name;
        this.cost = cost;
        this.rent = rent;
        initializePropList();

    }

    public String getName() {
        return name;
    }
    public int getCost() {
        return cost;
    }
    public int getRent() {
        return rent;
    }
    public boolean buyProperty(Player player) {
        if (player.deductMoney(cost)) {
            player.addToPortfolio(this);
            return true;
        }
        return false;
    }
    public boolean chargeRent(Player player) {
        return player.deductMoney(rent);
    }

    public Property getProperty(String propName) {
        for (Property prop : allProperties) {
            if (prop.getName().equals(propName)) {
                return prop;
            }
        }
        return null;
    }






    private void initializePropList() {
        allProperties = new ArrayList<>();
        allProperties.add(new Property("Boardwalk", 400, 50));
    }






}
