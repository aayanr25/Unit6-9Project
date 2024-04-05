import java.awt.image.ConvolveOp;
import java.util.ArrayList;

public class Board {
    private Property[][] board;
    private ArrayList<Property> allProperties;
    private Turn game;
    private Setup setup;

    public Board() {
        setup = new Setup();
        board = new Property[7][7];
        setupBoard();

    }

    public Property[][] getBoard() {
        return board;
    }
    public Setup getSetup() {
        return setup;
    }

    public Property getPointOnBoard(int x, int y) {
        return board[y][x];
    }

    public ArrayList<Property> getAllProperties() {
        return allProperties;
    }

    public void printBoard() {
        String cellFormat = "|%-30s"; // vertical bar on the outside, each box is 40 spaces.
        // where I learned how to do this: https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-print-table-format-printf-chart-console-scanner-println-line
        String colorCellFormat = "|%-41s";
        printBoardBorder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Property property = board[i][j];
                String cellContent = "X";
                if (board[i][j] != null) {
                    cellContent = board[i][j].toString();
                }
                if (setup.getP1().getX() == j && setup.getP1().getY() == i) {
                    cellContent += "  *P1*";
                }
                if (setup.getP2().getX() == j && setup.getP2().getY() == i) {
                    cellContent += "  ^P2^";
                }
                if (property.getCost() == 0 && !(property.getName().equals("X"))) {
                    System.out.printf(colorCellFormat, cellContent);
                } else {
                    System.out.printf(cellFormat, cellContent);
                }
            }
            System.out.println("|");
            printBoardBorder();
        }

    }


// closes off boxes around each property
    private void printBoardBorder() {
        for (int i = 0; i < 7; i++) {
            System.out.print("+");
            for (int j = 0; j < 30; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+"); // separates properties horizontally
    }


    private void setupBoard() {
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                board[i][j] = new EmptySpace();
            }
        }
        initializePropList();
// top side
        board[0][1] = allProperties.get(0);
        board[0][2] = allProperties.get(1);
        board[0][3] = allProperties.get(2);
        board[0][4] = allProperties.get(3);
        board[0][5] = allProperties.get(4);

// right side
        board[1][6] = allProperties.get(5);
        board[2][6] = allProperties.get(6);
        board[3][6] = allProperties.get(7);
        board[4][6] = allProperties.get(8);
        board[5][6] = allProperties.get(9);

// bottom side
        board[6][5] = allProperties.get(10);
        board[6][4] = allProperties.get(11);
        board[6][3] = allProperties.get(12);
        board[6][2] = allProperties.get(13);
        board[6][1] = allProperties.get(14);

// left side
        board[5][0] = allProperties.get(15);
        board[4][0] = allProperties.get(16);
        board[3][0] = allProperties.get(17);
        board[2][0] = allProperties.get(18);
        board[1][0] = allProperties.get(19);

// corners
        board[0][0] = new Property(ConsoleUtility.GREEN + "GO" + ConsoleUtility.RESET, 0, 0);
        board[0][6] = new Jail();
        board[6][0] = new Property(ConsoleUtility.BLUE + "FREE PARKING" + ConsoleUtility.RESET, 0, 0);
        board[6][6] = new Property(ConsoleUtility.RED + "GO TO JAIL" + ConsoleUtility.RESET, 0, 0);
    }

    private void initializePropList() {
        allProperties = new ArrayList<>();
        allProperties.add(0, new Property("World Trade Center", 600, 50));
        allProperties.add(0, new Property("JFK Airport", 600, 50));
        allProperties.add (0, new Railroad("Grand Central Station"));
        allProperties.add(0, new Property("Broadway", 50, 40));
        allProperties.add(0, new Property("Brooklyn Tech", 500, 40));
        allProperties.add(0, new Property("Brighton Boardwalk", 500, 40));
        allProperties.add(0, new Property("The Met", 450, 35));
        allProperties.add(0, new Railroad("Penn Station"));
        allProperties.add(0, new Property("Coney Island", 400, 30));
        allProperties.add(0, new Property("Bryant Park Library", 400, 30));
        allProperties.add(0, new Property("Coney Island Aquarium", 300, 20));
        allProperties.add(0, new Property("Rockefeller Plaza", 300, 20));
        allProperties.add(0, new Railroad("Atlantic Terminal"));
        allProperties.add(0, new Property("La Bagel", 250, 15));
        allProperties.add(0, new Property("Dave & Busters", 200, 10));
        allProperties.add(0, new Property("The Strand Bookstore", 200, 10));
        allProperties.add(0, new Property("Petco", 200, 10));
        allProperties.add(0, new Railroad("Stillwell Avenue Station"));
        allProperties.add(0, new Property("Rocky's", 100, 5));
        allProperties.add(0, new Property("Toys-R-Us", 100, 5));

    }

    public void GamePiece() {

    }
}
