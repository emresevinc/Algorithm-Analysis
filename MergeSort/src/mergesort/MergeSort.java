package mergesort;

public class MergeSort {

    private int[] array;
    private int[] tempMergArr;
    private int length;
 
    public static void main(String a[]){
         
        int[] inputArr = {23 ,11 ,45 ,77 ,89 ,4 ,28 ,65 ,43 ,98};
        MergeSort mms = new MergeSort();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
    }
     
    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
 
    static int durumunSayısı = 0;
    private void doMergeSort(int lowerIndex, int higherIndex) {
        durumunSayısı++;
        System.out.println("durumun sayisi : "+durumunSayısı);
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            System.out.println("middle: "+middle+" lowerIndex : "+lowerIndex+" higherIndex : "+higherIndex);
            doMergeSort(lowerIndex, middle);
            System.out.println("middle: "+middle+" lowerIndex : "+lowerIndex+" higherIndex : "+higherIndex);
            doMergeSort(middle + 1, higherIndex);
            System.out.println("middle: "+middle+" lowerIndex : "+lowerIndex+" higherIndex : "+higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
            System.out.println("middle: "+middle+" lowerIndex : "+lowerIndex+" higherIndex : "+higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }

    
}
