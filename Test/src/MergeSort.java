import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class MergeSort {  
    /** 
     * 归并排序 
     * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列 
     * 时间复杂度为O(nlogn) 
     * 稳定排序方式 
     * @param nums 待排序数组 
     * @return 输出有序数组 
     */  
   
	public static int[] sort( int[] array, int low, int high )
	{
		int middle = 0;
		
		if( high > 0)
		{
			middle = (low + high) / 2 ;
			if( low < high )
			{
				/* 左边部分 */
				sort(array, low, middle);
				/* 右边部分 */
				sort(array, middle+1, high);
				merge(array, low, middle, high);
			}
		}
		return array;
	}
	
	public static void merge( int array[], int low, int middle, int high )
	{
		int[] temp = new int[ high-low+1];
		int k = 0;
		int i = low;
		int j = middle+1;
		
		while(  i <= middle && j <= high )
		{
				if( array[i]< array[j] )
				{
					temp[k++]=array[i++];
				}
				else {
					temp[k++]=array[j++];
				}
		}
		
		while( i <= middle )
		{
			temp[k++]=array[i++];
		}
		
		while( j <= high )
		{
			temp[k++]=array[j++];
		}
		
		for( int count=0;  count<temp.length; count++ )
		{
			array[count+low]=temp[count];
		}
	}
      
    // 归并排序的实现  
    public static void main(String[] args) {  
  
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };  
  
        MergeSort.sort(nums, 0, nums.length-1);  
        System.out.println(Arrays.toString(nums));  
    }  
}  