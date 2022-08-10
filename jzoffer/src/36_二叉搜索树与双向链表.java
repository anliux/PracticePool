//36. 二叉搜索树与双向链表



//递归-中序遍历：0ms/100%; 40.6 MB/79.17%
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    //定义全局变量
    Node pre, head;//初始化为空结点

    public Node treeToDoublyList(Node root) {
        //判空：
        if(root==null)
            return null;

        //递归
        dfs(root);

        //头尾连接
        head.left = pre;
        pre.right = head;

        //返回头结点
        return head;
    }

    public void dfs(Node cur){//中序：左-中-右
        //递归出口：注意不是return null, 与返回值类型不符
        if(cur == null)
            return;

        //递归：一路向左子树递归到底
        dfs(cur.left);

        /*
        pre为空，说明是第一个结点，作为head
        pre不为空，说明是中间的结点，且pre保存的是上一个结点，这时让其右指针指向当前结点
        */
        if(pre==null)
            head = cur;
        else
            pre.right = cur;

        //让当前结点的左指针指向父结点，构成双向链表
        cur.left = pre;//如果pre==null,这一步不受影响。

        //保存当前结点，用于下层递归创建
        pre = cur;
        dfs(cur.right);
    }
}
