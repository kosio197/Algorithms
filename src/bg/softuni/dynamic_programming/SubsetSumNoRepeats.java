package bg.softuni.dynamic_programming;

import java.util.HashSet;

public class SubsetSumNoRepeats {


    public static void main(String[] args) {

        int[] arr = { 3, 5, 2 };

        HashSet<Integer> result = CalcPossibleSumsSet(arr);
        System.out.println(String.join(" ", result.toString()));
    }

    private static HashSet<Integer> CalcPossibleSumsSet(int[] arr) {

        HashSet<Integer> result = new HashSet<>();
        result.add(0);

        for (int i = 0; i < arr.length; i++) {

            HashSet<Integer> newSums = new HashSet<>();
            for (Integer num : result) {
                int newSum=num+arr[i];
                newSums.add(newSum);
            }

            for (Integer sum : newSums) {
                if (!result.contains(sum)) {
                    result.add(sum);
                }
            }
        }


        return result;
    }
}
