package bg.softuni.sortandsearching;

public class QuickSort {

    static int arr[] = { 5, 9, 3, 4, 6, 7, 1, 15, 24, 2, 9 };

    public static void main(String[] args) {

        int n = arr.length;
        quicksort(0, n - 1);
        printArr();
    }


    private static void quicksort(int low, int high) {
        int i = low, j = high;

        int pivot = arr[low + (high - low) / 2];

        while (i <= j) {

            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private static void printArr() {

        System.out.print("{ ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + " }");
        System.out.println();
    }

    private static void swap(int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
