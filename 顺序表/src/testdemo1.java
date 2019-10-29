public class testdemo1 {//顺序表的测试类
    public static void main(String[] args) {
      MyArrayList myArrayList=new MyArrayList();
      myArrayList.add(0,1);
      myArrayList.add(1,2);
      myArrayList.add(2,3);
      //myArrayList.display();
      int index=myArrayList.search(3);
      //System.out.println(index);
      myArrayList.remove(2);
      //myArrayList.display();
        // myArrayList.clear();
        //myArrayList.display();
    }

}
