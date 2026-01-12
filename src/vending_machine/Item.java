package vending_machine;

public class Item {
    private String name;
    private int stock;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceAsString() {
       return String.format("%.2f", price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Item(String name, int stock, double price) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return this.getName() + " $" + this.getPrice();
    }

}
