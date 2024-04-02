import java.util.ArrayList;

public class Board {
    private Property[][] board;
    private ArrayList<Property> allProperties;
    public Board() {
        board = new Property[7][7];
        setupBoard();

    }

    public Property[][] getBoard() {
        return board;
    }
    public ArrayList<Property> getAllProperties() {
        return allProperties;
    }

public void printBoard() {
    String cellFormat = "|%-40s"; // vertical bar on the outside, each box is 40 spaces.
    // where I learned how to do this: https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-print-table-format-printf-chart-console-scanner-println-line
    printBoardBorder();

    for (Property[] row : board) {
        for (Property property : row) {
                System.out.printf(cellFormat, property);
        }
        System.out.println("|"); // closses the last cell of each row
        printBoardBorder(); // close bottom of box after each row
    }
}

// closes off boxes around each property
    private void printBoardBorder() {
        for (int i = 0; i < 7; i++) {
            System.out.print("+");
            for (int j = 0; j < 40; j++) {
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
        board[0][0] = new Property("GO", 0, 0);
        board[0][6] = new Jail();
        board[6][0] = new Property("FREE PARKING", 0, 0);
        board[6][6] = new Property("GO TO JAIL", 0, 0);
    }

    private void initializePropList() {
        allProperties = new ArrayList<>();
        allProperties.add(0, new Property("WorldTradeCenter", 600, 50));
        allProperties.add(0, new Property("JFKAirport", 600, 50));
        allProperties.add (0, new Railroad("GrandCentralStation", 250));
        allProperties.add(0, new Property("Broadway", 50, 40));
        allProperties.add(0, new Property("BrooklynTech", 500, 40));
        allProperties.add(0, new Property("BrightonBoardwalk", 500, 40));
        allProperties.add(0, new Property("TheMet", 450, 35));
        allProperties.add(0, new Railroad("PennStation", 250));
        allProperties.add(0, new Property("ConeyIsland", 400, 30));
        allProperties.add(0, new Property("BryantParkLibrary", 400, 30));
        allProperties.add(0, new Property("ConeyIslandAquarium", 300, 20));
        allProperties.add(0, new Property("RockefellerPlaza", 300, 20));
        allProperties.add(0, new Railroad("AtlanticAvenue-BarclaysCenterStation", 250));
        allProperties.add(0, new Property("LaBagel", 250, 15));
        allProperties.add(0, new Property("Dave&Busters", 200, 10));
        allProperties.add(0, new Property("TheStrandBookstore", 200, 10));
        allProperties.add(0, new Property("Petco", 200, 10));
        allProperties.add(0, new Railroad("StillwellAvenueStation", 250));
        allProperties.add(0, new Property("Rocky's", 100, 5));
        allProperties.add(0, new Property("Toys-R-Us", 100, 5));

    }
}
