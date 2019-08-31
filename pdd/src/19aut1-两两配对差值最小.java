//19秋03：两两配对差值最小

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i]=sc.nextInt();
        }
        //对数组中的数进行升序排序
        Arrays.sort(arr);
        //定义数组变量存储两数之和；题目规定n是偶数
        int[] sum = new int[n/2];
        //从数组的头、尾开始依次向里求和，需要两个变量
        for(int i=0,j=n-1;i<n/2;i++,j--)
        {
            sum[i]=arr[i]+arr[j];
        }
        //对所得求和数组进行排序
        Arrays.sort(sum);
        //作差并取绝对值得到所求
        int min = Math.abs(sum[0]-sum[n/2-1]);
        System.out.println(min);        
    }    
}