package ru.netology.productmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Book firstBook = new Book(130689, "Чайка", 156, "Чехов");
    Book secondBook = new Book(15690, "Оригами", 589, "Коржиков");
    Smartphone smartphone = new Smartphone(123, "t 191", 1900, "Motorola");
    Smartphone smartphone2 = new Smartphone(876, "3310", 1500, "Nokia");


    @Test
    public void shouldFindBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(smartphone);
        manager.add(smartphone2);

        Product[] expected = {secondBook};
        Product[] actual = manager.searchBy("Оригами");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(smartphone);
        manager.add(smartphone2);

        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("t 191");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteById() {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(smartphone);
        manager.add(smartphone2);
        manager.deleteById(123);

        Product[] expected = {firstBook, secondBook, smartphone2};
        Product[] actual = repository.products;

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindBook1() {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(smartphone);
        manager.add(smartphone2);
        manager.searchBy("1");

        Product[] expected = {smartphone, smartphone2};
        Product[] actual = manager.searchBy("1");

        Assertions.assertArrayEquals(expected, actual);
    }

}
