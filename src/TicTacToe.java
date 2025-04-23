public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private int size;

    public TicTacToe(int size) {
        this.size = size;
        board = new char[size][size];
        currentPlayer = 'X';
        initializeBoard();
    }

    // Initialize board with empty values
    public void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Print the current board
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check if the board is full
    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Check for a win condition
    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    // Check the rows for a win
    private boolean checkRowsForWin() {
        for (int i = 0; i < size; i++) {
            if (checkRowCol(board[i])) {
                return true;
            }
        }
        return false;
    }

    // Check the columns for a win
    private boolean checkColumnsForWin() {
        for (int i = 0; i < size; i++) {
            char[] column = new char[size];
            for (int j = 0; j < size; j++) {
                column[j] = board[j][i];
            }
            if (checkRowCol(column)) {
                return true;
            }
        }
        return false;
    }

    // Check the diagonals for a win
    private boolean checkDiagonalsForWin() {
        char[] diagonal1 = new char[size];
        char[] diagonal2 = new char[size];
        for (int i = 0; i < size; i++) {
            diagonal1[i] = board[i][i];
            diagonal2[i] = board[i][size - 1 - i];
        }
        return (checkRowCol(diagonal1) || checkRowCol(diagonal2));
    }

    // Check if all values in the array are the same (and not empty) indicating a win
    private boolean checkRowCol(char[] arr) {
        char first = arr[0];
        if (first == '-') return false;
        for (char c : arr) {
            if (c != first) {
                return false;
            }
        }
        return true;
    }

    // Change player marks back and forth
    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Make a move
    public boolean placeMark(int row, int col) {
        if ((row >= 0) && (row < size)) {
            if ((col >= 0) && (col < size)) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayer;
                    return true;
                }
            }
        }
        return false;
    }

    // Get current player
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public static void main(String[] args) {
        int boardSize = 4; // Example for a 4x4 board
        TicTacToe game = new TicTacToe(boardSize);
        game.printBoard();
        System.out.println();
        System.out.println("****************************");
        System.out.println();
        // Example moves
        game.placeMark(0, 0);
        game.changePlayer();
        game.placeMark(1, 1);
        game.changePlayer();
        game.placeMark(0, 1);
        game.changePlayer();
        game.placeMark(1, 0);
        game.changePlayer();
        game.placeMark(0, 2);
        game.changePlayer();
        game.placeMark(2, 2);
        game.changePlayer();
        game.placeMark(3, 3);
        game.changePlayer();
        game.placeMark(1, 3);
        game.changePlayer();
        game.placeMark(0, 3);
        game.printBoard();

        if (game.checkForWin()) {
            System.out.println("We have a winner! Congrats!");
        } else if (game.isBoardFull()) {
            System.out.println("Appears we have a draw!");
        } else {
            System.out.println("Keep playing.");
        }
    }
}
