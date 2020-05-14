package ch.heigvd.gen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductJsonWriterTest {


    Product product = new Product("Shirt", Color.BLUE, Size.M, 2.99, "TWD");

    @Test
    public void OneProduct(){
        assertEquals("{\"code\": \"Shirt\", \"color\": \"blue\", \"size\": \"M\", \"price\": 2.99, \"currency\": \"TWD\"}", new ProductJsonWriter(product).getContent());
    }


}
