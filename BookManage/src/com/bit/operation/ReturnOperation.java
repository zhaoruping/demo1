package com.bit.operation;

import com.bit.book.Book;
import com.bit.book.BookList;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入要归还的书籍名：");
        String name = sc.next();
        int i = 0;
        for (i = 0; i < bookList.getSize(); i++) {
            if (bookList.getBook(i).name.equals(name)) {
                break;
            }
        }

            if (i >= bookList.getSize()) {
                System.out.println("没有此书");
                return;
            }
            Book book = bookList.getBook(i);
            if (book.isBorrowed) {
                book.isBorrowed = false;
                System.out.println("还书成功");
                return;
            } else {
                System.out.println("还书失败");
                return;
            }

    }
}
