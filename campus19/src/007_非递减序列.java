//
//
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        String unSplStr=Input.next();
        String[] unSeqStr=unSplStr.split(" ");
        int[] unSeqInt=new int[unSeqStr.length];
             
        for(int i=0;i<unSeqStr.length;i++) {
            unSeqInt[i]=Integer.parseInt(unSeqStr[i]);
        }
        
        int flag = 0;
        
        for(int j=0; j<unSeqInt.length-1; j++)
        {
            if(unSeqInt[j]>unSeqInt[j+1])
            {
                flag++;
                unSeqInt[j]=unSeqInt[j+1];
                j=-1;
            }
        }
        
        if(flag>1)
            System.out.println(0);
        else
            System.out.println(1);

    }
}