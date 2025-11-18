public class TicTacToe {
    //Create board outside of main method
    static String [][] board = new String[3][3];

    public static void main(String[] args) {
      //Game simulation happens here
    }

    //Helper methods go here
    //Sets all the board elements to "-"
    private static void clearBoard() {

    }
    //Shows the Tic Tac Toe game board in its current states
    private static void displayBoard() {

    }
    //returns true if there is a space at the given proposed move coordinates, which means it is a legal move, returns false otherwise.
    private static boolean isValidMove(int r, int c) {

    }
    //checks to see if there is a win state on the current board for the specified player (X or O).
    private static boolean isWin (String player) {

    }
    //checks for a col win for the specified player
    private static boolean isColWin(String player) {

    }
    //checks for a row win for the specified player
    private static boolean isRowWin(String player) {

    }
    //checks for a diagonal win for the specified player
    private static boolean isDiagonalWin(String player) {

    }
    //checks for a tie condition: all spaces on the board are filled, and no win has occurred
    private static boolean isTie(String player1, String player2) {

    }
}