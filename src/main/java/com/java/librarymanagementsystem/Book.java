package com.java.librarymanagementsystem;

public class Book extends LibaryItems {

    public Book(String title, String author, String serialNumber) {
        super(title,
                author,
                serialNumber);
    }

    @Override
    public void borrowItem(User user) {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(user + "Book Borrowed Succesfully" + getTitle());
        } else {
            System.out.println("the " + getTitle() + "Already Borrowed ");

        }
    }




    }

