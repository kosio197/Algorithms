package bg.softuni.combinatorics;

import java.util.Arrays;

public class PermutationsWithRepetitions {

    static int arr[] = { 3, 5, 1, 5, 5, 3, 5, 1, 5, 5 };

    private static void printArr() {

        System.out.print("{ ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + " }");
        System.out.println(counter);
    }

    private static void swap(int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Arrays.sort(arr);
        generatingPermutationsWithRepetition(0, arr.length - 1);
    }

    private static int counter = 0;
    private static void generatingPermutationsWithRepetition(int startIndex, int endIndex) {

        printArr();
        counter++;
        for (int leftIndex = endIndex - 1; leftIndex >= startIndex; leftIndex--) {
            for (int rightIndex = leftIndex + 1; rightIndex <= endIndex; rightIndex++) {

                if (arr[leftIndex] != arr[rightIndex]) {

                    swap(leftIndex, rightIndex);
                    generatingPermutationsWithRepetition(leftIndex + 1, endIndex);
                }

                int firstIndex = arr[leftIndex];
                for (int i = leftIndex; i <= endIndex - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[endIndex] = firstIndex;
            }

        }
    }
}
