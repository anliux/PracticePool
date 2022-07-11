//11 - 旋转数组的最小数字
//思路1：暴力搜索最小值
//思路2：暴力搜索是否符合非降序
//思路3：排序
//思路4：二分+暴力搜索
//思路5：二分
//注：暴力法是耗时最少的。



//思路1：暴力搜索最小值
//0ms, 击败100%；41.6M，击败5.19%
class Solution {
    public int minArray(int[] numbers) {
        //暴力法
        int x = numbers[0];
        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] < x)
                x = numbers[i];
        }
        return x;
    }
}



/*  思路2：暴力搜索是否符合非降序
    前后两段数组都是非降序，当出现不符合这个规律的情况时，返回下一个
    此时把相等的情况也考虑进来了
    若遍历结束仍符合前小后大规律，说明未旋转，返回第一个值
*/
//0ms, 击败100%；41.1M，击败69.98% 
class Solution {
    public int findMin(int[] nums) {
        //暴力非降序
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1])
                return nums[i+1];
        }
        return nums[0];
    }
}



//思路3：排序
//注意：import 使用默认的话不能用sort的 (LeetCode可以)
//1ms，击败7.86%；41.8M，击败5.19%
import java.util.*;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        //记得判数组大小为0
        if(array.length==0)
            return 0;
        Arrays.sort(array);
        return array[0];
    }
}


//思路4：二分+暴力搜索
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0)
            return 0;
        int low = 0;
        int high = array.length-1;
        int mid = low;
        while(array[low]>=array[high])
        {
            if(high-low == 1)
            {
                mid=high;
                break;
            }
            mid = (low+high)/2;
            if(array[low]==array[high] && array[low]==array[mid])
            {
                return minNumber(array, low, high);
            }
            //以下两个if若不加=会case通过率0%
            else if(array[mid]>=array[low])
                low = mid;
            else if(array[mid]<=array[high])
                high = mid;            
        }
        return array[mid];
    }
    
    //暴力搜索最小值
    public int minNumber(int[] array, int low, int high)
    {
        int min=array[low];
        for(int i=low; i<high; i++)
        {
            if(array[i+1]<array[i])
                min=array[i+1];
        }
        return min;
    }
}


//思路5：二分
//0ms，击败100%；41.2M，击败49.51%
class Solution {
    public int minArray(int[] numbers) {
        //定义双指针
        int left = 0, right = numbers.length - 1;

        //循环：直到左右指针相遇
        while(left<right){
            //二分
            int mid = (left + right) / 2;
            if(numbers[mid] > numbers[right])//mid位于大数组
                left = mid + 1;//特别注意：这里是mid+1，不是mid，否则会死循环
            else if(numbers[mid] < numbers[right])//mid位于小数组
                right = mid;
            else if(numbers[mid] == numbers[right])//有重复时
                right--;
        }

        //返回结果
        return numbers[left];//这里是left对应元素，不是mid，特别注意
    }
}
