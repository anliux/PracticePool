//0141-环形链表
//思路：哈希表；双指针


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */



//哈希表：6ms，击败24.7%的用户
/*
    - 分析：遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。
      - 如果当前结点为空结点 null（即已检测到链表尾部的下一个结点），那么我们已经遍历完整个链表，并且该链表不是环形链表。
      - 如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）。
    - 注：哈希表有hashmap和hashset两种，hashmap存储键值对，而hashset存储对象。本题仅需要存储各个结点，因此选择hashset
    - 算法：新建hashset；遍历链表直到next为null(即达到尾结点)：验证，已存在则返回true，否则更新到下一结点；遍历结束后仍没有返回时，返回false。
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        //新建hashset
        Set<ListNode> res = new HashSet<>();

        //遍历：不断更新head为下一结点，直到尾结点指向null
        while(head != null){
            //判断当前head是否已存在于res中
            if(res.contains(head))
                return true;
            else
                res.add(head);
            head = head.next;
        }

        //若遍历完成后仍没有返回，则说明不符合，返回false
        return false;
    }
}



//双指针：0ms，击败100%的用户
//算法：判空；新建快慢指针；循环直到两指针相等：循环中若出现任一指针为null，则返回false；循环结束后返回true
public class Solution {
    public boolean hasCycle(ListNode head) {
        //判空：下一步定义快慢指针，快指针总指向next，需要防止空指针异常
        if(head == null || head.next == null)
            return false;
        
        //定义快慢指针
        ListNode slow = head;
        ListNode fast = head.next;

        //循环：直到快慢指针相等
        while(slow != fast){
            //判空：注意下一步快慢指针向后，防止空指针异常(否则判空任一指针即可)
            //注意：判断的都是fast指针，fast在前，如果fast没问题，那么slow也没问题。当前和next都需要判断。
            if(fast == null || fast.next == null)
                return false;
            
            //更新快慢指针
            slow = slow.next;
            fast = fast.next.next;
        }

        //当快慢指针相等时，说明是循环链表，返回true
        return true;
    }
}

//注：循环中真假条件交换以后，也可以。注意空指针异常
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next != null){ 
            if(slow == fast)
                return true;
            
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
