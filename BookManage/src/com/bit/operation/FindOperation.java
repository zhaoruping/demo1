package com.bit.operation;

import com.bit.book.BookList;

public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入要查找的书籍名：");
        String name=sc.next();
        int i=0;
        for (i = 0; i < bookList.getSize(); i++) {
            if (bookList.getBook(i).name.equals(name)){
                break;
            }
        }
        if(i>=bookList.getSize()){
            System.out.println("没有此书");
            return;
        }
        System.out.println("书籍查找成功");
        System.out.println(bookList.getBook(i));
    }
}
