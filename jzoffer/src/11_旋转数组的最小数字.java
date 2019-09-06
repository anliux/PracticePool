//11 - 旋转数组的最小数字
//思路1：暴力搜索最小值
//思路2：暴力搜索是否符合非降序
//思路3：排序
//思路4：二分+暴力搜索


//思路1：暴力搜索最小值
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int n = array.length;
        int res = array[0];
        for(int i=0; i<n-1; i++)
        {
            if(array[i+1]<array[i])
                res = array[i+1];
        }
        return res;
    }
}


//思路2：暴力搜索是否符合非降序
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        //前后两段数组都是非降序，当出现不符合这个规律的情况时，返回下一个
        //此时把相等的情况也考虑进来了
        int n = array.length;
        if(n==0)
            return 0;
        for(int i=0; i<n; i++)
        {
            if(array[i]>array[i+1])
                return array[i+1];
        }
        return array[0]; //若遍历结束仍符合前小后大规律，说明未旋转，返回第一个值
    }
}


//思路3：排序
//注意：import 使用默认的话不能用sort的
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