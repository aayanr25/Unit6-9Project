import java.util.ArrayList;

public class Property {
    private String name;
    private int cost;
    private int rent;
    private boolean isOwned;
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
    public void setRent(int num) {
        rent = num;
    }
    public boolean isOwned() {
        return isOwned;
    }
    public boolean buyProperty(Player player) {
        if (player.deductMoney(cost)) {
            player.addToPortfolio(this);
            isOwned = true;
            return true;
        }
        return false;
    }
    public boolean chargeRent(Player player) {
        return player.deductMoney(rent);
    }


    public String toString() {
        return name;
    }






}