package bg.softuni.combinatorics;

public class Permutations {

    static int arr[] = { 1, 2, 3, 4 };

    public static void main(String[] args) {

        generatingPermutations(0);
    }

    private static void generatingPermutations(int index) {

        if (index >= arr.length) {
            printArr();
        } else {

            generatingPermutations(index + 1);
            for (int i = index + 1; i < arr.length; i++) {

                swap(index, i);
                generatingPermutations(index + 1);
                swap(index, i);
            }
        }
    }

    private static void swap(int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
