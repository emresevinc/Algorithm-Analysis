package javaapplication7;


public class JavaApplication7 {

    public static void func(int []dizi)
    {
        int sayac = 0, max=0,basIndis=0;
        boolean kontrol = false;
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i] == 0) {
                sayac++;
                if (sayac > max) {
                    max = sayac;
                    if (kontrol==false) {
                        kontrol =  true;
                        basIndis = i-max+1;
                    }
                }
            }else
            {
                sayac =0;
                kontrol = false;
            }
        }
        System.out.println("basIndıs : "+basIndis+"\n max = "+max);
    }
    
    public static void main(String[] args) {
        int[] dizi = {1,0,0,1,1,0,0,0,1,0,0,1,0,0,0,0};
        func(dizi);
    }
    
}
