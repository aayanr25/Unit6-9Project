public class Chance extends Property {

    Player player;
    public Chance(Player player) {
        super("CHANCE", 0, 0);
        this.player = player;
    }

    public void chancePull() {
        int chance = (int) (Math.random() * 20 + 1);
        if (chance <= 3) {
            moveToGO();
        } else if (chance <= 10) {
            goForward();
        } else if (chance <= 14) {
            tax();
        } else if (chance <= 18) {
            payment();
        } else {
            getOutOfJailFree();
        }
    }

    private void moveToGO() {
        System.out.println("CHANCE CARD: Advance to GO & Collect $200");
        player.setY(0);
        player.setX(0);
    }

    private void getOutOfJailFree() {
        if (!player.getFreeEscape()) {
            player.setFreeEscape();
            System.out.println("CHANCE CARD: You got a get out of jail free card!");
        } else {
            System.out.println("You already got a get out of jail free card, sorry!");
        }
    }

    private void goForward() {
        System.out.println("CHANCE CARD: Move forward 3 spaces");
        player.move(3);
    }

    private void tax() {
        int num = (int) (Math.random() * 10 + 1);
        int x = 0;
        if (num <= 5) {
            x = 25;
        } else if (num <= 8) {
            x = 50;
        } else {
            x = 100;
        }

        System.out.println("CHANCE CARD: Pay tax of $" + x);

        player.deductMoney(x);
    }

    private void payment() {
        int num = (int) (Math.random() * 10 + 1);
        int x = 0;
        if (num <= 5) {
            x = 25;
        } else if (num <= 8) {
            x = 50;
        } else {
            x = 100;
        }

        System.out.println("CHANCE CARD: " + player.getName() + " gained a sum of $" + x);

        player.addMoney(x);
    }
}
