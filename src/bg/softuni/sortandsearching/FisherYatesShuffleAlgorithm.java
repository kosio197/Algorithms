package bg.softuni.sortandsearching;

import java.util.Arrays;
import java.util.Random;

public class FisherYatesShuffleAlgorithm {

    static int arr[] = { 0, 5, 9, 3, 4, 6, 7, 1, 15, 24, 2, 9 };

    public static void main(String[] args) {

        int arr[] = { 5, 9, 3, 4, 6, 7, 1, 15, 24, 2, 9 };
        Arrays.sort(arr);
        printArr(arr);

        int[] result = Shuffle(arr);
        printArr(result);
    }

    public static int[] Shuffle(int[] result) {
        Random rnd = new Random();
        int[] array = result;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            // Exchange array[i] with random element in array[i … n-1]
            int r = i + rnd.nextInt(n - i);
            int temp = array[i];
            array[i] = array[r];
            array[r] = temp;
        }
        return array;
    }

    private static void printArr(int[] arr) {

        System.out.print("{ ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + " }");
        System.out.println();
    }
}
