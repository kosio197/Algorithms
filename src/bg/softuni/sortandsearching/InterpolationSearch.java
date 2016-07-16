package bg.softuni.sortandsearching;

import java.util.Arrays;
import java.util.Scanner;

public class InterpolationSearch {

    static int arr[] = { 0, 5, 9, 3, 4, 6, 7, 1, 15, 24, 2, 9 };

    public static void main(String[] args) {

        int arr[] = { 5, 9, 3, 4, 6, 7, 1, 15, 24, 2, 9 };
        Arrays.sort(arr);
        printArr(arr);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = Interpolation_Search(arr, n);
        System.out.printf("key %d \nindex = %d", n, result);

        scanner.close();
    }

    static int Interpolation_Search(int[] sortedArray, int key) {
        int low = 0;
        int high = sortedArray.length - 1;
        while (sortedArray[low] <= key && sortedArray[high] >= key) {
            int mid = low + ((key - sortedArray[low]) * (high - low)) / (sortedArray[high] - sortedArray[low]);
            if (sortedArray[mid] < key)
                low = mid + 1;
            else if (sortedArray[mid] > key)
                high = mid - 1;
            else
                return mid;
        }
        if (sortedArray[low] == key)
            return low;
        else
            return 0;
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
