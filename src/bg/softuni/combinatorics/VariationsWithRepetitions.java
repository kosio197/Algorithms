package bg.softuni.combinatorics;

public class VariationsWithRepetitions {

    static int n = 4;
    static int k = 2;
    static int arr[] = new int[k];

    public static void main(String[] args) {

        generateVariations(0);
    }

    private static void generateVariations(int index) {

        if (index >= arr.length) {
            printArr();
        } else {

            for (int i = 0; i <= n; i++) {
                arr[index] = i;
                generateVariations(index + 1);
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
