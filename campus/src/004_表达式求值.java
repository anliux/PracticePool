//4-表达式求值
//思路：根据三个数中1的个数分情况讨论

import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for(int i=0; i<3; i++)
        {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int max=0;
        if(arr[0]==1 && arr[1]==1 && arr[2]==1)
            max = 3;
        else if(arr[0]==1 && arr[2]>1)
            max = (arr[0]+arr[1])*arr[2];
        else 
            max = arr[0]*arr[1]*arr[2];
        System.out.println(max);
    }
}