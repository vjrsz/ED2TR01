package Sorter;

import java.util.function.BiFunction;

public class SelectSort<Type> extends Sorter<Type>{

    public SelectSort() {
        super();
    }

    @Override
    public Type[] sort(BiFunction<Type, Type, Integer> bif) {
        for (int i = 0; i < super.list.length; i++){
            int min = i;

            for (int j = i + 1; j < super.list.length; j++){
                if ( bif.apply(super.list[j], super.list[min]) * super.orderBy == -1 ){
                    min = j;
                }
            }

            Type aux = super.list[min];
            super.list[min] = super.list[i];
            super.list[i] = aux;
        }

        return super.list;
    }
}
