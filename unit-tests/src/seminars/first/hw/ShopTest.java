package seminars.first.hw;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class ShopTest {

    /*
     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
     */
    public void testGetProducts() {
        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product(69, "Bread"));
        products.add(new Product(80, "Milk"));
        products.add(new Product(249, "Coffee"));

        shop.setProducts(products);

        List<Product> actualProducts = shop.getProducts();
        assertEquals(products.size(), actualProducts.size());
        assertTrue(actualProducts.containsAll(products));
    }

    /*
     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
     */
    public void testGetMostExpensiveProduct() {
        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product(69, "Bread"));
        products.add(new Product(80, "Milk"));
        products.add(new Product(249, "Coffee"));

        Product mostExpensiveProduct = shop.getMostExpensiveProduct();
        assertEquals("Coffee", mostExpensiveProduct.getTitle());
        assertEquals(249, mostExpensiveProduct.getCost());

        /*
     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов -
      не реализовано (
        */


    }
}




