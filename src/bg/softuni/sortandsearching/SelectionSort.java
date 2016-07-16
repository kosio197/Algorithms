package bg.softuni.sortandsearching;

public class SelectionSort {

    static int arr[] = { 5, 9, 3, 4, 6, 7, 1 };

    public static void main(String[] args) {

        int n = arr.length;

        for (int left = 0; left < n - 1; left++) {
            int minIndex = left;
            for (int i = left + 1; i < n; i++) {

                if (arr[i] < arr[minIndex])
                    minIndex = i;
            }

            if (minIndex != left)
                Swap(left, minIndex);
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

    private static void Swap(int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
