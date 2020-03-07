//0509-斐波那契数
//思路：递归



//递归：0ms，击败100%的用户
/*
  - 本题类似 <70题-爬楼梯>
  - 注意点：爬楼梯与斐波那契数的前几项不同，注意边界值判断
    - 爬楼梯：1，1，2，... f(0)=1, f(1)=1, f(2)= 2,..
    - 斐波那契数列：0，1，1，2，... f(0)=0, f(1)=1, f(2)=1, f(3)=2,...
*/
class Solution {
    public int fib(int N) {
        //斐波那契数列：0，1，1，2，3，...
        //边界值判断
        if(N <= 1)
            return N;

        //初始化前两项
        int first = 1;
        int second = 1;

        //循环：
        for(int i = 2; i < N; i++){
            int sum = first + second;
            first = second;
            second = sum;
        }

        //返回
        return second;
    }
}
