package com.bit.operation;

import com.bit.book.Book;
import com.bit.book.BookList;

public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入要删除的书籍名称");
        String name=sc.next();
        int i=0;
        for (i = 0; i < bookList.getSize(); i++) {
            if (bookList.getBook(i).name.equals(name)) {
                break;
            }
        }
            if(i>=bookList.getSize()){
                System.out.println("没有此书");
                return;
            }
            for(int j=i;j<bookList.getSize()-1;j++){
                Book book=bookList.getBook(j+1);
                bookList.setBooks(j,book);
            }
            System.out.println("图书删除成功");



    }
}
