package bg.softuni.dynamic_programming;

import java.util.ArrayList;

public class KnapsackProblem {

    public static void main(String[] args) {

        Item items[] = {
                new Item(5,30),
                new Item(8,120),
                new Item(7,10),
                new Item (0,20),
                new Item (4,50),
                new Item (5,80),
 new Item(2, 10), new Item(3, 200)
        };

        int knapsackCapacity = 20;

        ArrayList<Item> itemsTaken = FillKnapsack(items, knapsackCapacity);

        System.out.printf("Knapsack weight capacity: %d\n", knapsackCapacity);

        int WeightSum = 0 , PriceSum=0;
        System.out.printf("Take the following items in the knapsack:\n");
        for (Item item : itemsTaken)
        {
            if (item != null) {
                System.out.printf("  (weight: %d, price: %d\n)", item.getWeight(), item.getPrice());
                WeightSum += item.getWeight();
                PriceSum += item.getPrice();
            }
        }

        System.out.printf("Total weight: %d\n", WeightSum);
        System.out.printf("Total price: %d\n", PriceSum);
    }

    public static ArrayList<Item> FillKnapsack(Item[] items, int capacity)
    {
        ArrayList<Item> result = new ArrayList<>();
        int maxPrice[][] = new int[items.length][capacity + 1];
        boolean isTaken[][] = new boolean[items.length][capacity + 1];

        for (int c = 0; c < capacity + 1; c++) {
            isTaken[0][c] = false;
            if (items[0].getWeight() <= c) {
                maxPrice[0][c] = items[0].getPrice();
                isTaken[0][c] = true;
            }
        }

        for (int i = 1; i < items.length; i++) {
            for (int c = 0; c < capacity + 1; c++) {

                maxPrice[i][c] = maxPrice[i - 1][c];
                isTaken[i][c] = false;
                int remainingCapacity = c - items[i].getWeight();
                if (remainingCapacity >= 0
                        && (items[i].getPrice() + maxPrice[i - 1][remainingCapacity]) > maxPrice[i - 1][c]) {

                    maxPrice[i][c] = items[i].getPrice() + maxPrice[i - 1][remainingCapacity];
                    isTaken[i][c] = true;
                }
            }
        }

        int index = items.length - 1;

        while (index >= 0) {
            if (isTaken[index][capacity]) {
                result.add(items[index]);
                capacity -= items[index].getWeight();
            }
            index--;
        }
        return result;
    }
}
