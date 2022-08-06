//33. 二叉搜索树的后序遍历序列


//递归分治：0 ms/100.00%; 39.1 MB/31.42%
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int left, int right){
        //ps：题目已假设输入的数组的任意两个数字都互不相同
        
        //递归出口：当left与right交错或相等，即此树结点<=1
        if(left>=right)
            return true;
        
        //定义当前指针cur，从最左侧的left开始遍历
        int cur = left;

        //向右遍历找到右子树边界：第一个值大于根结点的结点
        while(postorder[cur] < postorder[right])
            cur++;


        //获取右子树边界值
        int mid = cur;


        //继续向右直到尽头：判断右子树是否都符合大于结点值
        while(postorder[cur] > postorder[right])
            cur++;

        //判断结点 + 递归：如果上面的循环结束之后cur走到了最后结点，说明右子树结点都符合
        //递归：右子树的右边界记得 -1，减去根结点
        return cur==right && recur(postorder,left,mid-1) && recur(postorder,mid,right-1);

    }
}
