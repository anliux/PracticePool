//0034-在排序数组中查找元素的第一个和最后一个位置
//思路：二分
//注：参考剑指offer-第53.1题：在排序数组中查找数字，从target数字出现次数角度求解。



//二分：0ms，击败100%的用户

/*

  - 算法：
    - 初始化边界指针为数组的左右端点；
    - 两次二分；
      - 不等时，同二分处理；
      - nums[mid]与target相等时：
        - 右边界：在mid对应元素的右侧，因此小指针更新为mid+1；
        - 左边界：在mid对应元素的左侧，因此大指针更新为mid-1；
        - 注：这种区别可以通过<=的等于号，并配合if-else实现。
    - 判空：根据左右边界值索引求长度，若为0，则target不存在，返回{-1,-1}
    - 新建数组，并将最终的左右边界索引传入后返回；
    - 注：target不存在的情况会返回0，符合预期结果。

*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        //初始化左右指针
        int left = 0, right = nums.length - 1;

        //第一次二分：找到右边界
        while(left<=right){
            int mid = (left + right) / 2;
            if(nums[mid] <= target)
                left = mid + 1;
            else 
                right = mid - 1;
        }

        //保存右边界的值
        int end = right;

        //再次初始化
        left = 0;
        right = nums.length - 1;

        //第二次二分：找到左边界
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        //保存左边界的值
        int start = left;

        //判断长度是否为0
        if((end - start + 1) == 0)
            return new int[]{-1, -1};

        //返回结果数组
        return new int[]{start, end};
    }
}
