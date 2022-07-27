package commands.delete;

import commands.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import system.MarketplaceSystem;
import system.Product;
import system.User;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class deleteUserTest {
    static MarketplaceSystem system;

    @BeforeEach
    public void initMarketplaceSystem(){
        system = new MarketplaceSystem();

        system.getProductMap().put(1, new Product(1, "Pencil", 45));
        system.getProductMap().put(2, new Product(2, "Case", 10));
        system.getProductMap().put(3, new Product(3, "Pen", 20));

        system.getUserMap().put(1, new User(1, "Maks", "Killman", 300));
        system.getUserMap().put(2, new User(2, "Melissa", "Choppa", 350));
        system.getUserMap().put(3, new User(3, "Asya", "Porokh", 10));
    }


    @Test
    void deleteExistingUserSuccess(){
        Command delete = new DeleteUser(1);
        delete.execute(system);

        Map<Integer, User> returning = system.getUserMap();

        Map<Integer, User> expected = new HashMap<>();
        expected.put(2, new User(2, "Melissa", "Choppa", 350));
        expected.put(3, new User(3, "Asya", "Porokh", 10));

        assertTrue(returning.equals(expected));
    }

    @Test
    void deleteNonExistingUserSuccess(){
        Command delete = new DeleteUser(4);
        delete.execute(system);

        Map<Integer, User> returning = system.getUserMap();

        Map<Integer, User> expected = new HashMap<>();

        expected.put(1, new User(1, "Maks", "Killman", 300));
        expected.put(2, new User(2, "Melissa", "Choppa", 350));
        expected.put(3, new User(3, "Asya", "Porokh", 10));

        assertTrue(returning.equals(expected));
    }
}