//0263 - 丑数
//思路：数学法



//数学法：1ms，击败100%的用户
/*

  - 算法：
    - 判空：当num小于1时，返回false；
    - while循环：依次整除2，3，5
      - 首先整除取余，当可以整除时，进行整除；
    - 最后进行判断：当最终剩余的数字是1时，证明是丑数；否则，返回false。

*/
class Solution {
    public boolean isUgly(int num) {
        if(num < 1)
            return false;
        
        while(num % 5 == 0)
            num /= 5;
        
        while(num % 3 == 0)
            num /= 3;
        
        while(num % 2 == 0)
            num /= 2;

        return num == 1;
    }
}
