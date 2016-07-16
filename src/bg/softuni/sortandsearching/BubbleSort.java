package bg.softuni.sortandsearching;

public class BubbleSort {

    static int arr[] = { 5, 9, 3, 4, 6, 7, 1 };

    public static void main(String[] args) {

        int n = arr.length;
        boolean swapped = false;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    Swap(i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);

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

    private static void Swap(int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
