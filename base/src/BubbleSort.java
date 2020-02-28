//冒泡排序

/*
两层循环

时间复杂度：O(n^2): O(n)--O(n^2)
空间复杂度：O(1)
稳定
内部排序
*/

public class BubbleSort  
{
	public static void bubbleSort(int[] arr)
	{
		int len = arr.length;
		for(int i=0; i<len-1; i++)
		{
			for (int j=0; j<len-1-i; j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

	}
	
	public static void main(String[] args) 
	{
		int[] array = {12,34,32,56,18,42};
		bubbleSort(array);
		for(int i=0; i<array.length; i++)
     		System.out.println("array["+i+"]="+array[i]);
	}
}
