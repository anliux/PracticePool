//0167-两数之和II-输入有序数组
//思路：双指针与二分的结合



//耗时：
/*
    - 算法：判空；定义两变量作为左右指针并初始化；循环直到(a<b)不再成立：比较sum与target并移动指针；最后返回null。
    - 循环条件(a<b)：题目要求index1必须小于index2
    - 找到时返回数组的索引值要+1：题目要求返回的下标值（index1 和 index2）不是从零开始的，是从1开始的。
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //判空
        if(numbers == null)
            return null;
        
        //定义两指针并初始化
        int left = 0, right = numbers.length - 1;

        //循环：直到left不再小于right，不包含等于
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target)
                return new int[] {left+1, right+1};
            else if(sum > target)
                right--;
            else
                left++;
        }

        //循环结束后仍未找到，则返回空
        return null;
    }
}
