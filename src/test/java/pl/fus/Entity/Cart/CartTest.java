package pl.fus.Entity.Cart;

import org.junit.jupiter.api.Test;
import pl.fus.Entity.Product.Product;
import pl.fus.Entity.User.Address;
import pl.fus.Entity.User.Geolocation;
import pl.fus.Entity.User.User;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void shouldFindCartWithHighestValue() {
        User user1 = new User(new Address(new Geolocation("-60.0", "-60.0")), 0);
        User user2 = new User(new Address(new Geolocation("0.0", "0.0")), 1);
        User user3 = new User(new Address(new Geolocation("60.0", "60.0")), 2);
        ArrayList<User> users = new ArrayList<>() {{
            add(user1);
            add(user2);
            add(user3);
        }};
        Product product1 = new Product(1,20);
        Product product2 = new Product(2,40);
        ArrayList<Product> products = new ArrayList<>() {{
            add(product1);
            add(product2);
        }};
        Cart cart1 = new Cart(1, 1, new ArrayList<>() {{
            add(new CartProduct(1, 4));
        }});
        Cart cart2 = new Cart(2, 2, new ArrayList<>() {{
            add(new CartProduct(2, 4));
        }});
        ArrayList<Cart> carts = new ArrayList<>() {{
            add(cart1);
            add(cart2);
        }};

        Cart cartWithHighestValue = Cart.findCartWithHighestValue(carts, products, users);
        assertSame(cartWithHighestValue, cart2);
    }
}