//66 - 构建乘积数组
//不能使用除法，考虑从正面计算。
//使用直接累积相乘的形式时间复杂度较高 O(n^2)
//考虑从A[i]处分解为两部分，并从中寻找相应的规律。
//    根据矩阵图，下三角按从上到下并递归；上三角按从下到上并在下三角基础上累积乘积因子。

import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length!=0){
            B[0]=1;
            //下三角的部分：从上到下。根据规律，可以用上一行再乘以自己新的因子。
            for(int i=1; i<length; i++){
                B[i]=B[i-1]*A[i-1];
            }
            
            int temp=1;
            //上三角的部分：从下到上
            //注意：循环2是在循环1的基础上，所以可以直接用B[j]这样的表达
            for(int j=length-2; j>=0; j--){
                temp = temp*A[j+1];
                //需要在上一个循环的基础上进行累乘，并且是自乘，因为循环1已经累积了一些因子。
                B[j]=B[j]*temp;
            }
        }
        
        return B;
    }
}