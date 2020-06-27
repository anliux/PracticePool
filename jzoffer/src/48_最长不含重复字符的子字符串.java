//48 - 最长不含重复字符的子字符串
//思路：暴力法；滑动窗口



//滑动窗口：6ms，击败88.69%
/*
   - 算法：
      - 初始化结果变量res=0；
      - 定义哈希表map：存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
      - for循环遍历：初始化 开始位置为 start=0，结束位置为 end=0
        - 初始化字符：`char chs = s.charAt(end);` -- 以end对应的字符为基准进行遍历
        - map.containsKey -- 判断chs是否已经存在窗口中
          - 当存在时，更新start的值为start和map.get(key)中的max；
        - 更新res为res和end-start+1中的最大值；
        - map.put(key, value) -- 其中，key表示end对应字符，value为end+1，表示下一个无重复位置，方便get的时候更新start的值。
      - 返回结果变量res。
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //定义结果变量res
        int res = 0;

        //定义哈希表：key表示end索引对应的字符，value表示end+1
        Map<Character, Integer> map = new HashMap<>();

        //滑动窗口：for循环遍历
        for(int start = 0, end = 0; end < s.length(); end++){
            //定义变量chs，并获取end索引值对应的字符
            char chs = s.charAt(end);

            //判断map中是否存在字符chs：若存在，更新start的值
            if(map.containsKey(chs))
                start = Math.max(start, map.get(chs));
            
            //更新res
            res = Math.max(res, end - start + 1);

            //将窗口的右侧字符与对应索引值存入map
            map.put(chs, end + 1);
        }

        //返回结果变量res
        return res;
    }
}
