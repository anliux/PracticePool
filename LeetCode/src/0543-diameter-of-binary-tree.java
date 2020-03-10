//0543-二叉树的直径
//思路：dfs递归



//dfs递归：0ms，击败100%的用户
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
/*
  - 算法：因为要迭代，所以定义额外的函数
      - 定义全局遍历max
      - 定义私有函数来进行迭代：
        - 判断：树结点为空时，返回0，终止迭代；否则进行下述步骤；
        - 本结点的左右结点分别调用本体迭代，并存储在遍历left和right中；
        - 更新最大值max为max和（left+right）的最大值；
        - 更新树的最大深度为`Math.max(right, left)+1`
      - 原函数：
        - 直接将结点传入私有函数，并返回全局遍历max
*/

class Solution {
    //定义全局变量max
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        //调用并返回max
        getDepth(root);
        return max;
    }

    //定义私有函数getDepth()
    private int getDepth(TreeNode root){
        //结点为null时返回0
        if(root == null)
            return 0;
        
        //定义左右子树的最大深度
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        //更新最大值
        max = Math.max(max, left+right);

        //更新结点的最大深度，并返回
        return 1 + Math.max(left, right);
    }
}
