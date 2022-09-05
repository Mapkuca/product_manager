package ru.netology.productmanager;

public class Smartphone extends Product {
    protected String producer;

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }

}
