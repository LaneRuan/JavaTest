package JZOffer.LinkedList;

/*题目：输入一个链表的头节点，从尾到头反过来打印出每个节点的值*/

import java.util.Stack;

/*思路：要求打印，不希望打印时修改内容，根据后入先出的道理，我们可以用栈来实现这种顺序，
每经过一个节点时，把该节点压入栈中。当遍历完整个链表后，再从栈顶逐个输出节点的值*/
public class PrintListReserveringly {
    /*通过迭代实现*/
    public static void PrintReserverly_Iter(ListNode head){
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode pNode = head;
        while (pNode!=null){
            nodeStack.push(pNode);
            pNode = pNode.getNext();
        }
        while (!nodeStack.empty()){
            pNode = nodeStack.peek();
            System.out.println(pNode.getValue()+" ");
            nodeStack.pop();
        }
    }

    /*由于使用了栈，自然想到了递归，可以用递归来实现*/
    public static void PrintReserverly_Recursive(ListNode head) {
        if(head!=null){
            if(head.getNext()!=null){
                PrintReserverly_Recursive(head.getNext());
            }
        }
        System.out.println(head.getValue()+" ");
    }

}
