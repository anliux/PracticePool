//50 - 第一个只出现一次的字符位置
//哈希表优化时间复杂度；用数组实现哈希表。

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        //定义存储所有字母的数组，其中索引值为字母对应的int，数组元素为出现次数
        //58:大写65-90，小写97-122，加上中间的91-96，一共58个
        int[] words = new int[58];
        
        //第一次遍历：统计各个字母出现的次数
        for(int i=0;i<str.length();i++){
            words[((int)str.charAt(i))-65] += 1;
        }
        
        //第二次遍历：从第一个字母开始，寻找只出现一次的（出现一次则对于数组值为1）
        //要求返回位置，即索引，为i对应的值
        for(int i=0;i<str.length();i++){
            if(words[((int)str.charAt(i))-65]==1){
                return i;
            }
        }
        
        //如果遍历后没有，返回-1，如题要求。
        return -1;
    }
}