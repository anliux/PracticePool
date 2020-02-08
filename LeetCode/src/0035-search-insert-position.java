//35-搜索插入位置
//思路：暴力法；二分



//暴力法：0ms，击败100%的用户
//遍历数组，依次比较
//投机取巧，数量级一旦上去，时间复杂度就会很高。
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] < target){
                i++;
            }else{
                break;
            }
        }
        return i; 
    }
}



//二分：超时
//注：代码应该是没有问题，竟然超时我惊了
class Solution {
    public int searchInsert(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;

        if(nums[min] > target)
            return 0;
        else if(nums[max] < target)
            return max + 1;
        
        //循环，直到min与max交叉（相等的情况仍可以继续）
        while(min <= max){
            int mid = (max + min) >> 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                min = mid + 1;
            else
                max = mid - 1;
        }
        
        //无论是否存在，循环结束后返回的都是min对应的索引
        return min;
    }
}

//补一个强行“二分查找”：使用Arrays的内置函数
class Solution {
    public int searchInsert(int[] nums, int target) {
        int a = Arrays.binarySearch(nums, target);
        if(a<0)
            a = - a - 1;
        return a;
    }
}