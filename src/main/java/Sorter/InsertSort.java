package Sorter;

import java.util.function.BiFunction;

public class InsertSort<Type> extends Sorter<Type>{
    public InsertSort() {
        super();
    }

    @Override
    public Type[] sort() {
        for (int i = 0; i < list.length; i++) {
            Type key = list[i];

            int j = i-1;

            while (j >= 0 && bif.apply(list[j], key) * orderBy == 1){
                list[j+1] = list[j];
                j--;
            }

            list[j+1] = key;
        }

        return list;
    }

    public String getName(){ return "InsertSort"; }
}
