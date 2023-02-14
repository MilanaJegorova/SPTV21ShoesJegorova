package sptv21shoesjegorova;

import entity.Customer;
import entity.Shoes;
import java.util.Scanner;
import manager.CustomerManager;
import manager.ShoesManager;
import java.sql.*;
import java.util.List;

class App {
    
    public void run()throws SQLException {

        Connection conn = connectToDB();
     
        Statement stmt = conn.createStatement();
        ResultSet rs;
    
        boolean repeat = true;
    
        CustomerManager customerManager = new CustomerManager(stmt);
        ShoesManager shoesManager = new ShoesManager(stmt);
        
        int number;
        int index;
        int index2;
        int shoePrice;
        int money;
    
        Scanner scan = new Scanner(System.in);

        do{

            System.out.println("Функции: ");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить продукт");
            System.out.println("2. Список продоваемых продуктов");
            System.out.println("3. Добавить покупателя");
            System.out.println("4. Список зарегистрированных покупателей");
            System.out.println("5. Покупка покупателем продукта");
            System.out.println("6. Оборот магазина за всё время работы");
            System.out.println("7. Добавить денег покупателю");     

            try {
                number = scan.nextInt();
            } catch (Exception e) {
                number = 999;
            }

            switch (number) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    shoesManager.addProduct();
                    break;
                case 2:
                    shoesManager.listProducts();
                    break;
                case 3:
                    customerManager.addCustomer();
                    break;
                case 4:
                    customerManager.listCustomers();
                    break;
                case 5:
                    customerManager.listCustomers();
                    System.out.print("\nВыберите покупателя: ");
                    index = scan.nextInt();
                    if (customerManager.getCustomers().size() <= index || index < 0) {
                        System.out.println("Ты дурак!");
                    } else {
                        shoesManager.listProducts();
                        System.out.print("Выберите товар: ");
                        index2 = scan.nextInt();
                        if (index2 < 0) {
                            System.out.println("Ты дурак!");
                        } else {
                            shoePrice = shoesManager.getShoeById(index2).getPrice();
                            if (shoePrice > customerManager.getCustomers().get(index).getMoney()) {
                                System.out.println("Денег недостаточно!");
                            } else {
                                customerManager.addMoney(index, -shoePrice);
                                shoesManager.sale(shoePrice);
                                shoesManager.deleteProduct(index2);
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("Оборот магазина за все время: " + shoesManager.getNet());
                    break;
                case 7:
                    customerManager.listCustomers();    
                    System.out.print("\nВыберите покупателя: ");
                    index = scan.nextInt();
                    if (customerManager.getCustomers().size() <= index || index < 0) {
                        System.out.println("Ты дурак!");
                    } else {
                        System.out.print("Введите количество денег: ");
                        money = scan.nextInt();
                        customerManager.addMoney(index, money);
                        String sql = "UPDATE customers SET money = money + " + money + " WHERE id = " + index;
                        stmt.executeUpdate(sql);
                    break; 
                    }
                    
                default:
                    System.out.println("Выберите задачу из списка!");;
            }  

        } while(repeat);

        System.out.println("Закрытие программы, пока!");

    }
    
    public Connection connectToDB() {
        Connection conn;
        try {
            conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/shoeshopsptv20milanajegorova",
            "shoeshopsptv20milanajegorova",
            "shoeshopsptv20milanajegorova");

            if (conn == null) {
                System.out.println("Нет соединения с БД!");
                System.exit(0);
            }
            
            return conn;
        } catch (SQLException e) {     
            e.printStackTrace();
        }
        return null;
    }
}
