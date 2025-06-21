package service;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public boolean deleteUserById(int id) {
        return users.removeIf(user -> user.getId() == id);
    }

    public boolean updateUser(int id, String name, String email) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(name);
                user.setEmail(email);
                return true;
            }
        }
        return false;
    }
}
