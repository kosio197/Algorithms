package bg.softuni.recursion;

import java.util.HashMap;

public class ConnectedAreasInMatrix {

    // Total areas found: 3
    // Area #1 at (0, 0), size: 13

    private static void printResult() {
        int size = result.size();
        System.out.printf("Total areas found: %d\n", size);
        for (int i = 0; i < size; i++) {
            System.out.printf("Area #%d at (%d, %d), size: %d\n", arrayNumber, arrayRol, arrayColl, arraySize);
        }
    }

    static String matrix[][] = { { "1", " ", " ", "*", "2", " ", " ", "*", "3" },
            { " ", " ", " ", "*", " ", " ", " ", "*", " " }, { " ", " ", " ", "*", " ", " ", " ", "*", " " },
            { " ", " ", " ", " ", "*", " ", "*", " ", " " } };
    static int resultCounter = 0;
    static HashMap<Integer, int[]> result = new HashMap<>();

    private static void traceMatrix(int rol, int coll) {

        for (int i = 0; i < matrix[0].length; i++) {
            if (validateMatrix(rol, coll + i)) {

                traceArray(rol, coll + i);
            }
        }

        for (int i = matrix[0].length - 1; i > 0; i--) {
            if (validateMatrix(rol, coll - i)) {

                traceArray(rol, coll - i);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (validateMatrix(rol + i, coll)) {

                traceArray(rol + i, coll);
            }
        }

        for (int i = matrix.length - 1; i > 0; i--) {
            if (validateMatrix(rol - i, coll)) {

                traceArray(rol - i, coll);
            }
        }

        printResult();
    }


    static int arrayNumber = 0;
    static int arrayRol = 0;
    static int arrayColl = 0;
    static int arraySize = 0;

    private static void traceArray(int rol, int coll) {

        if (validateArray(rol, coll)) {
            if (!matrix[rol][coll].equals(" ") && !matrix[rol][coll].equals("t")) {
                arrayNumber = Integer.valueOf(matrix[rol][coll]);
                arrayRol = rol;
                arrayColl = coll;
                arraySize++;
            }
        }

        matrix[rol][coll] = "t";

        if (validateArray(rol, coll + 1)) {

            arraySize++;
            matrix[rol][coll + 1] = "t";
            traceArray(rol, coll + 1);
            matrix[rol][coll + 1] = " ";
        }

        if (validateArray(rol + 1, coll)) {

            arraySize++;
            matrix[rol + 1][coll] = "t";
            traceArray(rol + 1, coll);
            matrix[rol + 1][coll] = "t";
        }

        if (validateArray(rol - 1, coll)) {

            arraySize++;
            matrix[rol - 1][coll] = "t";
            traceArray(rol - 1, coll);
            matrix[rol - 1][coll] = " ";
        }

        if (validateArray(rol, coll - 1)) {

            arraySize++;
            matrix[rol][coll - 1] = "t";
            traceArray(rol, coll - 1);
            matrix[rol][coll - 1] = " ";
        }


        arraySize++;
        int resultArray[] = { arrayNumber, arrayRol, arrayColl, arraySize };
        result.put(arrayNumber, resultArray);
        arraySize = 0;
        traceMatrix(rol, coll);
    }

    private static boolean validateMatrix(int rol, int coll) {

        return (rol >= 0 && rol < matrix.length && coll >= 0 && coll < matrix.length && !matrix[rol][coll].equals("*")
                && !matrix[rol][coll].equals("t"));
    }


    private static boolean validateArray(int rol, int coll) {

        return (rol >= 0 && rol < matrix.length && coll >= 0 && coll < matrix.length && !matrix[rol][coll].equals("*")
                && !matrix[rol][coll].equals("t"));
    }
    private static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        printMatrix();
        int rol = 0;
        int coll = 0;
        traceMatrix(rol, coll);

    }

}
