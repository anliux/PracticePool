//24-反转链表
//思路：迭代；递归。



//迭代：0ms/100%; 40.4 MB/98.52%
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        //迭代：双指针

        //定义双指针pre和cur
        ListNode pre = null; //前指针pre指向最终的链表尾null
        ListNode cur = head; //当前指针cur指向头结点

        //循环：直到cur为null，即遍历至链表结尾
        while(cur != null){
            //定义临时变量存储cur下一个结点的信息，防止链表断开
            ListNode tmp = cur.next;

            //pre与cur反转
            cur.next = pre;

            //pre和cur分别向后移动：此时pre与cur之间是断开的，下个循环连起来
            pre = cur;
            cur = tmp;
        }

        //循环最后，pre与cur断开状态，且cur为null，则返回pre
        return pre;
    }
}



//递归：0ms/100%; 40.6 MB/88.38%
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return recur(head, null);
    }

    public ListNode recur(ListNode cur, ListNode pre){
        if(cur == null)//终止条件
            return pre;
        
        //递归遍历链表的所有结点
        ListNode res = recur(cur.next,cur);

        //递归到最后回溯时，反转相邻结点的指向
        cur.next = pre;

        //返回res
        return res;
    }
}
