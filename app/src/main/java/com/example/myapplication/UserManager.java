package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class UserManager{
    private static List<User> registeredUsers = new ArrayList<>();
    public static void addUser(User user) {
        registeredUsers.add(user);
    }
    public static User getUser(String username) {
        for (User user : registeredUsers) {
            if(user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }
}
