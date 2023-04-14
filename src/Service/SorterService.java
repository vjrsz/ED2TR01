package Service;

import Model.SelectSort;
import Model.Sorter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SorterService {
    private static Map<Integer, Class<? extends Sorter>> sorters = new HashMap<>();

    static{
        SorterService.sorters.put(1, SelectSort.class);
    }

    public static ArrayList<String> getNameSorters() {
        ArrayList<String> sorterNames = new ArrayList<>();

        for (Integer key : sorters.keySet()) {
            Class<? extends Sorter> sorterClass = sorters.get(key);

            try {
                String sorterName = sorterClass.getDeclaredConstructor().newInstance().getName();
                sorterNames.add(sorterName);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }

        return sorterNames;
    }

    public static Sorter getSorter(int choice) {
        Class<? extends Sorter> sorterClass = SorterService.sorters.get(choice);

        if ( choice == 1 ){
            return new SelectSort();
        }

        try {
            Sorter sorter = sorterClass.getDeclaredConstructor().newInstance();
            return sorter;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
