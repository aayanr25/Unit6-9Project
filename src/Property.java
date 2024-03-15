public class Property {
    private String name;
    private int cost;
    private int rent;
    public Property(String name, int cost, int rent) {
        this.name = name;
        this.cost = cost;
        this.rent = rent;
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
    public void buyProperty(Player player) {
        if (player.deductMoney(cost)) {
            player.addToPortfolio(this);
        }
    }








}
