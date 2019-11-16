package com.bit.book;

public class Book {
    public String name;
    public String author;
    public int price;
    public String type;
    public boolean isBorrowed;

    public Book(String name, String author, int price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
        //this.isBorrowed = isBorrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", "+((isBorrowed==true)? " 此书被借":" 此书未被借")+
                '}';
    }
}
