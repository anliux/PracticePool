//0014-最长公共前缀
//思路：思路：官方题解给了多种方法（水平扫描法，水平扫描，二分，分治，字典树），重点看第一种
/*
    水平扫描法：减法思想
    - 复杂度分析：时间复杂度低（战胜100%），空间复杂度高（战胜14%），相当于空间换时间了
    - 当字符串数组为空时，即长度为0时，即不存在公共前缀，返回空字符串""；
    - 以字符串数组中的第一个元素为基准，遍历整个数组，进行比较；
    - prefix保存当前最长公共前缀，如果prefix不是当前字符串的前缀，则删除最后一个字符再进行比较，一直到prefix变成当前字符串的前缀，或者变成空字符串
    - 注意是求公共前缀，不是最长公共子序列，因此可以从后面减，也是while判0的原因
*/



//水平扫描法：
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //当字符串数组为空时，符合不存在公共前缀，返回空字符串
        if(strs.length == 0)
            return "";
        
        //以字符串数组第一个元素为基准进行比较
        String prefix = strs[0];

        //遍历字符串数组：从i=1，即数组的第二个元素开始遍历
        for(int i=1; i<strs.length; i++){
            /*
            prefix保存当前最长公共前缀
            如果prefix不是当前字符串的前缀，则删除最后一个字符再进行比较，
            一直到prefix变成当前字符串的前缀，或者变成空字符串
            注意是求公共前缀，不是最长公共子序列，因此可以从后面减，也是while判0的原因
            */
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
                    //上面的length是数组的，不加小括号；这里是字符串的，要加小括号
                if(prefix.isEmpty())
                    //判断字符串是否为空的布尔型返回值，等同于`string.length()==0`
                    return "";
            }
        }

        return prefix;
    }
}