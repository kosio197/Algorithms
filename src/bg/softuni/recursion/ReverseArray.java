package bg.softuni.recursion;

public class ReverseArray {

    public static void mainA(String[] args) {

        int input[] = { 1, 2, 3, 4, 5, 6, };
        int result[] = new int[6];
        int index = input.length;
        print(input, index - 1, result);
        System.out.println();
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }

    private static void print(int[] input, int index, int[] result) {

        if (index == -1) {
            return;
        }
        System.out.print(input[index]);
        print(input, index - 1, result);
        result[5 - index] = input[index];
    }
}
