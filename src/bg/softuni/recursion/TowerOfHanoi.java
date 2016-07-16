package bg.softuni.recursion;

import java.util.Stack;

public class TowerOfHanoi {

    static int disckNumber = 7;


    public static void main(String[] args) {

        Stack<Integer> keg1 = new Stack<>();
        Stack<Integer> keg2 = new Stack<>();
        Stack<Integer> keg3 = new Stack<>();

        System.out.println("load keg_1");
        for (int i = disckNumber; i > 0; i--) {
            keg1.push(i);
            System.out.print(i + " ");
        }

        String name = "keg_3";
        moveDisk(disckNumber, keg1, keg3, keg2);
        printStack(name, keg3);

    }

    private static void moveDisk(int disck, Stack<Integer> keg1, Stack<Integer> keg3, Stack<Integer> keg2) {

        if (disck < 1) {
            return;
        }

        moveDisk(disck - 1, keg1, keg2, keg3);

        keg3.push(disck);
        keg1.pop();

        moveDisk(disck - 1, keg2, keg3, keg1);

    }

    private static void printStack(String name, Stack<Integer> stack) {

        System.out.println("\n" + name);
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
