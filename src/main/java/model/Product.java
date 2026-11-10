package model;

public class Product {
    private int id;
    private String brand;
    private String model;
    private String category;
    private String specifications;
    private double price;

    public Product(int id, String brand, String model, String category, String specifications, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.specifications = specifications;
        this.price = price;
    }

    public int getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getCategory() { return category; }
    public String getSpecifications() { return specifications; }
    public double getPrice() { return price; }

    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
    public void setCategory(String category) { this.category = category; }
    public void setSpecifications(String specifications) { this.specifications = specifications; }
    public void setPrice(double price) { this.price = price; }

}