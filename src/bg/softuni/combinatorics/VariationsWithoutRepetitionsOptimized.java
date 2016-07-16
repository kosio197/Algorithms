package bg.softuni.combinatorics;

public class VariationsWithoutRepetitionsOptimized {

    static int n = 4;
    static int k = 3;
    static int arr[] = new int[k];
    static int free[] = new int[] { 1, 2, 3, 4 };

    public static void main(String[] args) {

        variationsNoRepeats(0);
    }

    private static void variationsNoRepeats(int index) {

        if (index >= k) {
            printArr();
        } else {

            for (int i = index; i < n; i++) {

                arr[index] = free[i];
                swap(i, index);
                variationsNoRepeats(index + 1);
                swap(i, index);
            }
        }
    }

    private static void swap(int i, int j) {

        int temp = free[i];
        free[i] = free[j];
        free[j] = temp;
    }

    private static void printArr() {

        System.out.print("{ ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + " }");
        System.out.println();
    }
}
