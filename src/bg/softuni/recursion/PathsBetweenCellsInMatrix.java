package bg.softuni.recursion;

import java.util.ArrayList;
import java.util.List;

public class PathsBetweenCellsInMatrix {

    static String matrix[][] = { { "s ", "0 ", "0 ", "0 " }, { "0 ", "* ", "* ", "0 " }, { "0 ", "* ", "* ", "0 " },
            { "0 ", "* ", "e ", "0 " }, { "0 ", "0 ", "0 ", "0 " } };

    static List<String> result = new ArrayList<String>();
    static int counter;

    private static void printMatrix() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void move(int rol, int coll) {

        matrix[rol][coll] = "t";

        if (validate(rol, coll + 1, "R")) {
            result.add("R");
            matrix[rol][coll + 1] = "t";
            move(rol, coll + 1);
            matrix[rol][coll + 1] = "0";
            result.remove(result.size() - 1);
        }

        if (validate(rol - 1, coll, "U")) {
            result.add("U");
            matrix[rol - 1][coll] = "t";
            move(rol - 1, coll);
            matrix[rol - 1][coll] = "0";
            result.remove(result.size() - 1);
        }

        if (validate(rol, coll - 1, "L")) {
            result.add("L");
            matrix[rol][coll - 1] = "t";
            move(rol, coll - 1);
            matrix[rol][coll - 1] = "0";
            result.remove(result.size() - 1);
        }

        if (validate(rol + 1, coll, "D")) {
            result.add("D");
            matrix[rol + 1][coll] = "t";
            move(rol + 1, coll);
            matrix[rol + 1][coll] = "0";
            result.remove(result.size() - 1);
        }
    }

    private static boolean validate(int rol, int coll, String t) {

        if (!(rol >= 0 && rol < matrix.length && coll >= 0 && coll < matrix[0].length)) {
            return false;
        }

        if (matrix[rol][coll].equals("e ")) {
            result.add(t);
            System.out.println(result);
            counter++;
            result.remove(result.size() - 1);
            return false;
        }

        return (!matrix[rol][coll].equals("* ") && !matrix[rol][coll].equals("t"));
    }

    public static void main(String[] args) {

        printMatrix();
        int rol = 0;
        int coll = 0;

        move(rol, coll);
        System.out.printf("Total paths found: %d", counter);
    }
}
