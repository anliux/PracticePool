//53.1 - 数字在排序数组中出现的次数
//思路：两次二分：分别差值左边界和右边界


//暴力法：0ms/100%; 44.1 MB/88.39%
class Solution {
    public int search(int[] nums, int target) {
        //暴力法：
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target)
                count++;
        }
        return count;
    }
}




//两次二分：0ms/100%; 44.7 MB/5.19% 
/*

  - 算法：
    - 初始化边界指针为数组的左右端点；
    - 两次二分；
      - 不等时，同二分处理；
      - nums[mid]与target相等时：
        - 右边界：在mid对应元素的右侧，因此小指针更新为mid+1；
        - 左边界：在mid对应元素的左侧，因此大指针更新为mid-1；
        - 注：这种区别可以通过<=的等于号，并配合if-else实现。
    - 返回左右边界索引值的差值+1；

*/
class Solution {
    public int search(int[] nums, int target) {
        //初始化左右指针
        int left = 0, right = nums.length - 1;
        

        //第一次二分：求右边界
        while(left<=right){
            int mid = (left + right) / 2;
            if(nums[mid] <= target)
                left = mid + 1;
            else 
                right = mid - 1;
        }

        //end指向的是：最后一个target。
        int end = right; 

        //再次初始化左右指针
        left = 0;
        right = nums.length - 1;

        //第二次二分：求左边界
        while(left<=right){
            int mid = (left + right) / 2;
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        //start指向的是：第一个target
        int start = left;


        //返回结果：差值+1为个数
        return end - start + 1;
    }
}
