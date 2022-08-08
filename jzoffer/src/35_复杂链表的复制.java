//35. 复杂链表的复制



//哈希表：0 ms/100.00%; 41.3 MB/13.24%
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        //判空：为空则返回null
        if(head==null)
            return null;

        //初始化：当前结点cur，哈希表map
        Node cur = head;
        HashMap<Node,Node> map = new HashMap<>();

        //遍历：复制结点并存表，移动cur
        while(cur!=null){
            map.put(cur, new Node(cur.val));
            cur=cur.next;
        }

        //cur置为head
        cur = head;

        //遍历：新结点构建链接
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur=cur.next;
        }

        //返回结果: map.get(原结点)来获取新结点中的头结点
        return map.get(head);
    }
}



//拼接拆分：
