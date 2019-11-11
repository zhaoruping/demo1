class ListNode{
    public ListNode prev;
    public ListNode next;
    public int data;

    public ListNode(int data){
        this.data=data;

    }
}
public class DoubleList {
    public ListNode head;
    public ListNode last;
    //头插法
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        //判断是否是第一次插入
        if(this.head==null){
            this.head=node;
            this.last=node;
        }else{
            node.next=this.head;
            this.head.prev=node;
            this.head=node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode node=new ListNode(data);
        //判断是否是第一次插入
        if(this.head==null){
            this.head=node;
            this.last=node;
        }else {
            this.last.next=node;
            node.prev=this.last;
            this.last=node;
        }
    }
    //查找下标所对应的节点
    private ListNode searchIndex(int index){
        //判断下标是否合法
        if(index<0||index>getLength()||this.head==null){
            return null;
        }
        ListNode cur=this.head;
        while (index>0){
            cur=cur.next;
            index--;
        }
        return cur;
    }
    //求双向链表的长度
    private int getLength(){
        ListNode cur=this.head;
        int count=0;
        while (cur!=null){
            ++count;
            cur=cur.next;
        }
        return count;
    }
    //任意位置插入
    public boolean addIndex(int index,int data){
        ListNode cur=searchIndex(index);//要插入位置的节点
        ListNode node=new ListNode(data);//要插入的节点
        if(index==getLength()){
            addLast(data);//尾插
        }
        if(index==0){
            addFirst(data);//头插
            return true;
        }
        //下标不合法
        if(cur==null){
            return false;
        }
        node.next=cur;
        cur.prev.next=node;
        node.prev=cur.prev;
        cur.prev=node;
        return true;
    }
    public boolean contains(int key){
        ListNode cur=this.head;
        while (cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    public int remove(int key){
        int olddata=-1;
        ListNode cur=this.head;
        while (cur!=null){
            if(cur.data==key){
                olddata=cur.data;
                if(cur==head){
                    head= head.next;
                    this.head.prev=null;
                }else{
                    olddata=cur.data;
                    cur.prev.next=cur.next;
                    if(cur.next!=null){
                        cur.next.prev=cur.prev;
                    }else {
                        this.last=cur.prev;
                    }
                }
               /* if(key==last.data){
                    olddata=last.data;
                    last=last.prev;
                    last.next=null;
                }*/

                return olddata;
            }
            cur=cur.next;
        }

        return -1;
    }
    public void removeAllKey(int key){
        ListNode cur=this.head;
        while (cur!=null){
            if(cur.data==key){
                if(cur==head){
                    head= head.next;
                    this.head.prev=null;
                }else{
                    cur.prev.next=cur.next;
                    if(cur.next!=null){
                        cur.next.prev=cur.prev;
                    }else {
                        this.last=cur.prev;
                    }
                }
            }
            cur=cur.next;
        }
    }
    public void clear(){
        while (this.head!=null){
            ListNode cur=this.head.next;
            this.head.next=null;
            this.head.prev=null;
            this.head=cur;
        }
        this.last=null;
    }
    public void display(){
        ListNode cur=this.head;
        while ((cur != null)) {

            System.out.println(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}
