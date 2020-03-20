//0215-数组中的第K个最大元素
//思路：排序；快排；堆。



//排序：2ms，击败95.17%的用户
//算法：调用Arrays函数排序；获取数组的`(arr.length-k)`个元素并返回。
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}



//
