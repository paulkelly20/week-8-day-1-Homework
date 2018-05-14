package models;

public class Order {

    private String date;
    private String product;
    private int id;

    public Order(String date, String product) {
        this.date = date;
        this.product = product;
    }

    public Order() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
