package com.bitedu.db;
import java.sql.*;
import javax.sql.DataSource;
import com.bitedu.data.Student;
import com.bitedu.data.take;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;



public class DatabaseOperator {
    private final static String URL="jdbc:mysql://localhost/course_system";
    private final static String USER="root";
    private final static String PASSWORD="wyh5219764";


    public static DataSource getDataSourse(){
        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setURL(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);

        return dataSource;
    }
    //1.插入学生表
    public static void insertStudent(Student stu){
        Connection connection=null;
        PreparedStatement pstmt=null;
        try {
            connection=getDataSourse().getConnection();
            String sql="insert into stu values(?,?,?)";
            pstmt=connection.prepareStatement(sql);
            pstmt.setInt(1,stu.getSno());
            pstmt.setString(2,stu.getName());
            pstmt.setInt(3,stu.getNo());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt!=null){
                    pstmt.close();
                }
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //2.查询学生表
    public static int selectDataCount(){
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Student stu=new Student();
        int count=0;

        try {
            connection=getDataSourse().getConnection();
            String sql="select count(sno)as stu_number from stu";
            pstmt=connection.prepareStatement(sql);
            //pstmt.setInt(1,sno);
            rs=pstmt.executeQuery();
            while (rs.next()){
                /*stu.setSno(rs.getInt("sno"));
                stu.setName(rs.getString("name"));
                stu.setNo(rs.getInt("no"));*/
                System.out.println("count="+rs.getInt("stu_number"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null){
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    public static take selectScoreCount(int score){
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        take tak=new take();
        //int count=0;

        try {
            connection=getDataSourse().getConnection();
            String sql="select score,count(score)as count from take group by score having score>?";
            pstmt=connection.prepareStatement(sql);
            pstmt.setInt(1,score);
            rs=pstmt.executeQuery();
            while (rs.next()){
                System.out.println("score="+rs.getInt("score")+",count="+rs.getInt("count"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null){
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tak;
    }
    public static Student selectData(int sno){
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Student stu=new Student();

        try {
            connection=getDataSourse().getConnection();
            String sql="select * from stu where sno=?";
            pstmt=connection.prepareStatement(sql);
            pstmt.setInt(1,sno);
            rs=pstmt.executeQuery();
            while (rs.next()){
                stu.setSno(rs.getInt("sno"));
                stu.setName(rs.getString("name"));
                stu.setNo(rs.getInt("no"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null){
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return stu;
    }
    //3.插入班级表
    //4.删除班级表
    //5.插入课程表
    //6.查询课程表
    //7.插入教师表
    //8.查询教师表
}
