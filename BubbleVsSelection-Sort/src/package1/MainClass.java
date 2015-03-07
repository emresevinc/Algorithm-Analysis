package package1;

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
	          }
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
		show(dizi1);
		BubbleSort(dizi1);
		System.out.print("Bubble sort icin ");
		show(dizi1);
		SelectionSort(copyArr);
		System.out.print("Selection sort icin ");
		show(copyArr);
		
		System.out.println("\n\n\n");
		
		enterOfArray(dizi2);
		int[] copyArr2 = dizi2.clone();
		show(dizi2);
		BubbleSort(dizi2);
		System.out.print("Bubble sort icin ");
		show(dizi2);
		SelectionSort(copyArr2);
		System.out.print("Selection sort icin ");
		show(copyArr2);
		
		System.out.println("\n\n\n");
		
		enterOfArray(dizi3);
		int[] copyArr3 = dizi3.clone();
		show(dizi3);
		BubbleSort(dizi3);
		show(dizi3);
		System.out.print("Bubble sort icin ");
		SelectionSort(copyArr3);
		System.out.print("Selection sort icin ");
		show(copyArr3);
		
		System.out.println("\n\n\n");
		
		enterOfArray(dizi4);
		int[] copyArr4 = dizi4.clone();
		show(dizi4);
		BubbleSort(dizi4);
		show(dizi4);
		System.out.print("Bubble sort icin ");
		SelectionSort(copyArr4);
		System.out.print("Selection sort icin ");
		show(copyArr4);
	}
}
