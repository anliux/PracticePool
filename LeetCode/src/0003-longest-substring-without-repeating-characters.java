//0003-无重复字符的最长子串
//思路：暴力法；滑动窗口



//暴力法：超时
/*
   - 算法：
      - 定义判断左闭右开区间内是否符合各个字符唯一的函数allUnique；
      - 主函数内定义结果变量res并初始化为0；
      - 两层循环：外循环定义起始基准，内循环定义基准起到末尾的所有子串，并调用allUnique函数判断，为真时与res比较并将res更新为其中的最大值；
      - 返回res。
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //定义结果并初始化
        int res = 0;

        //遍历字符串：外循环控制起点基准，内循环控制以基准起到末尾的所有子字符串
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){//包括等于，因为左闭右开
                if(allUnique(s, i, j))
                    res = Math.max(res, j-i);
            }
        }

        return res;
    }

    private boolean allUnique(String s, int start, int end){//左闭右开
        //定义set：利用set元素的唯一性判断
        Set<Character> set = new HashSet<>();

        //遍历：左闭右开
        for(int i = start; i < end; i++){
            Character chs = s.charAt(i);
            if(set.contains(chs))
                return false;
            set.add(chs);
        }

        return true;
    }
}



//滑动窗口：
/*

    - 滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 i到j（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 i-j左闭右开 向右滑动 1 个元素，则它将变为 i+1到j+1（左闭，右开）。
    
    - 分析：
      - 使用 HashSet 将字符存储在当前窗口  i到j 左闭右开（最初 j=i）中。 然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 i 开头。如果我们对所有的 i 这样做，就可以得到答案。
      - 优化：使用哈希map，如果 s[j] 在 i到j左闭右开 范围内有与 j' 重复的字符，我们不需要逐渐增加 i ，直接跳过 [i，j′] 范围内的所有元素，并将 i 变为 j′+1。
      - HashMap：记录char的位置+1，便于窗口start位置的滑动
   
   - 分析：
      - 定义一个 map 存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
      - 定义不重复子串的开始位置为 start，结束位置为 end
      - 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
      - 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
   
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
        //定义结果变量res，以及用于存储 char-value 哈希表
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        //遍历字符串
        for(int start = 0, end = 0; end < s.length(); end++){
            char chs = s.charAt(end);
            
            if(map.containsKey(chs)){
                start = Math.max(start, map.get(chs));
            }
            
            res = Math.max(res, end-start+1);
            
            //HashMap：记录char的位置+1，便于窗口start位置的滑动
            map.put(s.charAt(end), end+1);
        }

        //返回结果res
        return res;
    }
}
