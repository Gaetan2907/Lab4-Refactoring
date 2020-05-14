package ch.heigvd.gen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class OrderJsonWriterTest {

    Order order = new Order(111);
    Product product = new Product("Shirt", Color.BLUE, Size.M, 2.99, "TWD");

    @BeforeEach
    public void SetupOneProduct(){
        order.AddProduct(product);
    }

    @Test
    public void noProduct(){
        assertEquals("{\"id\": 0, \"products\": []}", new OrderJsonWriter(new Order(0)).getContent());
    }

    @Test
    public void TwoOrders() {
        order.AddProduct(new Product("Jeans", Color.BLUE, Size.M, 32.99, "TWD"));
    // {"id": 111, "products": [{"code": "Shirt", "color": "blue", "size": "M", "price": 2.99, "currency": "TWD"}", {"code": "Jeans", "color": "blue", "size": "M", "price": 32.99, "currency": "TWD"}]}
        String product1Json = "{\"code\": \"Shirt\", \"color\": \"blue\", \"size\": \"M\", \"price\": 2.99, \"currency\": \"TWD\"}";
        String product2Json = "{\"code\": \"Jeans\", \"color\": \"blue\", \"size\": \"M\", \"price\": 32.99, \"currency\": \"TWD\"}";
        String order111Json = JsonOrder111WithProduct(product1Json + ", " + product2Json);
        assertEquals(order111Json,new OrderJsonWriter(order).getContent());
    }

    private String JsonOrder111WithProduct(String productJson) {
        return "{\"id\": 111, \"products\": [" + productJson + "]}";
    }
}
