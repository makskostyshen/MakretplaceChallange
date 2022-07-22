package system;

import marketplace.Marketplace;

import java.util.HashMap;
import java.util.Map;

public class MarketplaceSystem {

    private Map<Integer, Product> productMap;
    private Map<Integer, User> userMap;
    private History history;

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }

    public Map<Integer, User> getUserMap() {
        return userMap;
    }

    public MarketplaceSystem(){
        productMap = new HashMap<>();
        userMap = new HashMap<>();

        productMap.put(1, new Product(1, "Pencil", 45));
        productMap.put(2, new Product(2, "Case", 10));
        productMap.put(3, new Product(3, "Pen", 20));

        userMap.put(1, new User(1, "Maks", "Killman", 300));
        userMap.put(2, new User(2, "Melissa", "Choppa", 350));
        userMap.put(3, new User(3, "Asya", "Porokh", 10));
        userMap.put(4, new User(4, "Slavik", "Hivniuk", 55));
    }
}
