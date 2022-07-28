package commands.delete;

import commands.Command;
import commands.buy.Buy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import system.MarketplaceSystem;
import system.Product;
import system.User;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class deleteProductTest {

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
    void deleteProductNonBoughtSuccess(){
        Command delete = new DeleteProduct(2);

        Command buy1 = new Buy(1, 1);
        Command buy2 = new Buy(1, 3);

        Command buy3 = new Buy(2, 1);
        Command buy4 = new Buy(2, 2);

        Command buy5 = new Buy(3, 2);
        buy1.execute(system);
        buy2.execute(system);
        buy3.execute(system);
        buy4.execute(system);
        buy4.execute(system);
        buy5.execute(system);
        delete.execute(system);

        Map<Product, Integer> expectedUser1Products = new HashMap<>();
        expectedUser1Products.put(createProductById(1), 1);
        expectedUser1Products.put(createProductById(3), 1);

        Map<Product, Integer> expectedUser2Products = new HashMap<>();
        expectedUser2Products.put(createProductById(1), 1);

        Map<Product, Integer> expectedUser3Products = new HashMap<>();

        Map<Integer, Product> expectedProducts = new HashMap<>();
        expectedProducts.put(1, new Product(1, "Pencil", 45));
        expectedProducts.put(3, new Product(3, "Pen", 20));

        assertTrue(system.getProductMap().equals(expectedProducts));

        assertTrue(system.getUserById(1).getBoughtProducts().equals(expectedUser1Products));
        assertTrue(system.getUserById(2).getBoughtProducts().equals(expectedUser2Products));
        assertTrue(system.getUserById(3).getBoughtProducts().equals(expectedUser3Products));
    }


    @Test
    void deleteProductBoughtSuccess(){
        Command delete = new DeleteProduct(1);
        delete.execute(system);

        Command buy1 = new Buy(1, 2);
        Command buy2 = new Buy(1, 3);
        Command buy3 = new Buy(2, 3);
        buy1.execute(system);
        buy2.execute(system);
        buy2.execute(system);
        buy3.execute(system);

        Map<Product, Integer> expectedUser1Products = new HashMap<>();
        expectedUser1Products.put(createProductById(2), 1);
        expectedUser1Products.put(createProductById(3), 1);

        Map<Product, Integer> expectedUser2Products = new HashMap<>();
        expectedUser2Products.put(createProductById(3), 1);

        Map<Product, Integer> expectedUser3Products = new HashMap<>();

        Map<Integer, Product> expectedProducts = new HashMap<>();
        expectedProducts.put(2, new Product(2, "Pencil", 45));
        expectedProducts.put(3, new Product(3, "Pen", 20));

        assertTrue(system.getProductMap().equals(expectedProducts));

        assertTrue(system.getUserById(1).getBoughtProducts().equals(expectedUser1Products));
        assertTrue(system.getUserById(2).getBoughtProducts().equals(expectedUser2Products));
        assertTrue(system.getUserById(3).getBoughtProducts().equals(expectedUser3Products));
    }









    private Product createProductById(int productId){
        return new Product(productId, "", 0);
    }
}