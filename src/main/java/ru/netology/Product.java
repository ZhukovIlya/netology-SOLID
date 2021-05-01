package ru.netology;

//"L" принцип замены Барбары Лисков
public class Product extends Thing {
    private Сategories category;
    private int price;
    private double rating;


    public Product(String name, String manufacturer, Сategories category, int price, double rating) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    public Product(String name, String manufacturer, Сategories category, int price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.category = category;
        this.price = price;
        this.rating = 0;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public Сategories getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Продукт " + getName()
                + ", производитель " + getManufacturer()
                + ", цена " + getPrice()
                + ", рейтинг " + getRating();
    }
}
