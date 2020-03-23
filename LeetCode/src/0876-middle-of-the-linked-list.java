//0876-链表的中间结点
//思路：数组；单指针；快慢指针



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



//单指针：0ms，击败100%的用户
/*
 - 算法：
      - 定义计数器count，以及链表指针cur；
      - 第一次遍历链表，并计数；
      - 重新定义计数器res，并将cur置为head；
      - 第二次遍历链表：当res达到中间值时返回对应结点。
      - 注：计数器初始化为0，并且第一次遍历时，比最终的结点多1，与结点个数是一致的，经测试，奇偶性符合要求。同上。
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
        //定义计数器count，以及链表指针cur；
        int count = 0;
        ListNode cur = head;

        //第一次遍历链表，并计数
        while(cur != null){
            count++;
            cur = cur.next;
        }

        //重新定义计数器res，并将cur置为head
        int res = 0;
        cur = head;

        //第二次遍历链表：当res达到中间值时返回对应结点
        while(res < count/2){
            res++;
            cur = cur.next;
        }
        return cur;
    }
}



//快慢指针：0ms，击败100%的用户
/*
 - 算法：
      - 定义快慢指针；
      - 遍历链表：慢指针走一步，快指针走两步，当快指针到达末尾时终止循环；
      - 返回慢指针。
      - 注：循环判断的是快指针，当前和下一个，因为循环体中的走两步要防止越界。
      - 注：循环停止时，两指针均指向下一个结点，边界值判断经测试符合。
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
        //定义快慢指针
        ListNode slow = head, fast = head;

        //遍历链表
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //返回慢指针
        return slow;
    }
}
