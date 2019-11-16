package com.bit;

import com.bit.book.BookList;
import com.bit.user.Admin;
import com.bit.user.Normal;
import com.bit.user.User;

import java.util.Scanner;

public class Main {
    public static User login() {

        System.out.println("请输入你的姓名：");
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        System.out.println("请选择你的身份：1.管理员 2.用户");
        int who=sc.nextInt();
        if(who==1){
            return new Admin(name);
        }else{
            return new Normal(name);
        }
    }
    public static void main(String[] args) {
        User user=login();
        BookList bookList=new BookList();
        while (true){
            int choice=user.menu();
            user.doOperation(choice,bookList);
        }

        }
}

