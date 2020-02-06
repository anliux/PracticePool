//0020-有效的括号
//思路：暴力法；栈
//暴力法：思路简单，检测并替换成对括号为空串，最后判断字符串是否为空；但耗时过长
//栈：借鉴栈的应用中对四则运算的处理，成对弹出


//暴力法：
/*
   算法：
   - 每次检测是否有最里侧的成对某种括号，若有，则替换所有成对括号为空字符串，直到检测不到相邻的成对括号
    - 遍历完成后，如果是有效表达式，则最后的字符串会只剩下空串，判断是否==空串
    - 法一：在while小括号中判断：
      - while每次判断是否有相邻括号，如果有，则进入循环并进行替换操作
      - 不用先判断是否为空，因为while判断包含
    - 法二：在while的循环体中判断：
      - while(true)无限循环替换动作并在最后判断字符串长度是否改变，如果没有，break。
      - 需要先判断是否为空，否则直接进入while循环
    - 法二比法一稍快
      - 经测试，法一超出时间限制，法二耗时100ms，超过5%的用户
*/

//暴力法1：超时
class Solution {
    public boolean isValid(String s) {
        while(s.contains("()") || s.contains("[]") || s.contains("{}")){
            //判断写在循环条件中，则每次循环都进行三次判断
			s.replace("()","");
            s.replace("[]","");
            s.replace("{}","");
        }
		//找不到相邻的成对括号时，检查字符串是否为空，为空则为有效，否则无效
        return s.length() == 0;
    }
}

/*
注：Python代码未超时

class Solution:
    def isValid(self, s):
        while '{}' in s or '()' in s or '[]' in s:
            s = s.replace('{}', '')
            s = s.replace('[]', '')
            s = s.replace('()', '')
        return s == ''


*/



//暴力法2：耗时100ms，超过5%的用户
class Solution {
    public boolean isValid(String s) {
        //因为循环为true，因此循环前进行一次判断，避免不符合条件但直接进入循环造成浪费
		if(s.isEmpty())
            return true;

        while(true){
			//设置一个flag对字符串在替换前后的变化进行监测
            int length = s.length();

            s = s.replace("()","");
            s = s.replace("[]","");
            s = s.replace("{}","");
			
			//针对上述方法进行简化，将判断过程放在循环体中，减少了时间复杂度
            if(length == s.length())
                break;
        }
        //找不到相邻的成对括号时，检查字符串是否为空，为空则为有效，否则无效
        return s.length() == 0;
    }
}



//栈：耗时3ms，打败58%的用户
/*
    算法：
	- 初始化哈希表 char型
    - 初始化栈 char型
    - 遍历字符串，每次对遍历到的字符进行判断
      - 压栈：遇到开括号，将其推到栈上。
      - 弹栈：否则，当栈非空，且当前字符串的字符与栈顶元素配对成功时，弹栈
      - 无效：否则，表达式无效。
    - 最后，若栈非空，则表达式无效。
*/
class Solution {
    public boolean isValid(String s) {
        
        //首先对一定true或一定false的情况进行判断
        if(s == null || s.length() == 0)
            return true;
        if(s.length() % 2 != 0)
            return false;
        
        //创建哈希表并初始化
        Map<Character, Character> map = new HashMap<>();
        //后期如果想要根据key找是否存在对应的value，最好key右括号，value左括号
        //注意：如果定义为char类型，要用单引号
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        //创建栈并初始化
        Stack<Character> stack = new Stack<>();

        //遍历字符串s并依次判断：符合条件的分别压栈弹栈，不符合条件的return false
        for(int i=0; i<s.length(); i++){
            //压栈的情况：当字符串遍历到左边括号时，可以进栈
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            //弹栈的情况：栈非空，且当前字符串的字符与栈顶元素配对成功时，弹栈
            else if(!stack.empty() && ( map.get(s.charAt(i)) == stack.peek() ) ){
                stack.pop();
            }
            //非法的情况：否则，返回false
            else
                return false;
        }

        //遍历结束后，若栈非空，返回false
        return stack.empty();
    }
}