package Service;

import Model.Invoice;
import Model.SelectSort;
import Model.Sorter;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SorterService {
    private static Map<Integer, Class<? extends Sorter>> sorters = new HashMap<>();

    static{
        SorterService.sorters.put(1, SelectSort.class);
    }

    public static Sorter getSorter(int choice) {
        Class<? extends Sorter> sorterClass = SorterService.sorters.get(choice);

        try {
            Sorter sorter = sorterClass.getDeclaredConstructor().newInstance();
            return sorter;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
