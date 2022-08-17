//48 - 最长不含重复字符的子字符串
//思路：暴力法；滑动窗口



//滑动窗口：4 ms/91.74%; 41.7 MB/32.55%
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口：左开右闭

        //初始化：结果res，左指针left
        int res = 0, left = -1;

        //初始化哈希表map
        HashMap<Character, Integer> map = new HashMap<>();

        //右指针遍历：
        for(int right = 0; right < s.length(); right++){
            //如果对应字符已包含在哈希表中，则更新左指针
            if(map.containsKey(s.charAt(right)))
                left = Math.max(left, map.get(s.charAt(right)));

            //每次更新right对应字符的最新位置到哈希表
            map.put(s.charAt(right), right);

            //每次更新res
            res = Math.max(res, right-left);
        }

        //返回结果
        return res;
    }
}
