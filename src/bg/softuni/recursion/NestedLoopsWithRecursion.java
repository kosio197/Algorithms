package bg.softuni.recursion;

import java.util.Scanner;

public class NestedLoopsWithRecursion {

    public static void mainB(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(n);

        int input[] = new int[n];
        for (int i = 0; i < input.length; i++) {
            input[i] = i + 1;
            System.out.print(input[i] + ", ");
        }

        int index = 0;
        int startNum = 1;
        int endNum = n;
        generate(input, index, startNum, endNum);
        System.out.println(counter);

        printfigure(n);
        int Facturiel = facturiel(n);
        System.out.println(Facturiel);
        s.close();
    }

    private static int facturiel(int n) {

        int res = 0;
        if (n == 0) {
            return 1;
        } else {

            res = n * facturiel(n - 1);
            System.out.printf("n= {%d} f= {%d}\n ", n, facturiel(n - 1));
        }

        return res;
    }

    private static void printfigure(int n) {

        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();

        printfigure(n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print("#");
        }
        System.out.println();
    }

    static int counter = 0;
    private static void generate(int[] input, int index, int startNum, int endNum) {

        if (index >= input.length) {
            print(input);
        } else {
            for (int i = startNum; i <= endNum; i++) {
                input[index] = i;
                counter++;

                generate(input, index + 1, i, endNum);

            }
        }
    }

    private static void print(int[] input) {

        System.out.println();
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
