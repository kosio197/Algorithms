package bg.softuni.sortandsearching;

public class InsertionSort {

    static int arr[] = { 5, 9, 3, 4, 6, 7, 1, 15, 24, 2, 9 };

    public static void main(String[] args) {
        /*
         * for firstUnsortedIndex = 1 to length(arr) – 1 { i =
         * firstUnsortedIndex while (i > 0 && arr[i-1] > arr[i]) { Swap(arr[i],
         * arr[i-1]) i-- } }
         */
        int n = arr.length;

        for (int j = 1; j < n; j++) {
            int i = j;
            while (i > 0 && arr[i - 1] > arr[i]) {
                swap(i, i - 1);
                i--;
            }
        }

        printArr();
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
