//52-两个链表的第一个公共结点
//思路：暴力法；哈希表法；双指针法



//双指针法：1 ms/98.48%; 44.6 MB/21.59%
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
class Solution {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //判空：
        if(headA == null || headB == null)
            return null;

        //初始化两个指针：
        ListNode pa = headA, pb = headB;

        //循环：a+c+b = b+c+a, 当两指针相遇时退出
        while(pa != pb){//遍历到本链表的尾结点时，继续从另一链表头结点开始遍历
            pa = (pa!=null)? pa.next : headB ;
            pb = (pb!=null)? pb.next : headA ;
        }

        //返回结果：任一指针即可，有共同结点和无共同结点均符合
        return pa;
    }
}
