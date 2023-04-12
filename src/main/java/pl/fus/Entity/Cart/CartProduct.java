package pl.fus.Entity.Cart;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartProduct {
    private int productId;
    private int quantity;
//    private transient Product product;


    public CartProduct(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
