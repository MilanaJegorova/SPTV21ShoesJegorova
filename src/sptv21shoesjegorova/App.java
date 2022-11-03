package sptv21shoesjegorova;

import java.util.Scanner;
import manager.CustomerManager;
import manager.ShoesManager;

class App {
    
    public void run(){
    
    boolean repeat = true;
    
    CustomerManager customerManager = new CustomerManager();
    ShoesManager shoesManager = new ShoesManager();
    
    int number;
    int index;
    int index2;
    int shoePrice;
    int money;
    
    Scanner task = new Scanner(System.in);
    
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
            number = task.nextInt();
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
                index = task.nextInt();
                if (customerManager.getCustomers().size() <= index || index < 0) {
                    System.out.println("Ты дурак!");
                } else {
                    shoesManager.listProducts();
                    System.out.print("Выберите товар: ");
                    index2 = task.nextInt();
                    if (shoesManager.getShoes().size() <= index2 || index2 < 0) {
                        System.out.println("Ты дурак!");
                    } else {
                        shoePrice = shoesManager.getShoes().get(index2).getPrice();
                        if (shoePrice > customerManager.getCustomers().get(index).getMoney()) {
                            System.out.println("Денег недостаточно!");
                        } else {
                            customerManager.addMoney(index, -shoePrice);
                            shoesManager.setNet(shoesManager.getNet() + shoePrice);
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
                index = task.nextInt();
                if (customerManager.getCustomers().size() <= index || index < 0) {
                    System.out.println("Ты дурак!");
                } else {
                    System.out.print("Введите количество денег: ");
                    money = task.nextInt();
                    customerManager.addMoney(index, money);
                }
                break;
            default:
                System.out.println("Выберите задачу из списка!");;
        }  
        
    } while(repeat);
    
    System.out.println("Закрытие программы, пока!");
    
    }
}
