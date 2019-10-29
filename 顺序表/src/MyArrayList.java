import java.util.Arrays;

class MyArrayList {

    public int usedSize;//实际使用的长度
    public int[] elem;//顺序表（用数组实现）

    public final int CAPACITY=10;//线性表长度
    public  MyArrayList(){
        this.usedSize=0;
        this.elem=new int[CAPACITY];
    }
    private boolean isFull(){
        if(this.usedSize==this.elem.length){
            return true;
        }
        return false;
    }
    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //1.pos是否合法
        if(isFull()){//如果数组长度不够，进行二倍扩容
            this.elem=Arrays.copyOf(this.elem,this.elem.length*2);
        }
        if(pos<0||pos>usedSize){//数组越界异常
            throw new IndexOutOfBoundsException("插入位置不合法");

        } else { //2.移动数据
                for(int i=usedSize-1;i>=pos;i--){
                     elem[i++]=elem[i];//从最后一位开始向后移动一位
                 } //3.插入数据
                    elem[pos]=data;
                    //4.usedSize++
                     usedSize++;
                 }
    }
  // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for(int i=0;i<usedSize;i++){
            if(toFind==elem[i]){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        if(isEmpty()){
            System.out.println("顺序表为空");
            return -1;
        }
        for(int i=0;i<this.usedSize;i++){
            if(elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos<0||pos>usedSize){
            return -1;
        }else{
            return elem[pos-1];
        }
    }
    private  boolean isEmpty(){
        if(this.usedSize==0){
          return true;
        }
        return false;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        //1.顺序表是否为空
        if(isEmpty()){
            System.out.println("顺序表为空");
            return ;
        }
        //2.查找要删除的下标
        int index=search(toRemove);
        if(index==-1){
            System.out.println("没有这个数");
        }else {//3.删除
            for (int i = index; i < this.usedSize-1; i++) {
                elem[i] = elem[i + 1];//从index位置开始，将后一个数的值赋给前面的数
            }
            this.usedSize--;
        }
    }
    // 获取顺序表长度
    public int size() {
        return usedSize;
    }
    // 清空顺序表
    public void clear(){
        usedSize=0;
    }
    public void display() {
        for(int i=0;i<this.usedSize;i++){
            System.out.println(elem[i]+" ");
        }
    }
}
