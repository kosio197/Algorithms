package bg.softuni.dynamic_programming;

public class Item {

    private int Weight;

    private int Price;


    public Item(int weight, int price) {
        this.Weight = weight;
        this.Price = price;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
