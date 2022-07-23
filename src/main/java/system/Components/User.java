package system.Components;

import java.util.HashMap;
import java.util.Map;

public class User{

    private int id;
    private String firstName;
    private String lastName;
    private int balance;
    private Map<Product, Integer> boughtProducts;

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

    public int getId() {
        return id;
    }

    public Map<Product, Integer> getBoughtProducts() {
        return boughtProducts;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//        return id == user.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }


    @Override
    public String toString() {
        return "id: " + id + ", " +
                "firstName: " + firstName + ", " +
                "lastName: " + lastName + ", " +
                "balance: " + balance;
    }

}
