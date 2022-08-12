//0215-数组中的第K个最大元素
//思路：排序；快排；堆。



//排序：24 ms/25.21%; 48.8 MB/22.25%
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}



//快排分组递归：24 ms/25.21%; 49 MB/17.33%
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //快排分组递归
        return quickSort(nums,k-1,0,nums.length-1);
            //注意：从大到小排序，基准数正好是第k大的数字时，索引值为k-1
    }

    private int quickSort(int[] nums, int k, int left, int right){
        //初始化哨兵指针
        int i = left, j = right;
        //遍历直到哨兵相遇
        while(i<j){//按从大到小排序：大往左，小往右 (快排是从小到大)
            while(i<j && (nums[j] <= nums[left])) j--;//从右向左找第一个大于基准数的元素
            while(i<j && (nums[i] >= nums[left])) i++;//从左向右找第一个小于基准数的元素
            swap(nums,i,j);
        }
        swap(nums,i,left);
        //分为左右两数组：[left, i-1], [i+1,right]
        if(k<i) return quickSort(nums,k,left,i-1);
        else if(k>i) return quickSort(nums,k,i+1,right);
        else return nums[i];
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
