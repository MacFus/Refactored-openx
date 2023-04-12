package pl.fus.Entity.Cart;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import pl.fus.Entity.Product.Product;
import pl.fus.Entity.User.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Getter
public class Cart {
    private int id;
    private int userId;
    private Date date;
    @SerializedName("products")
    private ArrayList<CartProduct> products;

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                '}';
    }

    public static void findCartWithHighestValue(ArrayList<Cart> carts, ArrayList<Product> products, ArrayList<User> users){
        Map<Integer, Double> productValueMap = Product.idToValueMap(products);
        double max = 0;
        Cart cart = null;
        User user = null;
        int productId;
        int quantity;
        for(Cart c : carts){
            double tempMax = 0;
            for (int i = 0; i <c.getProducts().size() ; i++) {
                productId = c.getProducts().get(i).getProductId();
                quantity = c.getProducts().get(i).getQuantity();
                tempMax += productValueMap.get(productId) * quantity;
            }
            if(max<tempMax){
                cart = c;
                user = users.get(cart.getUserId()-1);
            }

            max = Math.max(max, tempMax);
        }
        assert cart != null : "Cart is null";
        System.out.println("Cart with highest value is cart number: " + cart + ". And value of it equals: " + max +". Owner: " + user);
    }


}
