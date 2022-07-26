//21-调整数组顺序使奇数位于偶数前面
//思路：双指针


//双指针：1ms/100%; 49.4 MB/24.95%
class Solution {
    public int[] exchange(int[] nums) {
        //判空：数组为空或数组长度为0时返回原数组

        //初始化
        int low = 0, high = nums.length - 1, temp;

        //循环：直到两指针相遇
        //小指针向后找偶数，大指针向前找奇数
        while(low < high){
            //小指针遍历
            while((low < high) && (nums[low] & 1 ) == 1) //为奇数时继续向前
                low++;

            //大指针遍历
            while((low < high) && (nums[high] & 1) == 0) //为偶数时继续向后
                high--;
            
            //注：==的优先级高于&&，因此需要加括号，不清楚优先级的一律加括号。
          
            //两指针交换
            temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        }

        //返回结果数组
        return nums;
    }
}
