package pointer.based.queue;

public class Kuyruk {

    Dugum head,tail;
    
    boolean kontrol = false;
    public void add(Dugum dugum)
    {
        if (!kontrol) {
            kontrol = true;
            head = dugum;
            tail = dugum;
        }else{
            Dugum temp = getTail();
            temp.sonraki = dugum;
            dugum.onceki = temp;
            tail = dugum;
        }
    }
    
    public void remove()
    {
        head = head.sonraki;
        head.onceki = null;
    } 
    
    private Dugum getTail() {
        return tail;
    }
    
    public void showAllMembers()
    {
        Dugum d = head;
        System.out.print("{");
        while (d != null) {            
            System.out.print(" "+d.value+" ");
            d = d.sonraki;
        }
        System.out.print("}\n");
    }
}
