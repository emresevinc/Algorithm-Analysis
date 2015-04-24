//Bu çalışmada Binary Search Tree'nin ortalama karmaşıklığının yaklaşık logN olduğu ispatlanmaya çalışılmıştır.

package bst;

public class BST {
    Dugum root=null;
    
    private void insert(Dugum n)
    {
        if (root == null) {
            root = n;
        }else
        {
            Dugum temp = root;
            while(true)
            {
                if (n.deger > temp.deger) {
                    if (temp.right == null) {
                        temp.right = n;
                        break;
                    }else
                    {
                        temp = temp.right;
                    }
                }else if(n.deger < temp.deger)
                {
                    if (temp.left == null) {
                        temp.left = n;
                        break;
                    }else
                    {
                        temp = temp.left;
                    }
                }else
                {
                    System.out.println("Aynı değerli düğüm ekleyemezsiniz.");
                    break;
                }
            }
        }   
    }
    
    int genelSayac = 0;
    private void Search(int deger)
    {
        int sayac = 0;
        Dugum temp = root;
        while(true)
        {
            sayac++;
            if (deger > temp.deger) {
                if (temp.right == null) {
                    System.out.println("Aradığınız değer bulunamadı");
                    break;
                }
                else
                {
                    temp = temp.right;
                }
            }else if(deger < temp.deger)
            {
                if (temp.left == null) {
                    System.out.println("Aradığınız değer bulunamadı");
                    break;
                }else
                {
                    temp = temp.left;
                }
            }else
            {
                System.out.println("Aradığınız değer bulundu. Deger : "+deger);
                System.out.println("sayac : "+sayac);
                genelSayac += sayac;
                break;
            }
        }
    }
    public static void main(String[] args) {
        BST bst = new BST();
        Dugum d1 = new Dugum(10);
        Dugum d2 = new Dugum(20);
        Dugum d3 = new Dugum(8);
        Dugum d4 = new Dugum(1);
        Dugum d5 = new Dugum(9);
        Dugum d6 = new Dugum(25);
        Dugum d7 = new Dugum(15);
        bst.insert(d1);
        bst.insert(d2);
        bst.insert(d3);
        bst.insert(d4);
        bst.insert(d5);
        bst.insert(d6);
        bst.insert(d7);
        //System.out.println(bst.root.right.right.deger);
        bst.Search(10);
        bst.Search(8);
        bst.Search(1);
        bst.Search(9);
        bst.Search(25);
        bst.Search(15);
        bst.Search(20);
        System.out.println("\nTum elemanların search işleminde toplam adım : "+bst.genelSayac);
        System.out.println("logn : "+Math.log(bst.genelSayac)/Math.log(2) +"   ortalama adım = "+(double)bst.genelSayac / 7);
        // analiz işlemlerinde logN'de tabanı 2 kabul ediyoruz
    }
}
class Dugum
{
    int deger;
    Dugum right,left;
    
    public Dugum(int d) {
        this.deger = d;
        this.right = null;
        this.left = null;
    }
   
}

