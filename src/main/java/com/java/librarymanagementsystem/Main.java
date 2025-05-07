package com.java.librarymanagementsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Libary libary = new Libary();

        /// Add library items

        /*LibaryItems book1 = new Book("To Kill a Mockingbird", "Harper Lee", "B0001");
        LibaryItems book2 = new Book("Robing hood", "jone chals", "B0002");
        LibaryItems book3 = new Book("warsha", "Sujeewa Presanna Arachchi", "B0003");
        LibaryItems magazing1 = new Magazine(" Tech Today", "John A. Mitchel", "M0001");
        LibaryItems magazing2 = new Magazine("Science World", "Dr. Emily Carson", "M0002");
        LibaryItems magazing3 = new Magazine("Global Business Review", "Michael Tanaka", "M0003");

        libary.addItem(book1);
        libary.addItem(book2);
        libary.addItem(book3);
        libary.addItem(magazing1);
        libary.addItem(magazing2);
        libary.addItem(magazing3);

        //add libarary Users

        User user1 = new User("Vidura");
        User user2 = new User("Sithu");
        User user3 = new User("Priya");
        User user4 = new User("tharushi");

        libary.addUser(user1);
        libary.addUser(user2);
        libary.addUser(user3);
        libary.addUser(user4);
*/

        List<LibaryItems> libaryItems = LibaryIO.loadItemFile("itemsList.lms");
        for (LibaryItems libaryItem : libaryItems) {
            libary.addItem(libaryItem);
        }
        //libaryItems.forEach(libary::addItem);

        List<User> users = LibaryIO.loadUserFile("usersList.lms");
        for (User user : users) {
            libary.addUser(user);
        }

        Map<String, String> borrowedItems = LibaryIO.loadBorrowedLibraryItems("borrowedItemsList.lms");
        for (Map.Entry<String, String> borrowedItem : borrowedItems.entrySet()) {
            libary.getBorrowedItems().put(borrowedItem.getKey(), borrowedItem.getValue());
        }


        System.out.println("*******************************Libary Items*******************************");

        libary.getLibaryItems().forEach(item -> System.out.println(item.getTitle() + "\t\t" + item.getAuthor() + "\t\t" + item.getSerialNumber()));


        System.out.println("*******************************User Details*******************************");

        libary.getUserList().forEach(user -> System.out.println(user.getUser_name()));

        System.out.println("*******************************Borrowed Item*******************************");

        libary.getBorrowedItems().forEach((item, user) -> System.out.println(item + ":" + users));


        boolean exist = false;
        L1:while (!exist) {
            System.out.println("\nEnter the main menu option\n");
            System.out.println("1. Create New Item");
            System.out.println("2. Create new User");
            System.out.println("3.Borrowed an item");
            System.out.println("4.Return an item");
            System.out.println("5.Exit");

            BufferedReader mainMenuOption = new BufferedReader(new InputStreamReader(System.in));
            int mainMenuOptionChoice;
            try {
                mainMenuOptionChoice = Integer.parseInt(mainMenuOption.readLine());
            } catch (IOException e) {
                System.out.println("Please enter a valid option!" + e.getMessage());
                continue;
            }

            if (mainMenuOptionChoice == 1) {
                System.out.println("\n.............Create new item.............\n");
                System.out.println("1. Create New Book");
                System.out.println("2. Create New Magazine");
                BufferedReader CreatedItemType = new BufferedReader(new InputStreamReader(System.in));
                int CreatedItemTypeChoice;
                try {
                    CreatedItemTypeChoice = Integer.parseInt(CreatedItemType.readLine());
                } catch (IOException e) {
                    System.out.println("Please enter a valid option!" + e.getMessage());
                    continue;
                }
                if (CreatedItemTypeChoice == 1) {
                    System.out.println("\n....Create new Book.........\n");
                    System.out.println("1.Please enter the title of the book ");
                    String bookNameStr = new BufferedReader(new InputStreamReader(System.in)).readLine();

                    System.out.println("2.Please enter the author of the book ");
                    String authorStr = new BufferedReader(new InputStreamReader(System.in)).readLine();

                    System.out.println("3.Please enter the serial number of the book ");
                    String bookserialNumberStr = new BufferedReader(new InputStreamReader(System.in)).readLine();

                    for (LibaryItems libaryItem : libary.getLibaryItems()) {
                        if (Objects.equals(libaryItem.getSerialNumber(), bookserialNumberStr)) {
                            System.out.println("This library Item already exists!");
                            continue;
                        }
                    }
                    LibaryItems CreateNewBook = new Book(bookNameStr, authorStr, bookserialNumberStr);
//                    System.out.println(bookNameStr + "\t\t" + authorStr + "\t\t" + bookserialNumberStr);
//                    System.out.println(CreateNewBook.getTitle());
                    libary.addItem(CreateNewBook);

                } else if (CreatedItemTypeChoice == 2) {
                    System.out.println("\n....Create new Magazine.......\n");
                    System.out.println("1.Please enter the title of the magazine ");
                    String magazineNameStr = new BufferedReader(new InputStreamReader(System.in)).readLine();

                    System.out.println("2.Please enter the author of the magazine ");
                    String authorStr = new BufferedReader(new InputStreamReader(System.in)).readLine();

                    System.out.println("3.Please enter the serial number of the magazine ");
                    String magazineserialNumberStr = new BufferedReader(new InputStreamReader(System.in)).readLine();

                    for (LibaryItems libaryItem : libary.getLibaryItems()) {
                        if (Objects.equals(libaryItem.getSerialNumber(), magazineserialNumberStr)) {
                            System.out.println("This library Item already exists!");
                            continue;
                        }
                    }
                    LibaryItems CreateNewMagazine = new Magazine(magazineNameStr, authorStr, magazineserialNumberStr);
                    libary.addItem(CreateNewMagazine);
                }

            } else if (mainMenuOptionChoice == 2) {
                System.out.println("\n....Create New User.........\n");
                System.out.println("1.Please enter the Name of the user ");
                String userName = new  BufferedReader(new InputStreamReader(System.in)).readLine();
                for (User user : libary.getUserList()) {
                    if (Objects.equals(user.getUser_name(), userName)) {
                        System.out.println("This User already Registred!");
                        continue L1;
                    }
                }
                User CreateNewUser = new  User(userName);
                libary.addUser(CreateNewUser);

            }else if (mainMenuOptionChoice == 3) {
                System.out.println("\n........Borrowed an Item.........\n");
                System.out.println("who is the borrower of the item?\n");
                IntStream.range(0, libary.getUserList().size()).forEach(index -> System.out.println(index+". "+libary.getUserList().get(index).getUser_name()));
                int userNameIndex = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                System.out.println("1.Please enter the serial number of the item \n");
                String itemSerialNumber = new BufferedReader(new InputStreamReader(System.in)).readLine();
                libary.borrowItem(itemSerialNumber,libary.getUserList().get(userNameIndex));

            } else if (mainMenuOptionChoice == 4) {
                System.out.println("\n.............Return an Item..........\n");
                System.out.println("who is the returen an item ? \n");
                IntStream.range(0,libary.getUserList().size()).forEach(index -> System.out.println(libary.getUserList().get(index).getUser_name()));
                int userNameIndex = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                System.out.println("1.Please enter the serial number of the item \n");
                String itemSerialNumber = new BufferedReader(new InputStreamReader(System.in)).readLine();
                libary.ReturnBorrowedItem(itemSerialNumber,libary.getUserList().get(userNameIndex));

            } else if (mainMenuOptionChoice == 5) {
                exist = true;

            }

        }
        //System.out.println(libaryItems);
        LibaryIO.saveItemFile(libary.getLibaryItems(), "itemsList.lms");
        LibaryIO.saveUserFile(libary.getUserList(), "usersList.lms");
        LibaryIO.saveBorrowedLibraryItems(libary.getBorrowedItems(),"borrowedItemsList.lms");

    }
}