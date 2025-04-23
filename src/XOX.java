import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class XOX {
    public static void main(String[] args) {
        int turnCounter = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Select Your Board Size");

        int size = scanner.nextInt();
        String[][] board = new String[size][size];

        System.out.println(Arrays.toString(arrayReturn(size, board)));

        printBoard(size, board);

        while (true) {
            if (turnCounter == 0) {
                System.out.println("Play X For Row");
                int row = scanner.nextInt();
                System.out.println("Play X For column");
                int column = scanner.nextInt();
                gameplay("X", row, column, board, size);
                turnCounter++;

            } else {
                System.out.println("Play O For Row");
                int row = scanner.nextInt();
                System.out.println("Play O For column");
                int column = scanner.nextInt();
                gameplay("O", row, column, board, size);
                turnCounter--;
            }
        }
    }
    public static void gameplay(String symbol, int row, int column, String[][] board, int size) {
        board[row][column] = symbol;
        printBoard(size, board);

        if(winConditionsCheck(size, board)){
            System.out.println("The " + symbol + " Won The TIC-TAC-TOE");
            System.exit(0);
        }

        int tieCounter = 0 ;
        for(int i = 0 ; i < size ; i++){
            for(int x = 0 ; x < size; x++ ){
                if(Objects.equals(board[i][x], "X") || Objects.equals(board[i][x], "O")){
                    tieCounter++;
                }
                if(tieCounter == (size * size)){
                    System.out.println("Game Tie");
                    System.exit(0);
                }
            }
        }
    }

    public static void printBoard(int size, String[][] board) {

        for (int x = 0; x < size; x++) {
            for (int i = 0; i < size; i++) {
                if (board[x][i] == null)
                    board[x][i] = "-";
                System.out.print(board[x][i]);
                if (i < size - 1)
                    System.out.print("|");
            }
            System.out.println();
        }
    }

    public static boolean winConditionsCheck(int size, String[][] board){
        return rowCheck(board, size) || columnCheck(board, size) || rightToLeftDiagonalCheck(size, arrayReturn(size, board)) ||leftToRightDiagonalCheck(size , arrayReturn(size, board));
    }

    public static boolean rowCheck(String[][] board, int size) {
        int winCounter = 1;
        String tempString = " ";
        for (int i = 0; i < size; i++) {
            winCounter = 1;
            for (int x = 0; x < size - 1; x++) {
                tempString = board[i][x];
                int m = x + 1;


                if (tempString.equals("X") && board[i][m].equals("X"))
                    winCounter++;
                if (board[i][x].equals("X") && (board[i][m].equals("O") || board[i][m].equals("-")))
                    winCounter = 1;


                if (tempString.equals("O") && board[i][m].equals("O"))
                    winCounter++;
                if (board[i][x].equals("0") && (board[i][m].equals("X") || board[i][m].equals("-")))
                    winCounter = 1;

                if (winCounter == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean columnCheck(String[][] board, int size) {
        int winCounter = 1;
        String tempString = " ";
        for (int i = 0; i < size; i++) {
            winCounter = 1;
            for (int x = 0; x < size - 1; x++) {
                tempString = board[x][i];
                int m = x + 1;


                if (tempString.equals("X") && board[m][i].equals("X"))
                    winCounter++;
                if (board[x][i].equals("X") && (board[m][i].equals("O") || board[m][i].equals("-")))
                    winCounter = 1;


                if (tempString.equals("O") && board[m][i].equals("O"))
                    winCounter++;
                if (board[x][i].equals("0") && (board[m][i].equals("X") || board[m][i].equals("-")))
                    winCounter = 1;

                if (winCounter == 3) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean rightToLeftDiagonalCheck(int splitSize, String[] array) {
        int WinCounter = 1;
        for (int i = 0; i < array.length; i++) {
            String currentString = array[i];
            int size = (splitSize - 1);
            int counter2 = size;

            for (int x = 0; x < Math.sqrt(array.length); x++) {
                if ((i + counter2) >= array.length)
                    break;

                if (Objects.equals(currentString, array[i + counter2]) && !Objects.equals(currentString, "-")) {
                    counter2 = counter2 + size;
                    WinCounter++;

                    if (WinCounter == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean leftToRightDiagonalCheck(int splitSize, String[] array) {
        int WinCounter = 1;

        for (int i = 0; i < array.length; i++) {

            String currentString = array[i];
            int size = (splitSize + 1);
            int counter2 = size;

            for (int x = 0; x < Math.sqrt(array.length); x++) {
                if ((i + counter2) >= array.length)
                    break;

                if (Objects.equals(currentString, array[i + counter2]) && !Objects.equals(currentString, "-")) {
                    counter2 = counter2 + size;
                    WinCounter++;

                    if (WinCounter == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }



    /*public static boolean diagonalCheck(int size, String[][] board) {
        int winCounter = 1;
        String tempString = " ";

        for (int i = 0; i < size - 1 ; i++) {
            int m = i + 1;
            for (int x = 0; x < size - 1; x++) {
                tempString = board[i][x];

                if (tempString.equals("X") && board[m][m].equals("X"))
                    winCounter++;
                if (board[i][i].equals("X") && (board[m][m].equals("O") || board[m][m].equals("-")))
                    winCounter = 1;

                if (tempString.equals("O") && board[m][m].equals("O"))
                    winCounter++;
                if (board[i][i].equals("O") && (board[m][m].equals("X") || board[m][m].equals("-")))
                    winCounter = 1;


                if (winCounter == 3) {
                    return true;
                }

            }
        }
        return false ;

     */
        public static String [] arrayReturn(int size , String[][] board){

            String[] array = new String[size * size];

            int counter = 0;
            for (int i = 0; i < board.length; i++) {
                for (int x = 0; x < board.length; x++) {
                    array[counter] = board[i][x];
                    counter++;
                }
            }
            return  array ;
        }
    }

