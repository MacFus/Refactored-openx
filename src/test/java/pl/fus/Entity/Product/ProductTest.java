package pl.fus.Entity.Product;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {


    @Test
    void shouldCreateDataStructureOfCategoriesAndTotalValue() {
        ArrayList<Product> products = new ArrayList<>(List.of(
                new Product(12.99, "electronics"),
                new Product(42.01, "electronics"),
                new Product(45, "electronics")));
        HashMap<String, AtomicReference<Double>> data = Product.createDataStructureOfCategoriesAndTotalValue(products);
        assertEquals(100.0, data.get("electronics").get());
    }
}