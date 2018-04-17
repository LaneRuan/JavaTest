package JZOffer.LinkedList;
/*一个链表的节点Node公共类*/
public class ListNode {
    private int value;
    private ListNode next;
    ListNode(int data){
        this.value = data;
    }

    public ListNode getNext() {
        return next;
    }
    public void setNext(ListNode node){
        this.next = node;
    }
    public int getValue(){
        return this.value;
    }
    public void setValue(int data){
        this.value = data;
    }
    /*往链表末尾添加一个节点*/
    public void AddToTail(ListNode head,int value){
        ListNode newNode = new ListNode(value);
        newNode.setNext(null);
        if(head==null){
            head = newNode;
        }
        else{
            ListNode pNode = head;
            while (pNode.next!=null){
                pNode = pNode.next;
            }
            pNode.next = newNode;
        }
    }
    /*找到第一个含有某值得节点并删除该节点*/
    public void RemoveNode(ListNode head,int value){
        if(head == null){
            return;
        }
        ListNode toBeDeleted = null;
        if(head.value == value){
            toBeDeleted = head;
            head = head.next;
        }
        else{
            ListNode pNode = head;
            while(pNode.next!=null&&pNode.next.value!=value){
                pNode = pNode.next;
            }
            if(pNode.next!=null&&pNode.next.value==value){
                toBeDeleted = pNode.next;
                pNode.next = toBeDeleted.next;
            }
        }
    }
}
