//0108-将有序数组转换为二叉搜索树
//思路：dfs，bfs；中序遍历-mid取中间左、中间右、左右随机


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */



//中序遍历之中间左：1ms，击败26.8%的用户
//始终选择中间位置左边元素作为根节点：向下取整，整除即可
class Solution {
    //定义helper函数
    private TreeNode helper(int[] arr, int left, int right){
        //左索引>右索引时，子树不存在元素，返回空。ps：等于时只有根结点
        if(left > right)
            return null;

        //取中间值，并根据对应的数组元素创建结点
        int mid = left + (right-left)/2; //中间左作为root结点的关键步骤
        TreeNode root = new TreeNode(arr[mid]);

        //调用函数本体构建root结点的子结点，最后返回所构建的root树
        root.left = helper(arr, left, mid-1);
        root.right = helper(arr, mid+1, right);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        //返回调用helper的结果，其中参数为nums数组的索引值范围
        return helper(nums, 0, nums.length-1);
    }
}



//中序遍历之中间右：1ms，击败26.8%的用户
//始终选择中间位置右边元素作为根节点
class Solution {
    //定义helper函数
    private TreeNode helper(int[] arr, int left, int right){
        //左索引>右索引时，子树不存在元素，返回空。ps：等于时只有根结点
        if(left > right)
            return null;

        //取中间值，并根据对应的数组元素创建结点
        int mid = left + (right-left)/2;
        if((right-left)%2==1)   //中间右的关键步骤：奇数时整除会向下取整，而本程序要取右边，因此手动+1
            mid++;              
        TreeNode root = new TreeNode(arr[mid]);

        //调用函数本体构建root结点的子结点，最后返回所构建的root树
        root.left = helper(arr, left, mid-1);
        root.right = helper(arr, mid+1, right);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        //返回调用helper的结果，其中参数为nums数组的索引值范围
        return helper(nums, 0, nums.length-1);
    }
}



//中序遍历之左右随机：1ms，击败26.8%的用户
//选择任意一个中间位置元素作为根节点：被除数是奇数时，随机决定+0或+1
class Solution {
    //定义helper函数
    private TreeNode helper(int[] arr, int left, int right){
        //左索引>右索引时，子树不存在元素，返回空。ps：等于时只有根结点
        if(left > right)
            return null;

        //取中间值，并根据对应的数组元素创建结点
        int mid = left + (right-left)/2;
        
        Random rand = new Random();
        if((right-left)%2==1)
            mid += rand.nextInt(2);  //左右随机关键步骤：奇数时整除会向下取整，而本程序要随机取左右，因此手动随机0或1

        TreeNode root = new TreeNode(arr[mid]);

        //调用函数本体构建root结点的子结点，最后返回所构建的root树
        root.left = helper(arr, left, mid-1);
        root.right = helper(arr, mid+1, right);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        //返回调用helper的结果，其中参数为nums数组的索引值范围
        return helper(nums, 0, nums.length-1);
    }
}
