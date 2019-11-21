public class TestDemo {
    public static void main(String[] args) {
        MySingleList mySingleList=new MySingleList();
        mySingleList.addFirst(9);
        mySingleList.addFirst(8);
        mySingleList.addFirst(8);
        mySingleList.addFirst(8);
        mySingleList.addFirst(7);
        mySingleList.addFirst(4);
        mySingleList.addFirst(1);
        mySingleList.deleteDuplication();
        mySingleList.display();
    }
}
