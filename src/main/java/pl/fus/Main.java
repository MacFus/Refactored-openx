package pl.fus;

import pl.fus.Entity.Cart.Cart;
import pl.fus.Entity.Product.Product;
import pl.fus.Entity.User.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {

        // #1
        Initialize initialize = new Initialize();
        ArrayList<User> users = initialize.initUsers("https://fakestoreapi.com/users");
        ArrayList<Product> products = initialize.initProducts("https://fakestoreapi.com/products");
        ArrayList<Cart> carts = initialize.initCarts("https://fakestoreapi.com/carts");

//        Initialize<User> initializeUser = new Initialize<>();
//        ArrayList<User> users = initializeUser.init("https://fakestoreapi.com/users");
//        Initialize<Product> initializeProduct = new Initialize<>();
//        ArrayList<Product> products = initializeProduct.init("https://fakestoreapi.com/products");
//        Initialize<Cart> initializeCart = new Initialize<>();
//        ArrayList<Cart> carts = initializeCart.init("https://fakestoreapi.com/carts");


        // #2
        HashMap<String, AtomicReference<Double>> dataStructureOfCategoriesAndTotalValue = Product.createDataStructureOfCategoriesAndTotalValue(products);

        // #3
        Cart.findCartWithHighestValue(carts, products, users);

        // #4
        Utils.findLongestDistanceBetweenUsers(users);



    }
}