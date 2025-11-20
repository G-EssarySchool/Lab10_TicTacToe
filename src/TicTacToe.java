import java.util.Scanner;

public class TicTacToe {
    //Create board outside of main method
    static String[][] board = new String[3][3];

    //Game simulation happens here
    public static void main(String[] args) {
        //Variables:
        Scanner scan = new Scanner(System.in);
        String player1 = "X";
        String player2 = "O";
        int p1row;
        int p1col;
        int p2row;
        int p2col;
        boolean player1Valid;
        boolean player2Valid;
        boolean gameOver;
        boolean playAgain;

        do {
            clearBoard();
            displayBoard();
            gameOver = false;

            while (!gameOver) {
                //P1 turn
                System.out.println("X's turn:");
                player1Valid = false;
                while (!player1Valid) {
                    p1row = InputHelper.getRangedInt(scan, "Enter row [1-3]: ", 1, 3) - 1;
                    p1col = InputHelper.getRangedInt(scan, "Enter column [1-3]: ", 1, 3) - 1;
                    scan.nextLine();

                    if (isValidMove(p1row, p1col)) {
                        player1Valid = true;
                        board[p1row][p1col] = player1;
                    } else {
                        System.out.println("Invalid move, Spot is already taken.");
                    }
                }

                displayBoard();

                if (isWin(player1)) {
                    System.out.println("X wins!");
                    gameOver = true;
                    break;
                } else if (isTie(player1, player2)) {
                    System.out.println("It's a tie!");
                    gameOver = true;
                    break;
                }

                //P2 turn
                System.out.println("O's turn:");
                player2Valid = false;
                while (!player2Valid) {
                    p2row = InputHelper.getRangedInt(scan, "Enter row [1-3]: ", 1, 3) - 1;
                    p2col = InputHelper.getRangedInt(scan, "Enter column [1-3]: ", 1, 3) - 1;
                    scan.nextLine();

                    if (isValidMove(p2row, p2col)) {
                        player2Valid = true;
                        board[p2row][p2col] = player2;
                    } else {
                        System.out.println("Invalid move, Spot is already taken.");
                    }
                }

                displayBoard();

                if (isWin(player2)) {
                    System.out.println("O wins!");
                    gameOver = true;
                } else if (isTie(player1, player2)) {
                    System.out.println("It's a tie!");
                    gameOver = true;
                }
            }

            String replay = InputHelper.getYNConfirm(scan, "Do you want to play again? [Y/N]");
            playAgain = replay.equalsIgnoreCase("Y");

        } while (playAgain);

        System.out.println("Thanks for playing!");
    }


    //Helper methods go here
    //Sets all the board elements to "-"
    private static void clearBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = "-";
            }
        }
    }

    //Shows the Tic Tac Toe game board in its current states
    private static void displayBoard() {
        System.out.println();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //returns true if there is a space at the given proposed move coordinates, which means it is a legal move, returns false otherwise.
    private static boolean isValidMove(int r, int c) {
        return r >= 0 && r < 3 && c >= 0 && c < 3 && board[r][c].equals("-");
    }

    //checks to see if there is a win state on the current board for the specified player (X or O).
    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    //checks for a col win for the specified player
    private static boolean isColWin(String player) {
        for (int c = 0; c < 3; c++) {
            if (board[0][c].equals(player) && board[1][c].equals(player) && board[2][c].equals(player)) {
                return true;
            }
        }
        return false;
    }

    //checks for a row win for the specified player
    private static boolean isRowWin(String player) {
        for (int r = 0; r < 3; r++) {
            if (board[r][0].equals(player) && board[r][1].equals(player) && board[r][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    //checks for a diagonal win for the specified player
    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    //checks for a tie condition: all spaces on the board are filled, and no win has occurred
    private static boolean isTie(String player1, String player2) {
        if (isWin(player1) || isWin(player2)) return false;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c].equals("-")) return false;
            }
        }
        return true;
    }
}
