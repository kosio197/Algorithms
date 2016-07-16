package bg.softuni.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class MatrixMoveDownRightSum {

    static int[][] matrix = { { 2, 6, 1, 8, 9, 4, 2 }, { 1, 8, 0, 3, 5, 6, 7 }, { 3, 4, 8, 7, 2, 1, 8 },
            { 0, 9, 2, 8, 1, 7, 9 }, { 2, 7, 1, 9, 7, 8, 2 }, { 4, 5, 6, 1, 2, 5, 6 }, { 9, 3, 5, 2, 8, 1, 9 },
            { 2, 3, 4, 1, 7, 2, 8 } };

    public static void main(String[] args) {

        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[][] sum = new int[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                sum[i][j] = matrix[i][j];
            }
        }

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                long maxPrevCell = Long.MIN_VALUE;

                if (col > 0 && sum[row][col - 1] > maxPrevCell)

                    maxPrevCell = sum[row][col - 1];

                if (row > 0 && sum[row - 1][col] > maxPrevCell)

                    maxPrevCell = sum[row - 1][col];
                // sum[row][col] = cells[row][col];

                if (maxPrevCell != Long.MIN_VALUE)
                    sum[row][col] += maxPrevCell;
            }
        }
        printArr(sum);
    }

    private static void printArr(int[][] sum) {

        List<Tuple<Integer, Integer>> path = restorePath(sum);

        for (int i = path.size() - 1; i >= 0; i--) {
            Tuple<Integer, Integer> tuple = path.get(i);
            System.out.printf("%d ", matrix[tuple.x][tuple.y]);
        }
        System.out.println("\n");

        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[0].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.print("  ");
            for (int j = 0; j < sum[0].length; j++) {
                System.out.printf("%d ", sum[i][j]);
            }
            System.out.println();
        }
    }

    private static List<Tuple<Integer, Integer>> restorePath(int[][] sum) {

        List<Tuple<Integer, Integer>> path = new ArrayList<Tuple<Integer, Integer>>();
        int r = sum.length - 1;
        int c = sum[0].length - 1;
        path.add(new Tuple<Integer, Integer>(r, c));

        while (r > 0 && c > 0) {

            if (sum[r - 1][c] > sum[r][c - 1]) {
                path.add(new Tuple<Integer, Integer>(r - 1, c));
                r--;
            } else {
                path.add(new Tuple<Integer, Integer>(r, c - 1));
                c--;
            }
        }

        while (r > 0) {
            path.add(new Tuple<Integer, Integer>(r - 1, c));
            r--;
        }

        while (c > 0) {
            path.add(new Tuple<Integer, Integer>(r, c - 1));
            c--;
        }

        return path;
    }
}
