//5-员工考勤记录
//思路：纯数学问题，可用排列组合公式分别取0,1,2，并求和。注意边界值是否符合。
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1+n+(n*(n-1)/2);
        System.out.println(count);
    }
}