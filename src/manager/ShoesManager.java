package manager;

import entity.Shoes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoesManager {
    
    private List<Shoes> shoes;
    private int net;
    private Scanner sc;
    private Statement stmt;
    
    public ShoesManager(Statement stmt) throws SQLException{
        this.stmt = stmt;
        this.shoes = this.getShoes();
        this.sc = new Scanner(System.in);
        this.net = this.getNet();
    }
    
    public void addProduct() throws SQLException{
        sc.nextLine();
        System.out.print("Введите название товара: ");
        String name =  sc.nextLine();
        System.out.print("Введите цену товара: ");
        int price = sc.nextInt();
        String sql = "INSERT INTO shoes (name, price) VALUES ('" + name + "', " + price + ")";
        stmt.executeUpdate(sql);
        this.shoes = this.getShoes();
    }
    
    public void sale(int price) throws SQLException{
        String sql = "INSERT INTO sales (price) VALUES ("+ price + ")";
        stmt.executeUpdate(sql);
    }
   
    public Shoes getShoeById(int id) throws SQLException {
        ResultSet rs;
        Shoes shoe = new Shoes();
        try {
            rs = stmt.executeQuery("SELECT * FROM shoes WHERE id = " + id);
        } catch (Exception e) {
            return null;
        }     
        while (rs.next()) {
            shoe = new Shoes(rs.getString("name"), Integer.parseInt(rs.getString("price")));
        }
        return shoe;
    } 
    
    public void listProducts() {
        for (Shoes i : this.shoes) {
            System.out.println("- [" + i.getId() + "] - " + i.getName() + " (" + i.getPrice() + ")");
        }
    }  
    
    public void deleteProduct(int index) throws SQLException{
       stmt.executeUpdate("DELETE FROM shoes WHERE id = " + index);
       this.shoes = this.getShoes();
    }

    public List<Shoes> getShoes() throws SQLException {
        ResultSet rs;
        List<Shoes> shoes = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT * FROM shoes");
        } catch (Exception e) {
            stmt.executeUpdate("CREATE TABLE shoes (id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT, name VARCHAR(255), price INT)");
            rs = stmt.executeQuery("SELECT * FROM shoes");
        }
        while (rs.next()) {
            shoes.add(new Shoes(rs.getString("name"), Integer.parseInt(rs.getString("price")), rs.getLong("id")));
        }
        return shoes;
    }

    public void setShoes(ArrayList<Shoes> shoes) {
        this.shoes = shoes;
    }

    public int getNet() throws SQLException {
        ResultSet rs;
        List<Integer> sales = new ArrayList<>();
        int net = 0;
        try {
            rs = stmt.executeQuery("SELECT * FROM sales");
        } catch (Exception e) {
            stmt.executeUpdate("CREATE TABLE sales (price INT)");
            rs = stmt.executeQuery("SELECT * FROM sales");
        }
        while (rs.next()) {
            net += Integer.parseInt(rs.getString("price"));
        }
        return net;
    }

    public void setNet(int net) {
        this.net = net;
    }
    
    
}
