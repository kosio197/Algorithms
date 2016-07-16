package bg.softuni.sortandsearching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchIterative {

    static int arr[] = { 0, 5, 9, 3, 4, 6, 7, 1, 15, 24, 2, 9 };

    public static void main(String[] args) {

        int arr[] = { 5, 9, 3, 4, 6, 7, 1, 15, 24, 2, 9 };
        Arrays.sort(arr);
        printArr(arr);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.printf("key %d \nindex = %d", n, BinarySearch(arr, n, 0, arr.length - 1));

        scanner.close();
    }

    static int BinarySearch(int arr[], int key, int start, int end) {
        while (end >= start) {
            int mid = (start + end) / 2;
            if (arr[mid] < key)
                start = mid + 1;
            else if (arr[mid] > key)
                end = mid - 1;
            else
                return mid;
        }
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
