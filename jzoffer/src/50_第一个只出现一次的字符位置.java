//50 - 第一个只出现一次的字符位置
//思路：暴力法；哈希表法。
//哈希表优化时间复杂度；用数组实现哈希表。

//力扣说明：”s 只包含小写字母。“



//哈希表法：只包含小写 30 ms/14.71%; 41.7 MB/70.31%
class Solution {
    public char firstUniqChar(String s) {
        //哈希表：字符-次数对，两次遍历

        //初始化：哈希表
        HashMap<Character, Integer> map = new HashMap<>();

        //第一次遍历：存入哈希表
        for(int i = 0; i < s.length(); i++){
            char chs = s.charAt(i);
            if(map.containsKey(chs))
                map.put(chs, map.get(chs)+1);
            else
                map.put(chs,1);
        }

        //第二次遍历：找第一个为1的字符
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }

        //找不到时，返回false标志单空格' ', 注意不是空字符是单个空格
        return ' ';
    }
}



//数组替代哈希表法：5 ms/88.08%; 41.7 MB/74.38%
class Solution {
    public char firstUniqChar(String s) {
        //用数组替代哈希表

        //初始化数组：注意对应的是26个字母的坑位，不是字符串s的长度
        char[] chs = new char[26];

        //第一次遍历：存表
        for(int i = 0; i < s.length(); i++){
            chs[s.charAt(i) - 'a'] += 1;//注意：和字符'a'的差值，不是和数字
        }

        //第二次遍历：查找并返回结果
        for(int i = 0; i < s.length(); i++){
            if(chs[s.charAt(i) - 'a'] == 1)
                return s.charAt(i);
        }

        //返回找不到的结果
        return ' ';
    }
}


//哈希表法（字母，不是小写字母）：7ms，击败83.42%的用户
class Solution {
    public char firstUniqChar(String s) {
        //定义数组
        int[] words = new int[58];

        //第一次遍历：计数
        for(int i = 0; i < s.length(); i++){
            words[s.charAt(i) - 'A'] += 1;
        }

        //第二次遍历：遍历字符串，寻找对应数组值等于1的字符
        for(int i = 0; i <s.length(); i++){
            if(words[s.charAt(i) - 'A'] == 1)
                return s.charAt(i);
        }

        //找不到时，返回空串，单引号
        return ' ';
    }
}
