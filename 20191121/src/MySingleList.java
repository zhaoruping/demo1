class ListNode{
    public ListNode next;
    public int val;

    public ListNode(int val){
        this.next=null;
        this.val=val;
    }
}

public class MySingleList {
    ListNode head;

    public MySingleList(){
        this.head=null;
    }
    public  void addFirst(int val){
        ListNode node=new ListNode(val);
        if(this.head==null){
            this.head=node;
        }else {
            node.next=this.head;
            this.head=node;
        }
    }
    public ListNode deleteDuplication(){
        if(this.head==null){
            return null;
        }
        ListNode node=new ListNode(-1);
        ListNode cur=this.head;
        ListNode tmp=node;
        while (cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while (cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
                cur=cur.next;
            }else {
                tmp.next=cur;
                cur=cur.next;
                tmp=tmp.next;
            }
        }
        tmp.next=null;
        return node.next;
    }
    public void display(){
        ListNode cur=this.head;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
}
