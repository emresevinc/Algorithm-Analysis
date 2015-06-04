package finalsinavisoru8;

import java.util.Random;
import java.util.Scanner;

public class FinalSinaviSoru8 {

    static int[] dizi = new int[1];
    static Random r = new Random();
    static int sayi;
    
    private static void resize() {
        dizi = new int[sayi];
        for (int i = 0; i < sayi; i++) {
            dizi[i] = r.nextInt(1000);
        }
        for (int j = sayi-1; j >=0; j--) {
            System.out.println(dizi[j]+"\n");
        }
    }
    
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Kaç gireceksiniz : ");
        sayi = input.nextInt();
        if (sayi>1) {
            resize();
        }else
        {
            dizi[0] = r.nextInt(1000);
            System.out.println(dizi[0]);
        }
    }
    
}
