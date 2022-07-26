package system;

import java.util.HashMap;
import java.util.Map;

public class MarketplaceSystem {

    private Map<Integer, Product> productMap;
    private Map<Integer, User> userMap;

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }

    public Map<Integer, User> getUserMap() {
        return userMap;
    }


    public User getUserById(int userId){
        return userMap.get(userId);
    }

    public Product getProductById(int productId){
        return productMap.get(productId);
    }

    public MarketplaceSystem(){
        productMap = new HashMap<>();
        userMap = new HashMap<>();
//
//        putInitialValues();
    }

    private void putInitialValues() {

        productMap.put(1, new Product(1, "Pencil", 45));
        productMap.put(2, new Product(2, "Case", 10));
        productMap.put(3, new Product(3, "Pen", 20));

        userMap.put(1, new User(1, "Maks", "Killman", 300));
        userMap.put(2, new User(2, "Melissa", "Choppa", 350));
        userMap.put(3, new User(3, "Asya", "Porokh", 10));
    }
}
