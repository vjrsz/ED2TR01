package Model;

import java.util.function.BiFunction;

public class InsertSort <Type> extends Sorter<Type> {

    public InsertSort() {
        super();
    }

    public void sort(BiFunction<Type, Type, Integer> bif){
        // ordenacao
    }

    public String getName(){
        return "SelectSort";
    }
}
