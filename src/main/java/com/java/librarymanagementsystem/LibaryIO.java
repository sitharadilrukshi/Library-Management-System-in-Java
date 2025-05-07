package com.java.librarymanagementsystem;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibaryIO {
    public static void saveItemFile(List<LibaryItems> libaryItems, String fileName) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            System.out.println(libaryItems);
            oos.writeObject(libaryItems);
            System.out.println("Library Items Save to  " + fileName + " successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<LibaryItems> loadItemFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            return (List<LibaryItems>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveUserFile(List<User> users, String fileName) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(users);
            System.out.println("User Save to  " + fileName + " successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> loadUserFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            return (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveBorrowedLibraryItems(Map<String,String> borrowedItems, String fileName) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(borrowedItems);
            System.out.println("Borrowed Items Save to  " + fileName + " successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String,String> loadBorrowedLibraryItems(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return new HashMap<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            return (Map<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}