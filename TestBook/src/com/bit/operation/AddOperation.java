package com.bit.operation;

import com.bit.book.Book;
import com.bit.book.BookList;

public class AddOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("请输入图书名:");
        String name=sc.next();
        System.out.println("请输入图书的作者：");
        String author=sc.next();
        System.out.println("请输入图书的价格：");
        int price=sc.nextInt();
        System.out.println("请输入图书的类型");
        String type=sc.next();
        Book book=new Book(name,author,price,type);
        System.out.println("添加成功");
        System.out.println(book);
        int curSize=bookList.getSize();
        bookList.setBooks(curSize,book);
        bookList.setSize(bookList.getSize()+1);


    }
}
