package Sorter;

public class QMSort <Type> extends Sorter<Type> {
/**
 * Implemente um algoritmo denominado QM-Sort, combinação do QuickSort + MergeSorte.
 * Sabendo que o Quicksort é muito rápido em média, mas pode ser muito lento no pior caso.
 * Por outro lado, o Mergesort é sempre rápido, mas pode usar mais memória. Uma
 * combinação interessante é usar o Quicksort até um tamanho “T” do subvetor, e depois usar o
 * Mergesort para juntar os subvetores ordenados. Isso aproveita a rapidez do Quicksort na
 * maioria dos casos, mas evita o pior caso.
 */

    @Override
    public Type[] sort() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
/** def qm_sort(arr, t):
        if len(arr) < 2:
        return arr
        if len(arr) <= t:
        return quicksort(arr)
        else:
        mid = len(arr) // 2
        left = qm_sort(arr[:mid], t)
        right = qm_sort(arr[mid:], t)
        return merge(left, right)

        def quicksort(arr):
        if len(arr) < 2:
        return arr
        else:
        pivot = arr[0]
        less = [x for x in arr[1:] if x <= pivot]
        greater = [x for x in arr[1:] if x > pivot]
        return quicksort(less) + [pivot] + quicksort(greater)

        def merge(left, right):
        result = []
        i = j = 0
        while i < len(left) and j < len(right):
        if left[i] < right[j]:
        result.append(left[i])
        i += 1
        else:
        result.append(right[j])
        j += 1
        result += left[i:]
        result += right[j:]
        return result
 */
