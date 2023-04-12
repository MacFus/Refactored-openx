package pl.fus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import pl.fus.Entity.Cart.Cart;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class InitializeTest {

    @Test
    public void testGsonDeserializeToCartObject() throws Exception {
        String json = """
                [
                {
                "id":1,
                "userId":1,\s
                "date":"2020-03-02T00:00:00.000Z","products":[
                {
                "productId":1,
                "quantity":4
                },
                {
                "productId":1,
                "quantity":4
                },
                {
                "productId":1,
                "quantity":4
                },
                ]
                }
                ]""";

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        Cart[] contributors;
        try (Reader reader = new BufferedReader(new StringReader(json))) {
            contributors = gson.fromJson(reader, Cart[].class);
        }
        System.out.println(contributors[0].getDate().toString());
        assertEquals(1, contributors.length);
        assertEquals(contributors[0].getId(), 1);
        assertEquals(contributors[0].getUserId(), 1);
        assertEquals(contributors[0].getUserId(), 1);
        assertEquals(contributors[0].getProducts().get(0).getProductId(), 1);
        assertEquals(contributors[0].getDate().toString(), "Mon Mar 02 01:00:00 CET 2020");

    }

}