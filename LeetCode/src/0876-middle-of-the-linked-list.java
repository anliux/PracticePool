//0876-链表的中间结点
//思路：数组；单指针；双指针



//数组：0ms，击败100%的用户。
/*
- 算法：
      - 定义链表结点数组；
      - 定义数组索引值(其实也可以看做指针）；
      - 遍历数组，同时将链表结点存入数组，链表指针向后移动；
      - 遍历结束后，根据索引值返回中间结点。
      - 注：pt索引值比最终的存入结点多1，与结点个数是一致的，经测试，奇偶性符合要求。
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        //定义链表结点数组，以及索引值
        ListNode [] arr = new ListNode[100]; //根据题目定义的范围
        int pt = 0;

        //遍历数组，同时将链表结点存入数组，链表指针向后移动
        while(head != null){
            arr[pt++] = head; //pt自增
            head = head.next;
        }

        //返回中间结点
        return arr[pt / 2];
    }
}
