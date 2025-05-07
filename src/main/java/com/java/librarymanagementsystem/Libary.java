package com.java.librarymanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Libary {

    private List<LibaryItems>libaryItems;

    private List<User>userList;


    private Map<String, String> borrowedItems;

    public Libary() {
        libaryItems = new ArrayList<>();
        userList = new ArrayList<>();
        borrowedItems = new HashMap<>();
    }

    //add item and user

    public void addItem (LibaryItems libaryItem) {
//        System.out.println(libaryItem.getTitle());
        libaryItems.add(libaryItem);

    }

    public void addUser (User user) {
        userList.add(user);
    }
/// /////////////////////////////////////////////////////

    public  List<LibaryItems> getLibaryItems() {
        return libaryItems;
    }

    public List<User> getUserList() {
        return userList;
    }

    //for item borrow

    public void borrowItem(String serialNumber,User user) {
        for (LibaryItems libaryItem : libaryItems) {
            if (libaryItem.getSerialNumber().equals(serialNumber)) {
                if (borrowedItems.containsKey(libaryItem.getSerialNumber())) {
                    System.out.println("Item"+libaryItem.getTitle()+" is already borrowed");
                    return;
                }
                borrowedItems.put(libaryItem.getSerialNumber(),user.getUser_name());
                libaryItem.isBorrowed = true;
                System.out.println("Item"+libaryItem.getTitle()+" borrowed"+user.getUser_name());
                return;
            }
        }
        System.out.println("item with serial number "+serialNumber+" not found");

    }

    //return borrow item

    public void  ReturnBorrowedItem(String serialNumber,User user) {
        for (LibaryItems libaryItem : libaryItems) {
            if (libaryItem.getSerialNumber().equals(serialNumber)) {
                if (borrowedItems.containsKey(libaryItem.getSerialNumber())) {
                    borrowedItems.remove(libaryItem.getSerialNumber());
                    libaryItem.isBorrowed = false;
                    System.out.println("Item"+libaryItem.getTitle()+" is already borrowed"+user.getUser_name());
                    return;
                }
            }
        }
        System.out.println("item with serial number "+serialNumber+" not found");
    }

    public Map<String,String> getBorrowedItems() {
        return borrowedItems;
    }
}
