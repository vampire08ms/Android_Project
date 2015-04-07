import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class MergeSort {  
    /** 
     * �鲢���� 
     * ���:�����������������ϣ������ϲ���һ���µ������ ���Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ������������ 
     * ʱ�临�Ӷ�ΪO(nlogn) 
     * �ȶ�����ʽ 
     * @param nums ���������� 
     * @return ����������� 
     */  
   
	public static int[] sort( int[] array, int low, int high )
	{
		int middle = 0;
		
		if( high > 0)
		{
			middle = (low + high) / 2 ;
			if( low < high )
			{
				/* ��߲��� */
				sort(array, low, middle);
				/* �ұ߲��� */
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
      
    // �鲢�����ʵ��  
    public static void main(String[] args) {  
  
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };  
  
        MergeSort.sort(nums, 0, nums.length-1);  
        System.out.println(Arrays.toString(nums));  
    }  
}  