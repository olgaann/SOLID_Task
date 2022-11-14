import java.util.HashMap;
import java.util.Map;

public class Store {

    protected Map<String, Integer> products = new HashMap<>();

    public Store() {
    }

    public Map<String, Integer> getProducts() {
        return products;
    }


    public void addProductAndPrice(String product, int price) {
        products.put(product, price);
    }

    public void printAssortment() {
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
    }


}
