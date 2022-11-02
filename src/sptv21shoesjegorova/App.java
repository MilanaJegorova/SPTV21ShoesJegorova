package sptv21shoesjegorova;

import java.util.Scanner;

public class App {
    public void run(){
    boolean repeat = true;
    do{
    System.out.println("Задачи: ");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить продукт");
            System.out.println("2. Список продоваемых продуктов");
            System.out.println("3. Добавить покупателя");
            System.out.println("4. Список зарегистрированных покупателей");
            System.out.println("5. Покупка покупателем продукта");
            System.out.println("6. Оборот магазина за всё время работы");
            System.out.println("7. Добавить денег покупателю");
            Scanner task = new Scanner(System.in);
            int number = task.nextInt();
            switch (number) {
                 case 0:
                    repeat = false;
                    break;
                case 2:
                    System.out.println("1. Добавить продукт");
                    break;
                case 3:
                    System.out.println("2. Список продоваемых продуктов");
                    break;
                case 4:
                    System.out.println("3. Добавить покупателя");
                    break;
                case 5:
                    System.out.println("4. Список зарегистрированных покупателей");
                    break;
                case 6:
                    System.out.println("5. Покупка покупателем продукта");
                    break;
                case 7:
                    System.out.println("6. Оборот магазина за всё время работы");
                    break;
                case 8:
                    System.out.println("7. Добавить денег покупателю");
                    break;
                default:
                    System.out.println("Выберите задачу из списка!");;
            }    
    }while(repeat);
    System.out.println("Закрытие программы, пока!");
}
}
