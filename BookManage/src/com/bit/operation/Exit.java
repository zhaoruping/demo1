package com.bit.operation;

import com.bit.book.BookList;

public class Exit implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出");
        System.exit(0);

    }
}
