package pl.fus.Entity.Cart;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Setter
@Getter
public class Cart {
    private int id;
    private int userId;
    private Date date;
    //    private Product[] products;
    @SerializedName("products")
    private ArrayList<CartProduct> products;
    public static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                '}';
    }
}
