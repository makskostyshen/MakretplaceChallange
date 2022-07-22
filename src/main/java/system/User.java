package system;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private int balance;

    public User(int id, String firstName, String lastName, int balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "id: " + id + ", " +
                "firstName: " + firstName + ", " +
                "lastName: " + lastName + ", " +
                "balance: " + balance;
    }
}
