//0160-相交链表
//思路：暴力法；哈希表法；双指针法



//双指针法：1ms，击败100%的用户
/*
    - 思路：链表A：a+c, 链表B : b+c. a+c+b+c = b+c+a+c 。则会在第二个c起点相遇。若不相交，a+b = b+a 。因此相遇处是NULL（尾）
    - 算法：判空；新建结点；循环：两结点移动，直到相等。
    - 注：没有公共时，最后都指向null，此时相等，退出循环。因此不会死循环。
    - 代码使用了三目运算符，很巧妙。
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //判空
        if(headA == null || headB == null)
            return null;
        
        //新建两指针结点
        ListNode pa = headA, pb = headB;

        //循环，直到pa和pb相等
        while(pa != pb){
            pa = (pa == null) ? headB : pa.next;
            pb = (pb == null) ? headA : pb.next;
        }

        //返回任一
        return pa;
    }
}
