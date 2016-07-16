package bg.softuni.dynamic_programming;

public class BinomialCoefficients {

    public static void main(String[] args) {

        int n = 10;
        int k = 5;

        int oddRow[] = new int[n + 1];
        oddRow[0] = 1;
        int evenRow[] = new int[n + 1];
        evenRow[0] = 1;
        evenRow[1] = 1;

        for (int i = 2; i < evenRow.length; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j <= i; j++) {
                    oddRow[j] = evenRow[j - 1] + evenRow[j];
                }
            } else {
                for (int j = 1; j < evenRow.length; j++) {
                    evenRow[j] = oddRow[j - 1] + oddRow[j];
                }
            }
        }

        System.out.println(n % 2 == 0 ? oddRow[k] : evenRow[k]);
    }
}
