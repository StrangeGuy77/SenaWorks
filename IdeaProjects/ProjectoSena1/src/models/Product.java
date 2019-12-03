package models;

public class Product {

    private String name;
    private int price, quantity, code;

    public Product(String name, int price, int quantity, int code){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.code = code;
    }

}
