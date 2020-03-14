# OJ输入输出练习




# 类 Scanner

- 导包：`import java.util.Scanner;`

- 一个可以使用正则表达式来解析基本类型和字符串的简单文本扫描器。

- Scanner 使用分隔符模式将其输入分解为标记，默认情况下该分隔符模式与空白匹配。然后可以使用不同的 next 方法将得到的标记转换为不同类型的值。

- 除非另行说明，否则将一个 null 参数传递到 Scanner 的任何一个方法中都将抛出 NullPointerException。   
     
- 默认情况下扫描器会将数字解释为十进制形式，除非已经使用 useRadix(int) 方法设置了不同的基数。不管以前是否更改，reset() 方法将把扫描器的基数重置为10 。



# 常用方法
## 判断输入中是否存在某某：布尔型

- ### hasNext()：
  - 如果此扫描器的输入中有另一个标记，则返回 true。

- ### hasNext(Pattern pattern)：
  - 如果下一个完整标记与指定模式匹配，则返回 true。
          
- ### hasNextInt()：
  - 如果通过使用 nextInt() 方法，此扫描器输入信息中的下一个标记可以解释为默认基数中的一个 int 值，则返回 true。      
          
- ### hasNextXxx():
  - 格式同hasNextInt()，指定为其他类型。
  
- ### hasNextLine()：
  - 如果在此扫描器的输入中存在另一行，则返回 true。
  
  
## 从输入中取数据：类型为String或指定类型         
          
- ### String next()：
  - 查找并返回来自此扫描器的下一个完整标记。
          
- ### int nextInt()：
  - 将输入信息的下一个标记扫描为一个 int。   
  
- ### xxx nextXxx()：
  - 同nextInt()，指定为其他类型。
          
- ### String nextLine()：
  - 此扫描器执行当前行，并返回跳过的输入信息。
          
- ### String toString()：
  - 返回此 Scanner 的字符串表示形式
          
    

# 读取数据示例
- ### 从 System.in 中读取一个数：

     ```java
     Scanner sc = new Scanner(System.in);
     int i = sc.nextInt();
     ```
     
     
- ### 使 long 类型可以通过 myNumbers 文件中的项分配：
      
      ```java
      Scanner sc = new Scanner(new File("myNumbers"));
      while (sc.hasNextLong()) {
          long aLong = sc.nextLong();
      }
      ```
      
      
- ### 使用不同于空白的分隔符。比如：从一个字符串读取若干项：

     ```java
     String input = "1 fish 2 fish red fish blue fish";
     Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
     System.out.println(s.nextInt());
     System.out.println(s.nextInt());
     System.out.println(s.next());
     System.out.println(s.next());
     s.close(); 
     ```
     
     - 输出为：
     ```
     1
     2
     red
     blue 
     ```


- ### 使用正则表达式同时解析所有的 4 个标记，并可以产生与上例相同的输出结果：
     
     ```java
     String input = "1 fish 2 fish red fish blue fish";
     Scanner s = new Scanner(input);
     s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
     MatchResult result = s.match();
     for (int i=1; i<=result.groupCount(); i++)
         System.out.println(result.group(i));
     s.close(); 
     ```
     
         

# 代码示例
## a+b(1) 
- ### 题目描述
  - 计算a+b
  - 输入描述: 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。
  - 输出描述: 输出a+b的结果
  - 示例1：
    - 输入：1 5 / 10 20
    - 输出：6 / 30

- ### 代码
     ```java
     import java.util.Scanner;
     public class Main{
         public static void main(String args[]){
             Scanner sc = new Scanner(System.in);
             while(sc.hasNext()){
                 int a = sc.nextInt();
                 int b = sc.nextInt();
                 System.out.println(a+b);
             }

         }
     }

     ```



## a+b(2)
- ### 题目描述
  - 计算a+b
  - 输入描述: 输入第一行包括一个数据组数t(1 <= t <= 100)，接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)
  - 输出描述: 输出a+b的结果
  - 示例1：
    - 输入：2 / 1 5 / 10 20
    - 输出：6 / 30

- ### 代码
     ```java
     import java.util.Scanner;
     public class Main{
         public static void main(String args[]){
             Scanner sc = new Scanner(System.in);
             int line = sc.nextInt();
             for(int i = 0; i < line; i++){
                 int a = sc.nextInt();
                 int b = sc.nextInt();
                 System.out.println(a+b);
             }
         }
     }
     ```




## a+b(3)
- ### 题目描述
  - 计算a+b
  - 输入描述: 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据有多组, 如果输入为0 0则结束输入
  - 输出描述: 输出a+b的结果
  - 示例1：
    - 输入: 1 5 / 10 20 / 0 0
    - 输出: 6 / 30

- ### 代码
     ```java
     import java.util.Scanner;

     public class Main{
         public static void main(String args[]){
             Scanner sc = new Scanner(System.in);
             while(true){
                 int res = sc.nextInt()+sc.nextInt();
                 if(res == 0)
                     return;
                 System.out.println(res);
             }
         }
     }
     ```



## a+b(4)
- ### 题目描述
  - 计算计算一系列数的和
  - 输入描述: 输入数据包括多组。
    - 每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
    - 接下来n个正整数,即需要求和的每个正整数。
  - 输出描述: 每组数据输出求和的结果
  - 示例1：
    - 输入: 4 1 2 3 4 / 5 1 2 3 4 5 / 0
    - 输出: 10 / 15
  
- ### 代码
     ```java
     import java.util.Scanner;

     public class Main{
         public static void main(String args[]){
             Scanner sc = new Scanner(System.in);
             while(true){
                 int lens = sc.nextInt();
                 if(lens == 0)
                     return;
                 int sum = 0;
                 for(int i = 0; i < lens; i++){
                     sum += sc.nextInt();
                 }
                 System.out.println(sum);
             }
         }
     }
     ```
  


## a+b(5)
- ### 题目描述
  - 计算a+b
  

- ### 代码
     ```java
     import java.util.Scanner;

     public class Main{
         public static void main(String args[]){
             Scanner sc = new Scanner(System.in);
             int t = sc.nextInt();

             while(t != 0){
                 int n = sc.nextInt();
                 int sum = 0;
                 for(int i = 0; i < n; i++){
                     sum += sc.nextInt(); 
                 }
                 System.out.println(sum);
                 t--;
             }
         }
     }
     ```



## a+b(6)
- ### 题目描述
  - 计算a+b






## a+b(7)
- ### 题目描述
  - 计算a+b
  






### END
