package bg.softuni.dynamic_programming;

public class LongestIncreasingSubsequence {

    static int[] seq = { 3, 4, 8, 1, 2, 4, 32, 6, 2, 5, 33, 4, 38, 22 };

    public static void main(String[] args) {

        int[] len = new int[seq.length];
        int prev[] = new int[seq.length];

        int maxLen = 0;
        int lastIndex = -1;

        for (int x = 0; x < seq.length; x++) {
            len[x] = 1;
            prev[x] = -1;

            for (int i = 0; i < x; i++)
                if ((seq[i] < seq[x]) && (len[i] + 1 > len[x])) {
                    len[x] = len[i] + 1;
                    prev[x] = i;
                }
            if (len[x] > maxLen) {
                maxLen = len[x];
                lastIndex = x;
            }
        }

        int[] result = restoreLIS(prev, lastIndex);
        printArr(result);
    }

    static int[] restoreLIS(int[] prev, int lastIndex) {

        int[] longestSeq = new int[seq.length];
        int index = 0;

        while (lastIndex != -1) {
            longestSeq[index++] = seq[lastIndex];
            lastIndex = prev[lastIndex];
        }

        int[] result = new int[index--];

        for (int i = 0; i <= index; i++) {
            result[i] = longestSeq[index - i];
        }

        return result;
    }

    private static void printArr(int[] arr) {

        System.out.printf("LIS = %d  { ", arr.length);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + " }");
        System.out.println();
    }
}
