public class Chance extends Property {

    Player player;
    public Chance(String name, int cost, int rent, Player player) {
        super("CHANCE", 0, 0);
        this.player = player;
    }

    public void chancePull() {
        int chance = (int) (Math.random() * 20 + 1);
    }

    private void moveToGO() {
        System.out.println("Advance to GO & Collect $200");
        player.setX(0);
        player.setY(0);
    }
}
