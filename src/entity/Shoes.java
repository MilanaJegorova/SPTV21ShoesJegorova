package entity;

public class Shoes {
    private String name;
    private int price;
    private long id;

    public Shoes(String name, int price, long id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public Shoes() {
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Shoe{" + "name=" + name + ", price=" + price + '}';
    }
    
}