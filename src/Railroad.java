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
    public boolean chargeRent(Player player, Player otherPlayer) {
        int numOwned = otherPlayer.getRailroadsOwned();
        setRent(numOwned * getRent());
        return super.chargeRent(player, otherPlayer);
    }

}
