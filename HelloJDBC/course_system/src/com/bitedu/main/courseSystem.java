package com.bitedu.main;
import com.bitedu.data.Student;

import static com.bitedu.db.DatabaseOperator.*;

public class courseSystem {
    public static void main(String[] args) {
        Student stu=new Student();
        stu.setSno(20190101);
        stu.setName("Sushan");
        stu.setNo(1);
        //insertStudent(stu);
        Student stu2=selectData(2019001);
        //selectDataCount();
        selectScoreCount(70);

        //System.out.println(stu2);
    }
}
