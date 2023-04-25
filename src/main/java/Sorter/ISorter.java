package Sorter;

import java.util.function.BiFunction;

public interface ISorter<Type> {
    public Type[] sort(BiFunction<Type, Type, Integer> bif);
}
