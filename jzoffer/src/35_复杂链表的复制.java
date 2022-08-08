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



//拼接拆分：0ms/100%; 40.9 MB/69.94%
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
        //判空
        if(head==null)
            return null;
        
        //初始化当前结点：指向原链表的头结点
        Node cur = head;

        //遍历：复制各节点，并构建拼接链表
        while(cur!=null){
            Node temp = new Node(cur.val);//新建结点
            temp.next = cur.next;
            cur.next = temp;//temp结点插入到cur与cur.next之间
            cur = temp.next;
        }

        //cur结点复位到head结点
        cur = head;

        //遍历：构建各新节点的 random 指向
        while(cur!=null){
            if(cur.random != null)//要用到cur.random.next，加个判断
                                  //不加会抛空指针异常的！ 
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        //拆分原链表与新链表
        cur = head.next;//新链表
        Node pre = head, res = head.next;
        while(cur.next != null){
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }

        //补充原链表，并返回结果
        pre.next = null;
        return res;
    }
}
