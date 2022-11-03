package manager;

import entity.Customer;
import entity.Shoes;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManager {
    
    private ArrayList<Customer> customers;
    private Scanner sc;
    
    public CustomerManager() {
        customers = new ArrayList<>();
        sc = new Scanner(System.in);
    }
    
    public void addCustomer() {
        sc.nextLine();
        System.out.print("Введите имя покупателя: ");
        String name =  sc.nextLine();
        System.out.print("Введите фамилию покупателя: ");
        String surname = sc.nextLine();
        System.out.print("Введите деньги покупателя: ");
        int money = sc.nextInt();
        customers.add(new Customer(name, surname, money));
    }
    
    public void listCustomers() {
        int j = 0;
        for (Customer i : customers) {
            System.out.println("- [" + j + "] - " + i.getName() + " " + i.getSurname() + "(" + i.getMoney() + ")");
            j++;
        }
    }  
    
    public void addMoney(int index, int money) {
        customers.get(index).setMoney(customers.get(index).getMoney() + money);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
    
    
    
    
    
}
