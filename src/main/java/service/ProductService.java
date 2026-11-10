package service;

import model.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> productList = new ArrayList<>();
    private final String FILE_NAME = "products.txt";

    public ProductService() {
        loadFromFile();
    }

    // CREATE
    public void addProduct(Product product) {
        productList.add(product);
        saveToFile();
    }

    // READ
    public List<Product> getAllProducts() {
        return productList;
    }

    // UPDATE
    public void updateProduct(int id, String brand, String model,
                              String category, String specifications, double price) {

        for (Product p : productList) {
            if (p.getId() == id) {
                p.setBrand(brand);
                p.setModel(model);
                p.setCategory(category);
                p.setSpecifications(specifications);
                p.setPrice(price);
            }
        }
        saveToFile();
    }

    // DELETE
    public void deleteProduct(int id) {
        productList.removeIf(p -> p.getId() == id);
        saveToFile();
    }

    // SAVE TO FILE
    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Product p : productList) {
                writer.println(p.getId() + "," +
                        p.getBrand() + "," +
                        p.getModel() + "," +
                        p.getCategory() + "," +
                        p.getSpecifications() + "," +
                        p.getPrice());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // LOAD FROM FILE
private void loadFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 6) {
                productList.add(new Product(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        Double.parseDouble(data[5])
                ));
            } else {
                System.out.println("Invalid line: " + line);
            }
        }
    } catch (IOException e) {
        System.out.println("No existing file found.");
    }
}

}