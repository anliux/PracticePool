/*
05-替换空格

注意：
str的各种函数；
str.charAt()获取到的是字符型，用单引号；
str.setCharAt(int, char)中Char的C大写
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
