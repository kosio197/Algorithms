package bg.softuni.combinatorics;

public class VariationsWithRepetitionIterative {

    public static void main(String[] args) {

        int n = 3;
        int k = 3;
        int arr[] = new int[k];

        while (true) {

            printArr(arr);

            int index = k - 1;
            while (index >= 0 && arr[index] == n) {

                index--;
            }

            if (index < 0) {
                break;
            }
            arr[index]++;

            for (int i = index + 1; i < k; i++) {
                arr[i] = 0;
            }

        }
    }

    private static void printArr(int arr[]) {

        System.out.print("{ ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + " }");
        System.out.println();
    }
}
