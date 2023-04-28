package Sorter;

import java.util.function.BiFunction;

public class MergeSort<Type> extends Sorter<Type> {
    public MergeSort() {
        super();
    }

    @Override
    public Type[] sort( ){
        Type[] temp = (Type[]) new Object[list.length];

        return mergeMain( list, temp, 0, list.length - 1);
    }

    private Type[] mergeMain(Type[] list, Type[] temp, int left, int right) {
        int mid;

        if (left < right) {
            mid = (left + right) / 2;
            mergeMain(list, temp, left, mid);
            mergeMain(list, temp, mid + 1, right);
            merge(list, temp, left, mid + 1, right);
        }
        return list;
    }

    private void merge(Type[] list, Type[] temp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int numElem = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (bif.apply(list[leftPos], list[rightPos]) * orderBy < 1)
                temp[tempPos++] = list[leftPos++];
            else
                temp[tempPos++] = list[rightPos++];
        }

        while (leftPos <= leftEnd)
            temp[tempPos++] = list[leftPos++];
        while (rightPos <= rightEnd)
            temp[tempPos++] = list[rightPos++];
        for (int i = 0; i < numElem; i++, rightEnd--)
            list[rightEnd] = temp[rightEnd];
    }

    public String getName(){ return "MergeSort"; }

}