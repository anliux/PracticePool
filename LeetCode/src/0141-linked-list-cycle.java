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
