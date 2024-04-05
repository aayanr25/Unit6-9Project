public class Jail extends Property {
    private boolean p1;
    private boolean p2;

    public Jail() {

        super(ConsoleUtility.WHITE + "JAIL" + ConsoleUtility.RESET, 0, 0);
    }

    public boolean p1Jail() {
        return p1;
    }
    public boolean p2Jail() {
        return p2;
    }
}
