package ru.netology;

import java.util.Scanner;

import static ru.netology.Сategories.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int choice;
        int choice1;
        Baskets baskets = new Baskets();
        int numberOfBaskets = -1;
        CatalogProduct catalogProduct = new CatalogProduct()
                .addProduct(new Product("Молоко", "Молоко завод", LACTIC, 70, 2.0))
                .addProduct(new Product("Шоколад", "Шоколадная фабрика", SWEETS, 100, 1.0))
                .addProduct(new Product("Печеньки", "Булочная", SWEETS, 80))
                .addProduct(new Product("Курица", "Молоко завад", MEAT, 200, 2.0))
                .addProduct(new Product("Свинина", "Молоко завад", MEAT, 110));

        while (true) {
            System.out.println("Выберите пункт меню"
                    + "\n" + "1.Начать покупки"
                    + "\n" + "2.Подтверждение заказа/Повтороение заказа"
            );
            input = scanner.nextLine();
            choice = checkChoice(input);
            if (!(checkMenu(choice, 2))) {
                continue;
            }
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("Выберите пункт меню"
                                + "\n" + "1.Вывод доступных для покупки товаров"
                                + "\n" + "2.Фильтрация товаров по ключевым категориям, ценам, производителям"
                                + "\n" + "3.Система рейтинга для товаров"
                                + "\n" + "для возврата в преведущее меню наберите end");
                        input = scanner.nextLine();
                        if (input.equals("end")) {
                            break;
                        }
                        choice = checkChoice(input);
                        if (!(checkMenu(choice, 3))) {
                            continue;
                        }
                        switch (choice) {
                            case 1:
                                baskets.addBasket(new Basket());
                                numberOfBaskets++;
                                while (true) {
                                    System.out.println("Выберете продукт, для возврата в преведущее меню наберите end");
                                    System.out.println(catalogProduct.listOutput(catalogProduct.getCatalogProduct()));
                                    input = scanner.nextLine();
                                    if (input.equals("end")) {
                                        break;
                                    }
                                    choice = checkChoice(input);
                                    //принцип избегания магических чисел
                                    if (!(checkMenu(choice, catalogProduct.getCatalogProduct().size()))) {
                                        continue;
                                    }
                                    baskets.addProduct(numberOfBaskets, catalogProduct.getCatalogProduct().get(choice - 1));
                                    continue;
                                }
                            case 2:
                                System.out.println("Категории товаров");
                                catalogProduct.getCatalogProduct().stream()
                                        .filter(e -> e.getCategory().equals(LACTIC))
                                        .forEach(System.out::println);
                                catalogProduct.getCatalogProduct().stream()
                                        .filter(e -> e.getCategory().equals(SWEETS))
                                        .forEach(System.out::println);
                                catalogProduct.getCatalogProduct().stream()
                                        .filter(e -> e.getCategory().equals(MEAT))
                                        .forEach(System.out::println);
                                break;
                            case 3:
                                while (true) {
                                    System.out.println("Рейтинг товаров");
                                    System.out.println(catalogProduct.listOutput(catalogProduct.getCatalogProduct()));
                                    System.out.println("Для голосования выбрите продукт, для возврата в преведущее меню наберите end");
                                    input = scanner.nextLine();
                                    if (input.equals("end")) {
                                        break;
                                    }
                                    choice = checkChoice(input);
                                    if (!(checkMenu(choice, catalogProduct.getCatalogProduct().size()))) {
                                        continue;
                                    }
                                    System.out.println("1.Повысить рейтинг"
                                            + "\n" + "2.Понизить рейтинг");
                                    input = scanner.nextLine();
                                    choice1 = checkChoice(input);
                                    if (!(checkMenu(choice1, 2))) {
                                        continue;
                                    }
                                    switch (choice) {
                                        case 1:
                                            catalogProduct.сhangeOfRating(choice - 1, true);
                                            continue;
                                        case 2:
                                            catalogProduct.сhangeOfRating(choice - 1, false);
                                            continue;
                                    }
                                }
                        }
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Выберите вашу корзину из списка");
                    System.out.println(baskets.listOutput(baskets.getBaskets()));
                    input = scanner.nextLine();
                    choice = checkChoice(input);
                    if (!(checkMenu(choice, baskets.getBaskets().size()))) {
                        continue;
                    }
                    System.out.println("Корзина №" + choice + " оплачена");

                    break;
            }
        }
    }
    // принцип DRY
    public static int checkChoice(String input) {
        int choice = 0;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            System.out.println("введен не коректный номер  операции");
        }
        return choice;
    }
    // принцип DRY
    public static boolean checkMenu(int choice, int size) {
        if (choice > size || choice < 1) {
            System.out.println("введен не коректный номер  операции");
            return false;
        }
        return true;
    }
}
