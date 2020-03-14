# OJ输入输出练习




# 类 Scanner
- 导包：`import java.util.Scanner;`
- 一个可以使用正则表达式来解析基本类型和字符串的简单文本扫描器。
- Scanner 使用分隔符模式将其输入分解为标记，默认情况下该分隔符模式与空白匹配。然后可以使用不同的 next 方法将得到的标记转换为不同类型的值。

- 从 System.in 中读取一个数：

     Scanner sc = new Scanner(System.in);
     int i = sc.nextInt();
 
再看一个例子，以下代码使 long 类型可以通过 myNumbers 文件中的项分配：

      Scanner sc = new Scanner(new File("myNumbers"));
      while (sc.hasNextLong()) {
          long aLong = sc.nextLong();
      }
扫描器还可以使用不同于空白的分隔符。下面是从一个字符串读取若干项的例子：

     String input = "1 fish 2 fish red fish blue fish";
     Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
     System.out.println(s.nextInt());
     System.out.println(s.nextInt());
     System.out.println(s.next());
     System.out.println(s.next());
     s.close(); 
输出为：

     1
     2
     red
     blue 


- 使用正则表达式同时解析所有的 4 个标记，并可以产生与上例相同的输出结果：

     String input = "1 fish 2 fish red fish blue fish";
     Scanner s = new Scanner(input);
     s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
     MatchResult result = s.match();
     for (int i=1; i<=result.groupCount(); i++)
         System.out.println(result.group(i));
     s.close(); 
     
     
  除非另行说明，否则将一个 null 参数传递到 Scanner 的任何一个方法中都将抛出 NullPointerException。   
     
     默认情况下扫描器会将数字解释为十进制形式，除非已经使用 useRadix(int) 方法设置了不同的基数。不管以前是否更改，reset() 方法将把扫描器的基数重置为10 。


     

- ## 常用方法
  - ### 布尔型：hasNext() 
          如果此扫描器的输入中有另一个标记，则返回 true。

hasNext(Pattern pattern) 
          如果下一个完整标记与指定模式匹配，则返回 true。
          
    hasNextInt() 
          如果通过使用 nextInt() 方法，此扫描器输入信息中的下一个标记可以解释为默认基数中的一个 int 值，则返回 true。      
   hasNextLine() 
          如果在此扫描器的输入中存在另一行，则返回 true。
          
          
          
          
 String next() 
          查找并返回来自此扫描器的下一个完整标记。
          
          
  int nextInt() 
          将输入信息的下一个标记扫描为一个 int。        
          
          
  String nextLine() 
          此扫描器执行当前行，并返回跳过的输入信息。
          
  String toString() 
          返回此 Scanner 的字符串表示形式
          
          

### END
