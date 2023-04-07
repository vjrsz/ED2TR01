package Model;

import java.util.function.BiFunction;

public class SelectSort<Type> extends Sorter{

    public SelectSort() {
        super();
    }

    public void sort(BiFunction bif){
        System.out.println("Select sort running...");
        
        Type[] list = (Type[]) super.list;
        
        for (int i = 0; i < 2; i++) {
            bif.apply(list[i], list[i]);
        }
    }
}
