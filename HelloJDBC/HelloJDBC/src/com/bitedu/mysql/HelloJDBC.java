package com.bitedu.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJDBC {
    public static void main(String[] args) {
        Connection connection=null;
        Statement stmt=null;
        try {
            //加载注册数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection=DriverManager.getConnection("jdbc:mysql://localhost/","root","wyh5219764");
            stmt=connection.createStatement();
            stmt.execute("create database my_jdbc_db");

            //stmt.execute("drop database my_jdbc_db");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(stmt!=null){
                    stmt.close();
                }
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
