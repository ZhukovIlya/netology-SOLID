package ru.netology;

import java.util.ArrayList;
import java.util.List;


public class Basket {
    private List<Product> basket = new ArrayList<>();

    public Basket addProduct(Product product) {
        this.basket.add(product);
        return this;
    }

    public Basket deleteProduct(Product product) {
        this.basket.remove(product);
        return this;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < basket.size(); i++) {
            sb.append((i + 1) + "." + basket.get(i) + "\n");
        }
        return sb.toString();
    }

}
