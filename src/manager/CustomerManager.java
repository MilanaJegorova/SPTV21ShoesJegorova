package manager;

import entity.Customer;
import entity.Shoes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManager {
    
    private List<Customer> customers;
    private Scanner sc;
    private Statement stmt;
    
    public CustomerManager(Statement stmt) throws SQLException {
        this.stmt = stmt;
        this.customers = this.getCustomers();
        this.sc = new Scanner(System.in);
    }
    
    public void addCustomer() throws SQLException{
        sc.nextLine();
        System.out.print("Введите имя покупателя: ");
        String name =  sc.nextLine();
        System.out.print("Введите фамилию покупателя: ");
        String surname = sc.nextLine();
        System.out.print("Введите деньги покупателя: ");
        int money = sc.nextInt();
        String sql = "INSERT INTO customers (name, surname, money) VALUES ('" + name + "', '" + surname + "', " + money + ")";
        stmt.executeUpdate(sql);
        this.customers = this.getCustomers();
    }
    
    public void listCustomers() {
        for (Customer i : this.customers) {
            System.out.println("- [" + i.getId() + "] - " + i.getName() + " " + i.getSurname() + "(" + i.getMoney() + ")");
        }
    }  
    
    public void addMoney(int index, int money) {
        customers.get(index).setMoney(customers.get(index).getMoney() + money);
    }

    public List<Customer> getCustomers() throws SQLException {
        ResultSet rs;
        List<Customer> customers = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT * FROM customers");
        } catch (Exception e) {
            stmt.executeUpdate("CREATE TABLE customers (id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT, name VARCHAR(255), surname VARCHAR(255), money INT)");
            rs = stmt.executeQuery("SELECT * FROM customers");
        }
        while (rs.next()) {
            customers.add(new Customer(rs.getString("name"), rs.getString("surname"), Integer.parseInt(rs.getString("money")), rs.getLong("id")));
        }
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
    
    
    
    
    
}
