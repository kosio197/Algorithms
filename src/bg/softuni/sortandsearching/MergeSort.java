package bg.softuni.sortandsearching;

public class MergeSort {

    static int arr[] = { 5, 9, 3, 4, 6, 7, 1, 15, 24, 2, 9 };

    public static void main(String[] args) {

        int arr[] = { 5, 9, 3, 4, 6, 7, 1, 15, 24, 2, 9 };
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    private static void mergeSort(int[] arr, int start, int end) {

        if (start == end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        int left = start, right = mid + 1, result = 0;
        int temp[] = new int[end - start + 1];

        while (left <= mid && right <= end) {

            if (arr[left] < arr[right]) {
                temp[result] = arr[left];
                left++;
            } else {
                temp[result] = arr[right];
                right++;
            }
            result++;
        }

        while (left <= mid) {

            temp[result++] = arr[left++];
        }

        while (right <= end) {

            temp[result++] = arr[right++];
        }

        int index = 0;
        for (int i = start; i <= end; i++) {
            arr[i] = temp[index++];
        }
    }

    private static void printArr(int[] arr) {

        System.out.print("{ ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + " }");
        System.out.println();
    }
}
