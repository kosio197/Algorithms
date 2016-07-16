package bg.softuni.dynamic_programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;

public class SubsetSumNoRepeatsRecovery {

    public static void main(String[] args) {

        int[] arr = { 3, 5, 1, 4, 2 };

        HashMap<Integer, Integer> result = CalcPossibleSumsSet(arr);
        for (Entry<Integer, Integer> num : result.entrySet()) {
            System.out.printf("%d ", num.getKey());
        }

        Scanner scan = new Scanner(System.in);
        int targetSum = scan.nextInt();

        HashSet<Integer> subsetOfSum = findSubset(arr, result, targetSum);
        System.out.println(String.join(" + ", subsetOfSum.toString()));

        scan.close();
    }

    private static HashSet<Integer> findSubset(int[] arr, HashMap<Integer, Integer> result, int targetSum) {

        HashSet<Integer> subset = new HashSet<>();

        while (targetSum > 0) {
            int lastSum = 0;
            for (Entry<Integer, Integer> getKey : result.entrySet()) {
                if (getKey.getKey() == targetSum) {
                    lastSum = result.get(targetSum);
                }
            }
            subset.add(lastSum);
            targetSum -= result.get(targetSum);
        }

        return subset;
    }

    private static HashMap<Integer, Integer> CalcPossibleSumsSet(int[] arr) {

        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        result.put(0, 0);

        for (int i = 0; i < arr.length; i++) {

            HashSet<Integer> newSums = new HashSet<>();
            for (Entry<Integer, Integer> num : result.entrySet()) {
                int newSum = num.getKey() + arr[i];
                newSums.add(newSum);
            }

            for (Integer sum : newSums) {
                if (!result.containsKey(sum)) {
                    result.put(sum, arr[i]);
                }
            }
        }

        return result;
    }
}
