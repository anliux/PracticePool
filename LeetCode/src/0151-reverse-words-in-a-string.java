//0151-翻转字符串里的单词
//思路：库函数；一次翻转；两次翻转；


//库函数+一次翻转：4 ms/41.20%; 41.1 MB/90.32%
//用了很多库函数，没体现出算法功底
class Solution {
    public String reverseWords(String s) {
        //拆分-倒序组合-转化为String返回

        //拆分
        String[] strs = s.trim().split(" +");

        //初始化可变字符串
        StringBuilder sb = new StringBuilder();

        //倒序遍历
        for(int i = strs.length-1; i >= 0; i--){
            sb.append(strs[i]).append(" ");
        }

        //转换后返回：如果遍历没有判定，这里转换后修剪掉多加的空格
        return sb.toString().trim();
    }
}


//双指针+一次翻转：没用split(), 手动空格处理：2 ms/74.62%; 41.3 MB/60.90%
class Solution {
    public String reverseWords(String s) {
        //双指针步骤：一次翻转，手动处理空格

        //初始化：两指针和可变字符串
        int i = s.length() - 1;
        int j = i;
        StringBuilder sb = new StringBuilder();

        //倒序遍历：
        while(i>=0){
            //小指针向左找第一个空格
            while(i>=0 && s.charAt(i)!=' ')//注意此处空格用单引号，下同
                i--;

            //将大小指针之间的子串添加到sb
            sb.append(s.substring(i+1,j+1)).append(" ");

            //小指针继续向左找第一个非空格：越过所有空格
            while(i>=0 && s.charAt(i)==' ')
                i--;

            //更新大指针
            j=i;
        }

        //返回结果：转换并返回，记得再次枝剪避免前后多空格
        return sb.toString().trim();
    }
}




//其他：
//两次翻转：13ms，击败20%的用户
/*
- 算法1：两次翻转
    - 定义翻转指定索引值的字符串的函数并定义为私有；
    - 首先处理空格：剪去所有空格后，将字符串数组重新用一个空格连起来；
    - 将字符串转为字符数组；
    - 定义双指针：大指针遍历并找空格，小指针为要翻转单词的首个索引；
    - 遍历：翻转每个单词；
    - 翻转整个字符串；
    - 返回：新建字符串，并将字符数组传入。
*/
class Solution {
    public String reverseWords(String s) {
        //首先处理空格，然后再用一个空格将字符串拼起来
        //注意：split(" +")可以剪去多个空格
        String [] words = s.trim().split(" +");
        String str = String.join(" ", words);

        //将str字符串转为字符数组，然后遍历字符串，翻转每个单词
        char[] chars = str.toCharArray();
        int n = chars.length;

        //定义两个指针来控制翻转范围
        int i = 0, j = 0; //i和j为每个单词的起止索引，j遍历至n
        while(j <= n){
            //判断大指针j是否遇到空格或者遍历完成：如果是则翻转，并更新小指针
            //注：j要检测空格，指向的是要翻转的范围的前一个索引值
            if(j == n || chars[j] == ' '){
                reverse(chars, i, j-1);
                i = j + 1;
            }

            //大指针j每次循环都要向后移动
            j++;

        }

        //翻转整个字符串
        reverse(chars, 0, n-1);

        //将字符数组转为字符串并返回
        //注：用toString不好使，会返回哈希码
        return new String(chars);
    }

    //定义翻转指定索引的字符数组的函数reverse: 引用型变量，返回值为void即可
    private void reverse(char[] chs, int i, int j){
        while(i<j){
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
    }
}



//直接一次翻转：感觉没啥问题但是超出时间限制。
class Solution {
    public String reverseWords(String s) {
        //首先处理空格，然后再用一个空格将字符串拼起来
        //注意：split(" +")可以剪去多个空格
        String [] words = s.trim().split(" +");

        //定义双指针：
        int left = 0, right = words.length-1;
        
        //遍历字符串，翻转每个单词
        while(left < right){
            String tmp = words[left];
            words[left] = words[right];
            words[right] = tmp;
        }
        
        return String.join(" ", words);
    }
}
