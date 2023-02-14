package entity;

public class Customer {
    private String name;
    private String surname;
    private int money;
    private long id;
   
    public Customer(String name, String surname, int money, long id) {
        this.name = name;
        this.surname = surname;
        this.money = money;
        this.id = id;
    }

    public Customer(String name, String surname, int money) {
        this.name = name;
        this.surname = surname;
        this.money = money;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;  
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", surname=" + surname + ", money=" + money + "}";
    }
}