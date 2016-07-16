package bg.softuni.combinatorics;

public class BinomialCoefficientsFastCalculation {

    static int MAX = 100;
    static long binomCoeff[][] = new long[MAX][MAX];

    static long Binom(int n, int k) {
        if (k > n)
            return 0;
        if (k == 0 || k == n)
            return 1;
        if (binomCoeff[n][k] == 0)
            binomCoeff[n][k] = Binom(n - 1, k - 1) + Binom(n - 1, k);
        return binomCoeff[n][k];
    }

    public static void main(String[] args) {

        System.out.println(Binom(80, 60));
    }

}
