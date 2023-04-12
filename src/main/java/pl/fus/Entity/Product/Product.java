package pl.fus.Entity.Product;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Getter
public class Product {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;

    public static HashMap<String, AtomicReference<Double>> createDataStructureOfCategoriesAndTotalValue(ArrayList<Product> products){
        System.out.println("Data structure containing all available product categories and the total value of products of a given category:");
        HashMap<String, ArrayList<Product>> productMap = new HashMap<>();
        for(Product p : products){
            if (!productMap.containsKey(p.getCategory()))
                productMap.put(p.getCategory(), new ArrayList<>(List.of(p)));
            else
                productMap.get(p.getCategory()).add(p);
        }
        HashMap<String, AtomicReference<Double>> categoryTotalValueMap = new HashMap<>();
        for (String s : productMap.keySet()) {
            AtomicReference<Double> totalValue = new AtomicReference<>((double) 0);
            productMap.get(s).forEach((p) -> totalValue.updateAndGet(v -> v + p.getPrice()));
            categoryTotalValueMap.put(s, totalValue);
        }
        categoryTotalValueMap.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println();
        return categoryTotalValueMap;
    }

    public static Map<Integer, Double> idToValueMap(ArrayList<Product> products){
        return products.stream()
                .collect(Collectors.toMap(Product::getId, Product::getPrice));
    }
}
