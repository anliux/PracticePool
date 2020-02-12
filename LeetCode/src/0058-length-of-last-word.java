//0058-最后一个单词的长度
//思路：字符串遍历+计数器条件计数



//耗时：0ms，击败100%的用户（不过空间复杂度较高）
class Solution {
    public int lengthOfLastWord(String s) {
        //定义计数器count
        int count = 0;

        //循环：从最后开始遍历字符串s，从非空格开始计数，到空格为止
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) != ' '){ //从非空格开始计数
                count++;
            }
            else if(count != 0){ //当开始计数以后，且再次遇到空格时停止计数并返回
                return count;
            }
        }

        //遍历结束后返回
        return count;
    }
}
