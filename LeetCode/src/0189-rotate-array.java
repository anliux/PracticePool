0189-rotate-array.java

//189-旋转数组
//思路：暴力法；额外数组；环状替换；反转。



//暴力法：266ms，击败5%的用户
//算法：定义两个变量；两层循环：外层控制k，把末尾元素存起来，内层控制遍历数组，内层循环中进行交换。
class Solution {
    public void rotate(int[] nums, int k) {
        //定义外层循环和内层循环的临时存储变量
        int pre, tmp;

        //循环：外层控制移动位置数k，内层控制遍历整个数组
        for(int i = 0; i < k; i++){
            //将数组末尾的元素存在pre中，并在遍历过程中交换pre与nums[i]
            pre = nums[nums.length - 1];
            for(int j = 0; j < nums.length; j++){
                tmp = nums[j];
                nums[j] = pre;
                pre = tmp;
            }
        }
    }
}



//额外数组：1ms，击败78.4%的用户
//算法：定义辅助数组；一次遍历：以正确位置顺序将数据存入辅助数组；二次遍历：将辅助数组的数据按照位置移动到原数组。
class Solution {
    public void rotate(int[] nums, int k) {
        
        
        //定义辅助数组arr
        int [] arr = new int[nums.length];

        //第一次遍历：将数组元素移动到正确的位置
        for(int i=0; i<nums.length; i++){
            arr[(i+k) % nums.length] = nums[i];
        }

        //第二次遍历：将辅助数组的元素按位置搬运到原数组
        for(int j=0; j<nums.length; j++){
            nums[j] = arr[j];
        }
    }
}



//
