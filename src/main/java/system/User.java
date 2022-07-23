package system;

import java.util.HashMap;
import java.util.Map;

public class User {

    private final int id;
    private final String firstName;
    private final String lastName;
    private int balance;
    private final Map<Product, Integer> boughtProducts;


    public User(int id, String firstName, String lastName, int balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        boughtProducts = new HashMap<>();
    }


    public void setBalance(int balance) {
        this.balance = balance;
    }


    public int getBalance() {
        return balance;
    }


    public Map<Product, Integer> getBoughtProducts() {
        return boughtProducts;
    }


    @Override
    public String toString() {
        return "id: " + id + ", " +
                "firstName: " + firstName + ", " +
                "lastName: " + lastName + ", " +
                "balance: " + balance;
    }

}