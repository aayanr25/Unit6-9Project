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
        allProperties.add(new Property("Grand Central", 600, 50));
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
