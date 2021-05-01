package ru.netology;

import java.util.*;
// Класы оформлены с учётом принципа единственной ответственности

public class CatalogProduct implements ListOutput<Product> {
    private List<Product> catalogProduct = new ArrayList<>();

    public CatalogProduct addProduct(Product product) {
        this.catalogProduct.add(product);
        return this;
    }

    public CatalogProduct deleteProduct(Product product) {
        this.catalogProduct.remove(product);
        return this;
    }

    public List<Product> getCatalogProduct() {
        return catalogProduct;
    }
//D- принцип инверсии зависимостей
    public CatalogProduct сhangeOfRating(int index, boolean rating) {
        int a;
        if (rating) {
            a = 1;
        } else {
            a = -1;
        }
        catalogProduct.set(index, new Product(catalogProduct.get(index).getName(),
                catalogProduct.get(index).getManufacturer(),
                catalogProduct.get(index).getCategory(),
                catalogProduct.get(index).getPrice(),
                catalogProduct.get(index).getRating() + a));
        return this;
    }


}
