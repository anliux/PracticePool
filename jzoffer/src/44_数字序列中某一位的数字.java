//44. 数字序列中某一位的数字



//数学题找规律：0ms/100%; 38.5 MB/19.30%
class Solution {
    public int findNthDigit(int n) {
        //初始化：位数digit，每个位数的起始数字start，位数统计count -- 注意范围long
        int digit = 1;
        long start = 1;
        long count = 9;

        /**
                    digit   start   count
        1-9:        1       1       9
        10-99:      10      10      2 * 10 * 9
        100-999:    100     100     3 * 100 * 9
        start-end:  digit   start   digit * start * 9
        */

        //找出所在位数: 遍历，更新参数
        while(n > count){
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }

        //找出所在数字num: 从本位数的start开始计数，从0开始，按digit数切割 (整除得)
        long num = start + (n-1)/digit;

        //找出所在数字的哪一位：long - String - char
        return Long.toString(num).charAt((n-1)%digit) - '0';
    }
}
