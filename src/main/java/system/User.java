package system;

import java.util.HashMap;
import java.util.Map;

public class User {

    private final int id;
    private final String firstName;
    private final String lastName;
    private double balance;
    private final Map<Product, Integer> boughtProducts;


    public User(int id, String firstName, String lastName, double balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        boughtProducts = new HashMap<>();
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }


    public double getBalance() {
        return balance;
    }


    public Map<Product, Integer> getBoughtProducts() {
        return boughtProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return id == user.id;
    }

//    @Override
//    public int hashCode(){
//        return id;
//    }

    @Override
    public String toString() {
        return "id: " + id + ", " +
                "firstName: " + firstName + ", " +
                "lastName: " + lastName + ", " +
                "balance: " + balance;
    }



}
