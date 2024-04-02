public class Railroad extends Property {
    private int rent;

    public Railroad(String name) {
        super(name, 250, 25);

    }

    @Override
    public boolean buyProperty(Player player) {
        player.addRailroad();
        super.buyProperty(player);
    }
}
