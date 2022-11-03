package manager;

import entity.Shoes;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoesManager {
    
    private ArrayList<Shoes> shoes;
    private int net;
    private Scanner sc;
    
    public ShoesManager() {
        shoes = new ArrayList<>();
        sc = new Scanner(System.in);
        net = 0;
    }
    
    public void addProduct() {
        sc.nextLine();
        System.out.print("Введите название товара: ");
        String name =  sc.nextLine();
        System.out.print("Введите цену товара: ");
        int price = sc.nextInt();
        shoes.add(new Shoes(name, price));
    }
    
    public void listProducts() {
        int j = 0;
        for (Shoes i : shoes) {
            System.out.println("- [" + j + "] - " + i.getName() + " (" + i.getPrice() + ")");
            j++;
        }
    }  
    
    public void deleteProduct(int index) {
        shoes.remove(index);
    }

    public ArrayList<Shoes> getShoes() {
        return shoes;
    }

    public void setShoes(ArrayList<Shoes> shoes) {
        this.shoes = shoes;
    }

    public int getNet() {
        return net;
    }

    public void setNet(int net) {
        this.net = net;
    }
    
    
}
