package bg.softuni.dynamic_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetSumWithRepeats {

    public static void main(String[] args) {

        int[] arr = { 3, 5, -1, 10, 5, 7 };

        Scanner scan = new Scanner(System.in);
        int targetSum = scan.nextInt();

        boolean[] possible = calcPossibleSums(arr, targetSum);
        for (int i = 0; i < possible.length; i++) {
            System.out.print(possible[i] + " ");
        }

        List<Integer> subsetOfSum = findSubset(arr, possible, targetSum);
        System.out.print("\n" + targetSum + " = ");
        for (int i = 0; i < subsetOfSum.size() - 1; i++) {
            System.out.print(subsetOfSum.get(i) + " + ");
        }
        System.out.print(subsetOfSum.get(subsetOfSum.size() - 1));

        scan.close();
    }




    private static List<Integer> findSubset(int[] arr, boolean[] possible, int targetSum) {

        List<Integer> result = new ArrayList<>();

        while (targetSum > 0) {

            for (int i = 0; i < arr.length; i++) {

                int sum = targetSum - arr[i];
                if (sum >= 0 && possible[sum]) {

                    result.add(arr[i]);
                    targetSum = sum;
                }
            }
        }

        return result;
    }


    static boolean[] calcPossibleSums(int[] arr, int targetSum) {

        boolean[] possible = new boolean[targetSum + 1];
        possible[0] = true;

        for (int sum = 0; sum < possible.length; sum++)
            if (possible[sum]) {
                for (int i = 0; i < arr.length; i++) {
                    int newSum = sum + arr[i];
                    if (newSum >= 0 && newSum <= targetSum)
                        possible[newSum] = true;
                }
            }
        return possible;
    }
}
