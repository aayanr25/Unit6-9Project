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
        player.setY(0);
        player.setX(0);
    }

    private void getOutOfJailFree() {

    }

    private void goForward() {
        System.out.println("Move forward 3 spaces");
        player.move(3);
    }

    private void tax() {
        int num = (int) (Math.random() * 10 + 1);
        int x = 0;
        if (num <= 5) {
            x = 25;
        } else if (num <= 7) {
            x = 50;
        } else {
            x = 100;
        }

        System.out.println("Pay tax of $" + x);

        player.deductMoney(x);
    }
}
