//0013-罗马数字转整数
/*
思路：
- 多个字符对应不同的数字，考虑“查表法”，可用哈希表 或者 “switch”
- 比较相邻两个字符，若高位不小于低位，直接相加；否则，要用低位的大数减去高位的小数。
- 将每位对应的数字累加：可以从高位到低位，即从字符串的0到length-1
*/



class Solution {
    public int romanToInt(String s) {
        //定义变量，保存求和的值，并初始化为0
        int sum = 0;

        //针对相邻两字符，分别定义变量pre和num表示左和右的两个数
        //其中pre在循环外初始化为字符串第一个字符对应的数字，并在循环内依次向右移动；
        //num在循环内初始化
        int pre = getValue(s.charAt(0));

        //循环遍历字符串s
        //循环时为避免混乱，只对pre进行累加，并在最后将pre值更新为原num，即向右移动一下
        for(int i=1; i<s.length(); i++){
            //初始化num为字符串第i个字符对应的数字，并且从第二个位置，即i=1开始循环
            int num = getValue(s.charAt(i));

            //对相邻两个字符对应的数字进行比较
            //特殊情况：当前一个值小，则累加时前一个值变为负数；其他情况直接累加
            if(pre < num){
                sum -= pre;
            }else{
                sum += pre;
            }

            //将pre向右移动，更新为原num的值
            pre = num;
        }

        //因为循环的是后一个位置i，而循环累加的是pre，因此循环结束后，还需要把最后一个pre手动累加到sum
        sum += pre;

        //最终返回sum的值即可
        return sum;
    }

    //将匹配功能写为私有函数封装
    private int getValue(char ch){
        switch(ch){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default: return 0;
        }
    }
}