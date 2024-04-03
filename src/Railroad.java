public class Railroad extends Property {

    public Railroad(String name) {
        super(name, 250, 25);

    }

    @Override
    public boolean buyProperty(Player player) {
        player.addRailroad();
        return super.buyProperty(player);
    }

    @Override
    public boolean chargeRent(Player player) {
        int numOwned = player.getRailroadsOwned();
        setRent(numOwned * getRent());
        return super.chargeRent(player);
    }

}
