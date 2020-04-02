package com.bitedu.mysql;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class InsertCase {
    public static DataSource getDataSourse() {
        //Connection conn = null;
        MysqlDataSource ds=new MysqlDataSource();
        ds.setURL("dbc:mysql://localhost/my_jdbc_db");
        ds.setUser("root");
        ds.setPassword("wyh5219764");

        return ds;
       /* try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/my_jdbc_db", "root", "wyh5219764");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;*/
    }

    public static void createTable(){
        DataSource dataSource=null;
        Connection conn=null;
        Statement stmt=null;
        try {
            String sql="create table jdbc_table(col1 int,col2 varchar(20));";
            stmt=conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void insertIntoTable() {
        Connection conn=null;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "insert into jdbc_table(col1,col2) values(10,'hello');";
            stmt.execute(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void select_table(){
            Connection conn=null;
            Statement stmt=null;
            ResultSet rs=null;
            try {
                stmt=conn.createStatement();
                String sql="select * from jdbc_table";
                rs=stmt.executeQuery(sql);
                while (rs.next()){
                    Integer col1=rs.getInt("col1");
                    String col2=rs.getString("col2");
                    System.out.println("col1="+col1+"  col2="+col2);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

    }

    public static void main(String[] args) {
        //createTable();
        insertIntoTable();
        select_table();
    }
}
