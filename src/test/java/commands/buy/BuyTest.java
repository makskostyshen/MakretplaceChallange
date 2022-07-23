package commands.buy;

import commands.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import system.MarketplaceSystem;
import system.Product;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BuyTest {

    static MarketplaceSystem system;

    @BeforeEach
    public void initMarketplaceSystem(){
        system = new MarketplaceSystem();

    }

    @Test
    void purchaseOneSuccessful(){
        Command buy = new Buy(1, 3);
        buy.execute(system);

        assertTrue(system.getUserById(1).getBalance() == 280);

        Map<Product, Integer> properBoughtProducts = new HashMap<>();
        properBoughtProducts.put(createProductById(3), 1);

        Map<Product, Integer> resultingBoughtProducts = system.getUserById(1).getBoughtProducts();

        assertTrue(resultingBoughtProducts.equals(properBoughtProducts));
    }

    @Test
    void purchaseTwoDifferentSuccessful(){
        Command buyThird = new Buy(2, 1);
        Command buySecond = new Buy(2, 2);
        buyThird.execute(system);
        buySecond.execute(system);

        assertTrue(system.getUserById(2).getBalance() == 295);

        Map<Product, Integer> properBoughtProducts = new HashMap<>();
        properBoughtProducts.put(createProductById(1), 1);
        properBoughtProducts.put(createProductById(2), 1);


        Map<Product, Integer> resultingBoughtProducts = system.getUserById(2).getBoughtProducts();

        assertTrue(resultingBoughtProducts.equals(properBoughtProducts));
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

        Map<Product, Integer> properBoughtProducts = new HashMap<>();
        properBoughtProducts.put(createProductById(1), 3);

        Map<Product, Integer> resultingBoughtProducts = system.getUserById(2).getBoughtProducts();

        assertTrue(resultingBoughtProducts.equals(properBoughtProducts));
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