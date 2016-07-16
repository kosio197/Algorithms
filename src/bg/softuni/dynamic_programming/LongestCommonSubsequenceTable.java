package bg.softuni.dynamic_programming;

import java.util.Scanner;

public class LongestCommonSubsequenceTable {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();

        String lcs = findLCS(str1, str2);
        System.out.print("Longest Common Subsequence = ");
        for (int i = lcs.length() - 1; i >= 0; i--) {
            System.out.print(lcs.charAt(i) + " ");
        }

        scan.close();
    }

    private static String findLCS(String str1, String str2) {

        int [][] matrix = new int [str1.length() +1][str2.length() +1];

        for (int first = 1; first <= str1.length(); first++) {
            for (int sec = 1; sec <= str2.length(); sec++) {

                if (str1.charAt(first - 1) == str2.charAt(sec - 1)) {
                    matrix[first][sec] = matrix[first - 1][sec - 1] + 1;
                } else {

                    matrix[first][sec] = Math.max(matrix[first - 1][sec], matrix[first][sec - 1]);
                }
            }
        }

        //Reconstructing the LCS Sequence
        StringBuilder result = new StringBuilder();
        int x = matrix.length - 1;
        int y = matrix[0].length - 1;

        System.out.println();
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        while (x > 0 && y > 0)
            if ((str1.charAt(x - 1) == str2.charAt(y - 1)) && (matrix[x - 1][y - 1] + 1 == matrix[x][y])) {

                result.append(str1.charAt(x - 1));
                x--;
                y--;

            } else if (matrix[x - 1][y] == matrix[x][y]) {
                x--;
            }else
                y--;

        return result.toString();
    }
}
