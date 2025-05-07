package com.java.librarymanagementsystem;

public class Magazine extends LibaryItems{

    public Magazine(String title, String author, String serialNumber) {
        super(title, author, serialNumber);
    }


    @Override
    public void borrowItem(User user) {
        if(this.isBorrowed) {
            System.out.println(getTitle()+"The Magazine is already borrowed");
        }else {
            System.out.println("The Magazine is borrowed successfully"+getTitle());
        }

    }
}
