import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Experiment{
    public static void main(String[] args) {
        String[][] array2D = {
                {"O", "", "",""},                       // row 1
                {"", "O", "",""},                        // row2
                {"", "", "O",""},
                {"", "", "",""},
        };                          // row3

        String[] array = new String[array2D.length * array2D.length];

        int counter = 0;
        for (int i = 0; i < array2D.length; i++) {
            for (int x = 0; x < array2D.length; x++) {
                array[counter] = array2D[i][x];
                counter++;
            }
        }

        System.out.println(Arrays.toString(array));

        int splitSize = (int) (array.length / Math.sqrt(array.length));
        if (diagonalCheck2(splitSize, array) || diagonalCheck(splitSize , array))
            System.out.println("WON");
        else
            System.out.println("?");
        /*for (int i = 0; i < array.length; i = i + splitSize) {
            String[] splitArray = Arrays.copyOfRange(array, i, i + splitSize);
            String currentString = splitArray[0];
            int winCounter = 1;

            for (int y = 0; y < splitArray.length - 1; y++) {
                if (!Objects.equals(currentString, splitArray[y + 1])) {
                    currentString = splitArray[y + 1];
                    winCounter = 1;

                } else {
                    winCounter++;
                }

                if (winCounter == 3) {
                    System.out.println("YOU WON " + currentString);
                    break;
                }
            }
        }

         */

    }



    public static boolean diagonalCheck(int splitSize, String[] array) {
        int WinCounter = 1;

        for (int i = 0; i < array.length; i++) {

            String currentString = array[i];
            int size = (splitSize + 1);
            int counter2 = size;

            for (int x = 0; x < Math.sqrt(array.length); x++) {
                if ((i + counter2) >= array.length)
                    break;

                if (Objects.equals(currentString, array[i + counter2]) && !Objects.equals(currentString, "")) {
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
    public static boolean diagonalCheck2(int splitSize, String[] array) {
        int WinCounter = 1;
        for (int i = 0; i < array.length; i++) {
            String currentString = array[i];
            int size = (splitSize - 1);
            int counter2 = size;

            for (int x = 0; x < Math.sqrt(array.length); x++) {
                if ((i + counter2) >= array.length)
                    break;

                if (Objects.equals(currentString, array[i + counter2]) && !Objects.equals(currentString, "")) {
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
}
