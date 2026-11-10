package service;

import model.User;
import java.io.*;
import java.util.*;

public class UserService {
    private List<User> users = new ArrayList<>();
    private final String FILE_NAME = "users.txt";

    public UserService() {
        loadFromFile();

        if (users.isEmpty()) {
            users.add(new User("admin", "admin123", "MANAGER"));
            saveToFile();
        }
    }

    public boolean addUser(User user) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(user.getUsername())) {
                return false;
            }
        }
        users.add(user);
        saveToFile();
        return true;
    }

    public User login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username)
                    && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (User u : users) {
                writer.println(u.getUsername() + "," +
                        u.getPassword() + "," +
                        u.getRole());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                users.add(new User(data[0], data[1], data[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}