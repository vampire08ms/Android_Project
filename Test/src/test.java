public class test {

	/* ≤Â»Î≈≈–Ú */
	public static <T> void InsertionSort(int[] array1) {
		int n = array1.length;
		int temp = 0;

		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (array1[j] < array1[j - 1]) {
					temp = array1[j - 1];
					array1[j - 1] = array1[j];
					array1[j] = temp;
				} else {
					break;
				}
			}
		}
	};

	/* œ£∂˚≈≈–Ú */
	public static void ShellSort(int[] array1) {
		int n = array1.length;
		int temp = 0;
		int step = 0; /* ‘ˆ¡ø */
		int i = 0;
		int j = 0;
		int k = 0;

		for (step = n / 2; step > 0; step /= 2) {
			for (i = 0; i < step; i++) {
				for (j = i; j + step < n; j = j + step) {
					if (array1[j] > array1[j + step]) {
						temp = array1[j];
						array1[j] = array1[j + step];
						array1[j + step] = temp;
					}
				}
			}
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = new int[] { 1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5,
				5, 7, 7 };
		// InsertionSort(array1);
		//
		// for (int n = 0; n < array1.length; n++) {
		// System.out.print(array1[n]+" ");
		// }

//		 int[] shellArray = new int[] { 49, 38, 65, 97, 76, 13, 27, 49, 55, 4
//		 };
//		 ShellSort(shellArray);
//		 for (int n = 0; n < shellArray.length; n++) {
//		 System.out.print(shellArray[n] + " ");
//		 }
//		 int[]a={49, 38, 65, 97, 76, 13, 27, 49, 55, 4, 3, 1};
//	        System.out.println("≈≈–Ú÷Æ«∞£∫");
//	        for(int i=0;i<a.length;i++)
//	        {
//	            System.out.print(a[i]+" ");
//	        }
//	        //œ£∂˚≈≈–Ú
//	        int d=a.length;
//	            while(true)
//	            {
//	                d=d/2;
//	                for(int x=0;x<d;x++)
//	                {
//	                    for(int i=x+d;i<a.length;i=i+d)
//	                    {
//	                        int temp=a[i];
//	                        int j;
//	                        for(  j=i-d;  j>=0&&a[j]>temp;  j=j-d )
//	                        {
//	                            a[j+d]=a[j];
//	                        }
//	                        a[j+d]=temp;
//	                    }
//	                }
//	                if(d==1)
//	                {
//	                    break;
//	                }
//	            }
//	            System.out.println();
//	            System.out.println("≈≈–Ú÷Æ∫Û£∫");
//	                for(int i=0;i<a.length;i++)
//	                {
//	                    System.out.print(a[i]+" ");
//	                }
		

		 
		 
	}
}
