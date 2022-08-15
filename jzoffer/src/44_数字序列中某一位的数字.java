//44. 数字序列中某一位的数字



//数学题找规律：0ms/100%; 38.5 MB/19.30%
class Solution {
    public int findNthDigit(int n) {
        //初始化：位数digit，位数开始数字start，所有位数统计count -- 注意范围
        int digit = 1;
        long start = 1;
        long count = 9;

        //找到所在位数digit：遍历
        while(n>count){
            n -= count;
            digit += 1;
            start *= 10;
            count = 9 * start * digit;
        }

        //得到n所在的数字：整除
        long num = start + (n-1)/digit;

        //确定所求数位在 num 的哪一数位: long -- String -- char[] -- 获取某个字符
        return Long.toString(num).charAt((n-1)%digit) - '0';
    }
}
