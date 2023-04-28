package Sorter;

public class QuickSort<Type> extends Sorter<Type> {
    public QuickSort() { super(); }

    @Override
    public Class<Type> getType() {
        return super.getType();
    }

    @Override
    public Type[] sort(){

        quick(0, list.length - 1);

        return list;
    }

    public void quick(int init, int end) {
        if(init < end){
            int positionPivot = partition(list, init, end);

            quick(init, positionPivot - 1);
            quick(positionPivot + 1, end);
        }
    }

    public int partition(Type[] list, int init, int end){
        Type pivot = list[init + (end - init)/2];
        int i = init + 1, e = end;

        while(i <= e){
            if ( bif.apply(list[i], pivot) >= 0) i++;
            else if ( bif.apply(pivot, list[e]) > 0) e--;
            else{
                Type swap = list[i];
                list[i] = list[e];
                list[e] = swap;
                i++;
                e--;
            }
        }

        list[init] = list[e];
        list[e] = pivot;
        return e;
    }

    @Override
    public String getName() {
        return "QuickSort";
    }
}
/**
 * public static void quicksort(int[] arr, int low, int high) {
 *     if (low < high) {
 *         int pivotIndex = partition(arr, low, high);
 *         quicksort(arr, low, pivotIndex - 1);
 *         quicksort(arr, pivotIndex + 1, high);
 *     }
 * }
 *
 * private static int partition(int[] arr, int low, int high) {
 *     int pivot = arr[high];
 *     int i = low - 1;
 *     for (int j = low; j <= high - 1; j++) {
 *         if (arr[j] < pivot) {
 *             i++;
 *             swap(arr, i, j);
 *         }
 *     }
 *     swap(arr, i + 1, high);
 *     return i + 1;
 * }
 *
 * private static void swap(int[] arr, int i, int j) {
 *     int temp = arr[i];
 *     arr[i] = arr[j];
 *     arr[j] = temp;
 * }
 */