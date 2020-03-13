//05-替换空格
//思路：库函数；

/*
注意：
str的各种函数；
str.charAt()获取到的是字符型，用单引号；
str.setCharAt(int, char)中Char的C大写
*/



//库函数：0ms，击败100%的用户
//算法：直接返回replace后的字符串s。
class Solution {
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
}



//新建字符串：0ms，击败100%的用户
/*
    - 算法：
      - 初始化一个可变字符串 StringBuilder ，记为 res ；
      - 将字符串s转为字符数组chars；
      - 遍历字符数组中的每个字符，并添加到res字符串：
        - 当 c 为空格时：向 res 后添加字符串 "%20"；
        - 当 c 不为空格时：向 res 后添加字符 c ；
      - 将 res 转化为 String 类型并返回。
    - 注：如果要求不能开辟额外空间时，这种方法就行不通了。
*/
class Solution {
    public String replaceSpace(String s) {
        //新建可变字符串res
        StringBuilder res = new StringBuilder();

        //将字符串s转为字符数组chars
        char[] chars = s.toCharArray();

        //遍历字符数组，并添加元素到字符串res
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == ' ')
                res.append("%20");
            else
                res.append(chars[i]);
        }

        return res.toString();
    }
}



//修改原字符串：
/*
  - 算法：
      - 定义指针p1指向原有字符串的末尾：p1从末尾遍历原字符串；
      - 遍历字符串，每一个空格，添加两个空格到原字符串；
      - 定义指针p2指向增加两倍空格数之后的字符串的末尾：p2从末尾更新字符串，并添加`%20`到字符串中；
      - 循环：直到 -- 原字符串遍历完成(`p1>=0`) 或 更新后字符串追上原字符串(`p2>p1`)
        - 判断是否是空格
      - 返回toString()。
    
  - 注：本方法太别扭了，为了省一点空间，走了很多弯路。不如重新开辟空间后操作了。
    
  - 注意：下述牛客代码中的参数是`StringBuffer str`，而LeetCode中的参数是String类型
*/
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	int p1 = str.length() - 1; //定义原始末尾的位置
		for (int i=0; i<=p1; i++) //遍历并统计空格数，每有一个空格则新增两个位置
			if(str.charAt(i) == ' ')
				str.append("  ");
		int p2 = str.length() - 1; //定义最终末尾的位置
		while (p1>=0 && p2>p1) //循环直到遍历所有或者p2超过p1
		{
			char c = str.charAt(p1--); //定义p1所指向的字符
			if(c == ' ') //判断是空格，则p1前进1，p2前进3并赋值倒着"%20"
			{
				str.setCharAt(p2--, '0');
				str.setCharAt(p2--, '2');
				str.setCharAt(p2--, '%');
			}
			else //判断非空格，则p1，p2各前进1并更新p2赋值
				str.setCharAt(p2--, c);
		}
		return str.toString(); //返回字符串
	}
}
