//0206-反转链表
//思路：迭代；递归。


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */



//迭代：0ms，击败100%的用户
/*
   - 算法：
      - 定义双指针：当前指针cur指向当前结点，前指针pre指向当前结点的前一个结点；
      - 循环：当cur不指向null时遍历链表
        - 定义临时结点tmp，将cur的next结点信息存在tmp中；
        - 将cur的下个结点指向pre，完成反转；
        - 将pre和cur往后移动一个结点：pre赋值为cur，cur赋值为tmp（此时，pre与cur直接断开了，但是下个循环就会连起来）；
        - 注：循环到最后，cur会赋值为尾结点指向的null，这时pre是最后一个不为空的结点，并且和cur不连接，可以作为返回值。
      - 返回结果pre。
      - 注：本方法自带判空。
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



//递归：0ms，击败100%的用户
/*
  - 算法：
      - 判空：当head为空，或者仅有一个结点时，返回head本身；
      - 递归：结点cur赋值为head.next的反转链表结果，这句会一直dfs到末尾，然后开始返回；
        - 把head看做一个结点，把剩余结点并且已经调用过反转函数的返回值看做cur。
      - 形成环：将head.next的下一个结点赋值为head，即将head.next连接到head；
      - 切断head与head.next的连接；
      - 最后返回cur：cur是尾结点。
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        //判空
        if(head == null || head.next == null)
            return head;
        
        //递归：结点cur赋值为head.next的反转链表结果，这句会一直dfs到末尾，然后开始返回；
        ListNode cur = reverseList(head.next);

        //形成环：将head.next的下一个结点赋值为head，即将head.next连接到head；
        head.next.next = head;

        //切断head与head.next的连接；
        head.next = null;

        //返回结果
        return cur;
    }
}
