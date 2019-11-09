class ListNode{
    public ListNode prev;
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data=data;

    }
}
public class DoubleList {
    public ListNode head;
    public ListNode last;

    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
            this.last=node;
        }else{
            node.next=this.head;
            this.head.prev=node;
            this.head=node;
        }
    }
    public void addLast(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
            this.last=node;
        }else {
            this.last.next=node;
            node.prev=this.last;
            this.last=node;
        }
    }
    private ListNode searchIndex(int index){
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
    private int getLength(){
        ListNode cur=this.head;
        int count=0;
        while (cur!=null){
            ++count;
            cur=cur.next;
        }
        return count;
    }
    public boolean addIndex(int index,int data){
        ListNode cur=searchIndex(index);
        ListNode node=new ListNode(data);
        if(index==getLength()){
            addLast(data);
        }
        if(index==0){
            addFirst(data);
            return true;
        }else {
            node.next=cur;
            cur.prev.next=node;
            node.prev=cur.prev;
            cur.prev=node;
        }
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
