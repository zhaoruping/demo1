package com.bitedu.data;

public class Student {
    private int sno;
    private String name;
    private int no;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
    public String toString(){
        return "sno="+sno+",name="+name+",no="+no;
    }
}
