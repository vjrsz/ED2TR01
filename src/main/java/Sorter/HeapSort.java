package Sorter;

import java.util.function.BiFunction;

public class HeapSort <Type> extends Sorter<Type>{

    public HeapSort() { super(); }

    @Override
    public Type[] sort() {
        for (int i = (list.length/2) - 1; i >= 0; i--) {
            heap( list, list.length, i);
        }

        for (int i = list.length - 1; i > 0 ; i--) {
            Type aux = list[0];
            list[0] = list[i];
            list[i] = aux;

            heap( list, i, 0);
        }

        return list;
    }


    private void heap(Type[] list, int len, int i){
        int root = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if ( left < len && bif.apply(list[left], list[root]) * orderBy == 1){
            root = left;
        }
        if ( right < len && bif.apply(list[right], list[root]) * orderBy == 1){
            root = right;
        }

        if ( root != i) {
            Type swap =  list[i];
            list[i] = list[root];
            list[root] = swap;

            heap( list, len, root );
        }
    }

    public String getName(){ return "HeapSort"; }
}
