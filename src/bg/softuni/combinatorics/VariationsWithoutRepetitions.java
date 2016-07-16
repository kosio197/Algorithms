package bg.softuni.combinatorics;

public class VariationsWithoutRepetitions {

    static int n = 4;
    static int k = 2;
    static int arr[] = new int[k];
    static boolean used[] = new boolean[n];

    public static void main(String[] args) {

        generatingVariationsWithoutRepetition(0);
    }

    private static void generatingVariationsWithoutRepetition(int index) {

        if (index > arr.length - 1) {
            printArr();
        } else {

            for (int i = 0; i < n; i++) {
                if (!used[i]) {

                    used[i] = true;
                    arr[index] = i;
                    generatingVariationsWithoutRepetition(index + 1);
                    used[i] = false;
                }
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
