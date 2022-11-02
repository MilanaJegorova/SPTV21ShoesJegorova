package entity;

public class Shoes {
    private String name;
    private int price;

    public Shoes(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shoe{" + "name=" + name + ", price=" + price + '}';
    }
}