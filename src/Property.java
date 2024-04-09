import java.util.ArrayList;

public class Property {
    private String name;
    private int cost;
    private int rent;
    private int owner;
    public Property(String name, int cost, int rent) {
        this.name = name;
        this.cost = cost;
        this.rent = rent;
        owner = 0;
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
    public int getOwner() {
        return owner;
    }

    public boolean buyProperty(Player player) {
        if (player.deductMoney(cost)) {
            player.addToPortfolio(this);
            owner = player.getPlayerNum();
            return true;
        }
        return false;
    }
    public boolean chargeRent(Player player, Player otherPlayer) {
         if (player.deductMoney(rent)) {
             otherPlayer.addMoney(rent);
             return true;
         }
         return false;
    }


    public String toString() {
        return name;
    }






}