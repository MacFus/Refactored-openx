package pl.fus;


//import com.google.gson.reflect.TypeToken;

import pl.fus.Entity.Cart.Cart;
import pl.fus.Entity.Product.Product;
import pl.fus.Entity.User.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // #1
        Initialize initialize = new Initialize();
        ArrayList<User> users = initialize.initUsers("https://fakestoreapi.com/users");
        ArrayList<Product> products = initialize.initProducts("https://fakestoreapi.com/products");
        ArrayList<Cart> carts = initialize.initCarts("https://fakestoreapi.com/carts");


        Map<Integer, User> usersMap = users.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));

        Map<String, ArrayList<Product>> productMap = new HashMap<>();
        for(Product p : products){
            if (!productMap.containsKey(p.getCategory()))
                productMap.put(p.getCategory(), new ArrayList<>(List.of(p)));
            else
                productMap.get(p.getCategory()).add(p);
        }
        Map<Integer, Double> productValueMap = products.stream()
                .collect(Collectors.toMap(Product::getId, Product::getPrice));

        // #2
        Map<String, AtomicReference<Double>> categoryTotalValueMap = new HashMap<>();
        for (String s : productMap.keySet()) {
            AtomicReference<Double> totalValue = new AtomicReference<>((double) 0);
            productMap.get(s).forEach((p) -> totalValue.updateAndGet(v -> v + p.getPrice()));
            categoryTotalValueMap.put(s, totalValue);
        }
        double max = 0;
        Cart cart = null;
        int productId;
        int quantity;
        for(Cart c : carts){
            double tempMax = 0;
            for (int i = 0; i <c.getProducts().size() ; i++) {
                productId = c.getProducts().get(i).getProductId();
                quantity = c.getProducts().get(i).getQuantity();
                tempMax += productValueMap.get(productId) * quantity;
            }

            if(max<tempMax)
                cart = c;
            max = Math.max(max, tempMax);
        }

        Utils.findLongestDistanceBetweenUsers(users);


        System.out.println(max + " " + cart);
//        users.forEach(System.out::println);
//        User user = new User();
//        ArrayList<User> objects = user.initObject(url);
//        user.map(objects);
//
//        URL url;
//        try {
//            url = new URL("https://fakestoreapi.com/users");
////            InputStreamReader reader = new InputStreamReader(url.openStream());
////            User[] users = new Gson().fromJson(reader, User[].class);
//            User user = new User();
//            ArrayList<User> users = user.initObject(url);
//
////            Map<Integer, User> userMap = Arrays.stream(users).collect(Collectors.toMap(User::getId, Function.identity()));
//            System.out.println();
//            Map<Integer, User> userMap = new HashMap<>();
//            for (User u : users)
//                userMap.put(u.getId(), u);
//        }  catch (IOException e) {
//            throw new RuntimeException(e);
//        }


    }
}