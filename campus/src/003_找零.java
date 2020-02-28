//3-找零
//思路：本题比较简单，可采用整除、取余、相减、求和的纯数学思路求解

import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = 1024-n;
        int c1 = c/64;
        int c2 = (c%64)/16;
        int c3 = (c%64%16)/4;
        int c4 = (c%64%16%4)/1;
        int count = c1+c2+c3+c4;
        System.out.println(count);
    }
}