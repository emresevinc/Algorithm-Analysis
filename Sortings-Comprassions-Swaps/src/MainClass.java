import java.util.Random;


public class MainClass {
	public static void SelectionSort ( int [] num )
	{
	     int i, j, first, temp,swap=0,compresion=0;  
	     for ( i = num.length - 1; i > 0; i -- )  
	     {
	          first = 0; 
	          for(j = 1; j <= i; j ++)   
	          {
	        	   compresion++;
	               if( num[ j ] < num[ first ] )         
	                 first = j;
	          },
	          swap++;
	          temp = num[ first ];   
	          num[ first ] = num[ i ];
	          num[ i ] = temp; 
	      }
	     System.out.println("\n Selection Sort icin gerceklestirilen swap sayisi : "+swap
	    		 +"\n Selection Sort icin gerceklestirilen compression sayisi : "+compresion+"\n");
	}
	
	public static void BubbleSort(int [] dizi)
	{
	    int temp,compression=0,swap=0;
	    for (int i=1; i<dizi.length; i++)
	    {
	        for(int j=0; j<dizi.length-i; j++)
	        {
	        	compression++;
	            if (dizi[j] < dizi [j+1])
	            {
	            	swap++;
	                temp = dizi [j];
	                dizi [j] = dizi [j+1];
	                dizi [j+1] = temp;
	            }
	        }
	    }
	    System.out.println("\n Bubble Sort icin gerceklestirilen swap sayisi : "+swap
	    		 +"\n Bubble Sort icin gerceklestirilen compression sayisi : "+compression+"\n");
	}
	
	public static void insertionSort(int[] list) {
	    int comps = 0, swaps = 0;
	    
	    for(int i = 1; i < list.length; i++) {
	    
	      int j = i;      
	            
	      // compare i with sorted elements and insert it
	      // sorted elements: [0..i-1]
	      while (j > 0 && list[j] < list[j - 1]) {
	        
	        int temp = list[j];
	        list[j] = list[j - 1];
	        list[j - 1] = temp;
	        
	        swaps++;
	        comps++;  // loop condition true
	         
	        j--;
	      }
	      comps++; // checking loop condition when false
	    }
	    
	    System.out.println("\n Ýnsertion Sort icin gerceklestirilen swap sayisi : "+swaps
	    		 +"\n Ýnsertion Sort icin gerceklestirilen compression sayisi : "+comps+"\n");
	  }
	
	
	public static void shell(int[] a) {
		int swap=0,comprassion=0;
		int increment = a.length / 2;
		while (increment > 0) {
			for (int i = increment; i < a.length; i++) {
				int j = i;
				int temp = a[i];
				comprassion++;
				while (j >= increment && a[j - increment] > temp) {
					swap++;
					comprassion++;
					a[j] = a[j - increment];
					j = j - increment;
				}
				a[j] = temp;
			}
			if (increment == 2) {
				increment = 1;
			} else {
				increment *= (5.0 / 11);
			}
		}
		System.out.println("\n Shell Sort icin gerceklestirilen swap sayisi : "+swap
	    		 +"\n Shell Sort icin gerceklestirilen compression sayisi : "+comprassion+"\n");
	}
	
	
	public static void show(int[] arr){
		System.out.println("dizinin son hali: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void enterOfArray(int[] arr)
	{
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(1000);
		}
	}
	
	
	public static void main(String[] args) {
		
		int[] dizi1 = new int[10];
		int[] dizi2 = new int[50];
		int[] dizi3 = new int[100];
		int[] dizi4 = new int[200];
		
		
		enterOfArray(dizi1);
		int[] copyArr = dizi1.clone();
		int[] copyArr11 = dizi1.clone();
		int[] copyArr12 = dizi1.clone();
		show(dizi1);
		BubbleSort(dizi1);
		System.out.print("Bubble sort icin ");
		show(dizi1);
		SelectionSort(copyArr);
		System.out.print("Selection sort icin ");
		show(copyArr);
		insertionSort(copyArr11);
		System.out.print("Ýnsertion sort icin ");
		show(copyArr11);
		shell(copyArr12);
		System.out.print("Shell sort icin ");
		show(copyArr12);
		
		System.out.println("\n\n\n");
		
		enterOfArray(dizi2);
		int[] copyArr2 = dizi2.clone();
		int[] copyArr21 = dizi2.clone();
		int[] copyArr22 = dizi2.clone();
		show(dizi2);
		BubbleSort(dizi2);
		System.out.print("Bubble sort icin ");
		show(dizi2);
		SelectionSort(copyArr2);
		System.out.print("Selection sort icin ");
		show(copyArr2);
		insertionSort(copyArr21);
		System.out.print("Ýnsertion sort icin ");
		show(copyArr21);
		shell(copyArr22);
		System.out.print("Shell sort icin ");
		show(copyArr22);
		
		
		System.out.println("\n\n\n");
		
		enterOfArray(dizi3);
		int[] copyArr3 = dizi3.clone();
		int[] copyArr31 = dizi3.clone();
		int[] copyArr32 = dizi3.clone();
		show(dizi3);
		BubbleSort(dizi3);
		show(dizi3);
		System.out.print("Bubble sort icin ");
		SelectionSort(copyArr3);
		System.out.print("Selection sort icin ");
		show(copyArr3);
		insertionSort(copyArr31);
		System.out.print("Ýnsertion sort icin ");
		show(copyArr31);
		shell(copyArr32);
		System.out.print("Shell sort icin ");
		show(copyArr32);
		
		System.out.println("\n\n\n");
		
		enterOfArray(dizi4);
		int[] copyArr4 = dizi4.clone();
		int[] copyArr41 = dizi4.clone();
		int[] copyArr42 = dizi4.clone();
		show(dizi4);
		BubbleSort(dizi4);
		show(dizi4);
		System.out.print("Bubble sort icin ");
		SelectionSort(copyArr4);
		System.out.print("Selection sort icin ");
		show(copyArr4);
		insertionSort(copyArr41);
		System.out.print("Ýnsertion sort icin ");
		show(copyArr41);
		shell(copyArr42);
		System.out.print("Shell sort icin ");
		show(copyArr42);
		
	}
}
