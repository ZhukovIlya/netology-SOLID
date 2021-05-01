package ru.netology;

import java.util.ArrayList;
import java.util.List;

// Класы оформлены с учётом принципа единственной ответственности
public class Baskets implements ListOutput<Basket> {

    private List<Basket> baskets = new ArrayList<>();

    public Baskets addBasket(Basket basket) {
        this.baskets.add(basket);
        return this;
    }
    public Baskets addProduct(int index, Product product){
        baskets.get(index).addProduct(product);
        return this;

    }

    public Baskets deleteBasket(Basket basket) {
        this.baskets.remove(basket);
        return this;
    }
    public List<Basket> getBaskets() {
        return baskets;
    }
}
