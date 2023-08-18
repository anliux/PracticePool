//68.1 - 构建乘积数组
//思路：迭代/迭代优化版；递归



//迭代: 6ms/39.57%; 40.71mb/86.46%
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //遍历直到root为null
        while(root != null){
            if(p.val > root.val && q.val > root.val)    //p,q都在右子树：遍历至右子节点
                root = root.right;
            else if(p.val < root.val && q.val < root.val)   //p,q都在左子树：遍历至左子节点
                root = root.left;
            else    //否则，p,q 在root节点两侧时，符合要求，退出循环
                break;
        }

        //返回结果节点
        return root;
    }
}



//迭代优化版：6ms/39.57%; 40.70mb/88.21%
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //先取p,q两节点的最值
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        
        //遍历直到root为null
        while(root != null){
            if(min > root.val)    //p,q都在右子树：遍历至右子节点
                root = root.right;
            else if(max < root.val)   //p,q都在左子树：遍历至左子节点
                root = root.left;
            else    //否则，p,q 在root节点两侧时，符合要求，退出循环
                break;
        }

        //返回结果节点
        return root;
    }
}






//递归：5ms/100%; 41.20mb/5.04%
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }
}
