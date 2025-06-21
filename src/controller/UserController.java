package controller;

import model.User;
import service.UserService;

import java.util.Scanner;

public class UserController {
    private final UserService userService = new UserService();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n1. Add User\n2. View All Users\n3. Delete User\n4. Update User\n5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1 -> addUser();
                case 2 -> viewAllUsers();
                case 3 -> deleteUser();
                case 4 -> updateUser();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void addUser() {
        System.out.print("ID: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        userService.addUser(new User(id, name, email));
        System.out.println("User added.");
    }

    private void viewAllUsers() {
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }
    }

    private void deleteUser() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt(); scanner.nextLine();
        if (userService.deleteUserById(id)) {
            System.out.println("User deleted.");
        } else {
            System.out.println("User not found.");
        }
    }

    private void updateUser() {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("New name: ");
        String name = scanner.nextLine();
        System.out.print("New email: ");
        String email = scanner.nextLine();
        if (userService.updateUser(id, name, email)) {
            System.out.println("User updated.");
        } else {
            System.out.println("User not found.");
        }
    }
}
