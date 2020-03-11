//0153-寻找旋转排序数组中的最小值
//思路：暴力法；排序；二分。



//暴力法：0ms，击败100%的用户
/*
算法：定义最小值；遍历数组并更新最小值；返回最小值。
*/
class Solution {
    public int findMin(int[] nums) {
        //暴力法：定义最小值变量；遍历数组并更新最小值；返回最小值
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}



//排序：2ms，击败25.39%的用户
/*
  - 算法：Arrays.sort()排序；返回索引为0的元素。
  - 注：这种方法代码两行，但是时间复杂度高于暴力法。
*/
class Solution {
    public int findMin(int[] nums) {
        //先排序后取索引为0的值
        Arrays.sort(nums);
        return nums[0];
    }
}



//二分：0ms，击败100%的用户
/*
  - 算法：
      - 定义双指针；
      - 左右指针不相等时遍历数组：取mid，比较mid对应元素与right对应元素，mid大则left=mid+1，mid小则right=mid；
      - 返回left对应元素(right也行，因为最后两个指针相等了)。
*/
class Solution {
    public int findMin(int[] nums) {
        //定义左右指针
        int left = 0, right = nums.length - 1;

        //循环：直到左右指针相遇
        while(left < right){
            //定义中间值mid
            int mid = (left + right) / 2;
            
            //对mid对应值与righ对应值进行比较
            if(nums[mid] > nums[right]) //当mid位于大数组
                left = mid + 1;
            else if(nums[mid] < nums[right]) //当mid位于小数组
                right = mid;
        }

        //返回左指针对应元素
        return nums[left];
    }
}
