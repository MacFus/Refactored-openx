package pl.fus;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pl.fus.Entity.Cart.Cart;
import pl.fus.Entity.Product.Product;
import pl.fus.Entity.User.User;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Initialize{
    public ArrayList<User> initUsers(String userUrl){
        try {
            Type type = new TypeToken<ArrayList<User>>(){}.getType();
            return new Gson().fromJson(Utils.readUrl(userUrl), type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Product> initProducts(String productUrl){
        try {
            Type type = new TypeToken<ArrayList<Product>>(){}.getType();
            return new Gson().fromJson(Utils.readUrl(productUrl), type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Cart> initCarts(String cartUrl) {
        try {
//            Gson gson = new GsonBuilder().setDateFormat(Cart.PATTERN)
            Type type = new TypeToken<ArrayList<Cart>>(){}.getType();
            return new Gson().fromJson(Utils.readUrl(cartUrl),type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    private <T> Type getType(T t){
//        return new TypeToken<ArrayList<T>>(){}.getType();
//    }
}
