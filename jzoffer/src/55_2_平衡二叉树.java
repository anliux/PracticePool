//55.2 - 平衡二叉树
//从下到上进行遍历和递归。
//注：由求二叉树深度得到启发。若从上到下遍历，存在一个结点被多次遍历。
//    故后序遍历，从下到上。并且在遍历过程中进行判断，一旦不符合，即停止。

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root)!=-1;//作为一个flag，-1表示不符合的情况出现。
    }
    private int getDepth(TreeNode root){
		//首先判断根节点是否为空。为空则符合平衡二叉树。返回非-1的数。
        if(root==null)
            return 0;
        
		//定义左子树的返回值（是的，直接定义返回值，把左子树传入递归函数即可）
        int left = getDepth(root.left);
        if(left==-1)
            return -1;//如果出现-1，表示不符，则返回-1
        
		//同理，定义右子树的返回值
        int right = getDepth(root.right);
        if(right==-1)
            return -1;//如果出现-1，表示不符，则返回-1
        
		//如果上述if都没出现，即左右子树都是平衡二叉树时，则判断左右子树的深度差，用三元运算符化简。
		//注意：计算深度，记得max+1
        return((Math.abs(left-right)>1) ? -1 : 1+Math.max(left,right));
    }
}