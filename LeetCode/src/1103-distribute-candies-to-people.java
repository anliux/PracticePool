//1103-分糖果II
//思路：暴力法；数学法



//暴力法：3ms，击败8.1%的用户
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        //定义结果数组
        int[] res = new int[num_people];

        //初始化循环的指标
        int i = 0;
        
        //循环：直到candies数量为0
        while(candies > 0){
            //从i=1开始，将其存入数组res中，数组存在累加
            //取余调转起始，min处理candies不足
            res[i % num_people] += Math.min(candies, i+1);
            candies -= Math.min(candies, i+1);
            i++;
        }

        //返回结果数组res
        return res;
    }
}



//数学法：推导过程过于复杂，此处先略。
