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



//滑动窗口：4 ms/86.75%; 41.8 MB/30.84%
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口：左开右闭

        //初始化：结果变量res，左指针left
        int res = 0, left = -1;

        //初始化哈希表map
        HashMap<Character, Integer> map = new HashMap<>();

        //右指针遍历：
        for(int right = 0; right < s.length(); right++){
            //如果对应字符已包含，则更新左指针指向重复字符
            if(map.containsKey(s.charAt(right)))
                left = Math.max(left, map.get(s.charAt(right)));

            //每次将右指针对应字符存入哈希表
            map.put(s.charAt(right), right);

            //更新res
            res = Math.max(res, right-left);
        }

        //返回结果
        return res;
    }
}
