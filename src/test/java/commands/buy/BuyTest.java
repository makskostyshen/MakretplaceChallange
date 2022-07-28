package commands.buy;

import commands.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import system.MarketplaceSystem;
import system.Product;
import system.User;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BuyTest {

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
    void purchaseOneSuccessful(){
        Command buy = new Buy(1, 3);
        buy.execute(system);

        assertTrue(system.getUserById(1).getBalance() == 280);

        Map<Product, Integer> expectedBoughtProducts = new HashMap<>();
        expectedBoughtProducts.put(createProductById(3), 1);

        Map<Product, Integer> resultingBoughtProducts = system.getUserById(1).getBoughtProducts();

        assertTrue(resultingBoughtProducts.equals(expectedBoughtProducts));
    }

    @Test
    void purchaseTwoDifferentSuccessful(){
        Command buyThird = new Buy(2, 1);
        Command buySecond = new Buy(2, 2);
        buyThird.execute(system);
        buySecond.execute(system);

        assertTrue(system.getUserById(2).getBalance() == 295);

        Map<Product, Integer> expectedBoughtProducts = new HashMap<>();
        expectedBoughtProducts.put(createProductById(1), 1);
        expectedBoughtProducts.put(createProductById(2), 1);
        System.out.println(expectedBoughtProducts);

        Map<Product, Integer> resultingBoughtProducts = system.getUserById(2).getBoughtProducts();
        System.out.println(resultingBoughtProducts);

        assertTrue(resultingBoughtProducts.equals(expectedBoughtProducts));
    }

    @Test
    void purchaseThreeSameSuccessful(){
        Command buyOne = new Buy(2, 1);
        Command buyTwo = new Buy(2, 1);
        Command buyThree = new Buy(2, 1);
        buyOne.execute(system);
        buyTwo.execute(system);
        buyThree.execute(system);

        assertTrue(system.getUserById(2).getBalance() == 215);

        Map<Product, Integer> expectedBoughtProducts = new HashMap<>();
        expectedBoughtProducts.put(createProductById(1), 3);

        Map<Product, Integer> resultingBoughtProducts = system.getUserById(2).getBoughtProducts();

        assertTrue(resultingBoughtProducts.equals(expectedBoughtProducts));
    }

    @Test
    void purchaseOneErrorNotEnoughMoneyException(){
        Command buy = new Buy(3, 1);

        assertThrows(NotEnoughBalanceException.class, () ->{
            buy.execute(system);
        });
    }

    private Product createProductById(int productId){
        return new Product(productId, "", 0);
    }

}