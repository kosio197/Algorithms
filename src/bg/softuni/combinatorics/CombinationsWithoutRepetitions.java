package bg.softuni.combinatorics;

public class CombinationsWithoutRepetitions {

    static int k = 2;
    static int n = 3;
    static int arr[] = new int[k];

    public static void main(String[] args) {

        combinationsWithoutRepetition(0, 0);
    }

    private static void combinationsWithoutRepetition(int index, int start) {

        if (index >= k) {
            printArr();
        } else {

            for (int i = start; i < n; i++) {
                arr[index] = i;
                combinationsWithoutRepetition(index + 1, i + 1);
            }
        }

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
