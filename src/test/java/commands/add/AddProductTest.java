package commands.add;

import commands.Command;
import commands.buy.NotEnoughBalanceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import system.MarketplaceSystem;
import system.Product;
import system.User;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AddProductTest {
    static MarketplaceSystem system;

    @BeforeEach
    public void initMarketplaceSystem(){
        system = new MarketplaceSystem();
    }

    @Test
    void addSingleCorrectProductInitially(){
        Command addProduct = new AddProduct("name", 10);
        addProduct.execute(system);

        Map<Integer, Product> expectedProducts = new HashMap<>();
        expectedProducts.put(1, createProductById(1));

        Map<Integer, Product> resultingProducts = system.getProductMap();

        assertTrue(expectedProducts.equals(resultingProducts));
    }

    @Test
    void addSingleProductWithWrongNumberOfParameters(){

        assertThrows(IllegalArgumentException.class, () ->{
            new AddProduct("name", 10, 44);
        });
    }

    @Test
    void addSingleProductWithNotNumeric(){

        assertThrows(IllegalArgumentException.class, () ->{
            new AddProduct("name", "10, 44");
        });
    }

    @Test
    void add3CorrectProductsAfterAddingOne(){
        Command addProduct1 = new AddProduct("name", 100);
        Command addProduct2 = new AddProduct("name", 10);
        Command addProduct3 = new AddProduct("names", "10");
        addProduct1.execute(system);
        addProduct2.execute(system);
        addProduct3.execute(system);

        Map<Integer, Product> expectedProducts = new HashMap<>();
        expectedProducts.put(2, createProductById(2));
        expectedProducts.put(3, createProductById(3));
        expectedProducts.put(4, createProductById(4));

        Map<Integer, Product> resultingProducts = system.getProductMap();

        assertTrue(expectedProducts.equals(resultingProducts));
    }



    private Product createProductById(int productId){
        return new Product(productId, "", 0);
    }
}