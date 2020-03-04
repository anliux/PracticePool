//0011-盛最多水的容器
//思路：暴力法；双指针



//暴力法：437ms，击败9.72%的用户
//算法：定义最大面积max；两层循环：外层控制起始基准，内层控制从基准到末尾的所有可能情况，计算并更新最大值；返回结果max。
class Solution {
    public int maxArea(int[] height) {
        //定义面积最大值max并初始化
        int max = 0;

        //两层循环：外循环控制起始基准，内循环控制从基准到末尾的所有可能情况
        for(int i = 0; i < height.length; i++){
            for(int j = i+1; j < height.length; j++){
                //求当前i和j所构成的矩形面积，并与max比较，将max更新为其中最大的
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }

        //返回结果max
        return max;
    }
}



//双指针法：
/*
    算法：
      - 定义双指针left和right，以及面积最大值max并初始化；
      - 循环直到两指针交错：计算当前指针构成的面积，并对max更新，然后移动较小的指针；
      - 最后返回结果max。
*/
class Solution {
    public int maxArea(int[] height) {
        //定义最大面积max，以及头尾指针
        int max = 0;
        int left = 0, right = height.length - 1;

        //循环：头尾指针分别从两边逼近，直到相遇（不包含相等，因为需要构成矩形）
        while(left < right){
            //定义此时两指针构成的矩形面积：x轴距离 * 较小的y轴
            int area = (right - left) * Math.min(height[left], height[right]);

            //更新最大面积max
            max = Math.max(max, area);

            //更新较小的数组值对应的指针，以便找到更高的height[i]
            if(height[left] < height[right])
                left++;
            else 
                right--;
        }

        //最后返回结果max
        return max;
    }
}
